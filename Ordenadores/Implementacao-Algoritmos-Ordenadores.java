public class Ordenadores<T extends Comparable<T>> {
    // TROCAS
    private void swap(T[] array, int i, int j) {
        T aux = array[i];
        array[i] = array[j];
        array[j] = aux;

    }

    // BUBLLE SORT
    public void bubbleSort(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int i = leftIndex; i < rightIndex; i++) {
                    if (array[i].compareTo(array[i + 1]) > 0) {
                        this.swap(array, i, i + 1);
                        swapped = true;
                    }
                }
            }

        }

    }

    public void bubbleSortRecursivo(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    this.swap(array, i, i + 1);
                }
            }
            bubbleSortRecursivo(array, leftIndex, rightIndex - 1);
        }

    }

    // SELECTION SORT
    public void selectionSort(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                int indiceMenor = i;
                for (int j = i + 1; j <= rightIndex; j++) {
                    if (array[j].compareTo(array[indiceMenor]) < 0) {
                        indiceMenor = j;
                    }
                }
                swap(array, i, indiceMenor);
            }

        }

    }

    public void selectionSortRecursivo(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            int indiceMenor = leftIndex;
            for (int j = leftIndex + 1; j <= rightIndex; j++) {
                if (array[j].compareTo(array[indiceMenor]) < 0) {
                    indiceMenor = j;
                }
            }
            swap(array, leftIndex, indiceMenor);
            selectionSortRecursivo(array, leftIndex + 1, rightIndex);
        }

    }

    // Insertion SORT
    public void insertionSort(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            for (int i = leftIndex + 1; i <= rightIndex; i++) {
                int j = i;
                while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
                    swap(array, j, j - 1);
                    j--;
                }

            }

        }

    }

    public void insertionSortRecursivo(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                }

            }
            insertionSortRecursivo(array, leftIndex, rightIndex - 1);

        }

    }

}


1 package sorting.divideAndConquer.hybridMergesort;
2   
3   import sorting.AbstractSorting;
4   import util.Util;
5   
6   /**
7    * A classe HybridMergeSort representa a implementação de uma variação do
8    * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
9    * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
10   * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
11   * o InsertionSort.
12   * 
13   * A implementação híbrida deve considerar os seguintes detalhes:
14   * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
15   *   que essa informação possa ser capturada pelo teste.
16   * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
17   *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
18   *   INSERTIONSORT_APPLICATIONS são incrementados.
19   * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
20   */
21  public class HybridMergeSort<T extends Comparable<T>> extends
22  		AbstractSorting<T> {
23  
24  	/**
25  	 * For inputs with size less or equal to this value, the insertionsort
26  	 * algorithm will be used instead of the mergesort.
27  	 */
28  	public static final int SIZE_LIMIT = 4;
29  
30  	protected static int MERGESORT_APPLICATIONS = 0;
31  	protected static int INSERTIONSORT_APPLICATIONS = 0;
32  
33  	public void sort(T[] array, int leftIndex, int rightIndex) {
34  		MERGESORT_APPLICATIONS = 0;
35  		INSERTIONSORT_APPLICATIONS = 0;
36  		mergeSortHybrid(array, leftIndex, rightIndex);
37  	}
38  	
39  	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
40  		for (int index = leftIndex + 1; index <= rightIndex; index++) {
41  			int aux = index;
42  			while (aux > leftIndex && array[aux].compareTo(array[aux - 1]) == -1) {
43  				Util.swap(array, aux, aux - 1);
44  				aux--;
45  			}
46  		}
47  		INSERTIONSORT_APPLICATIONS += 1;
48  	}
49  	
50  	private void mergeSortHybrid(T[] array, int leftIndex, int rightIndex) {
51  		if (SIZE_LIMIT >= 0 && leftIndex >= 0 && rightIndex >= 0) { 
52  			if (leftIndex <= rightIndex) {
53  				if ((rightIndex - leftIndex + 1) <= SIZE_LIMIT) {
54  					insertionSort(array, leftIndex, rightIndex);
55  				}
56  				else {
57  					int medium = (leftIndex + rightIndex) / 2;
58  					mergeSortHybrid(array, leftIndex, medium);	
59  					mergeSortHybrid(array, medium + 1, rightIndex);		
60  					merge(array, leftIndex, medium, rightIndex);
61  				}
62  			}
63  		}
64  	}
65  	
66  	private void merge(T[] array, int leftIndex, int medium, int rightIndex) {
67  		T[] helper = helperAux(array);
68  		int index = leftIndex;
69  		int left = leftIndex;
70  		int right = medium + 1;
71  		
72  		while (left <= medium && right <= rightIndex) {
73  			if (helper[left].compareTo(helper[right]) == -1) {
74  				array[index] = helper[left];
75  				left++;
76  			}
77  			else {
78  				array[index] = helper[right];
79  				right++;
80  			}
81  			index++;
82  		}
83  		while (left <= medium) {
84  			array[index] = helper[left];
85  			index++;
86  			left++;
87  		}
88  		while (right <= rightIndex) {
89  			array[index] = helper[right];
90  			index++;
91  			right++;
92  		}
93  		MERGESORT_APPLICATIONS += 1;
94  	}
95  	
96  	private T[] helperAux(T[] array) {
97  		T[] helper = (T[]) new Comparable[array.length];
98  		for (int i = 0; i < array.length; i++) {
99  			helper[i] = array[i];
100 		}
101 		return helper;
102 	}
103 }
