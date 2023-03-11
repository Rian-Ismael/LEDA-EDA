package SelectionSortAlgoritmo;

public class Algoritmo<T extends Comparable<T>> {
	
	/*Selection sort sem IndexLeft e Right*/
	public static void selectionSort(int[] arr) {
	    for (int i = 0; i < arr.length-1; i++) {
	        int minIdx = i; 
	        for (int j = i+1; j < arr.length; j++) {
	            if (arr[j] < arr[minIdx]) {
	                minIdx = j;
	            }
	        }
	        int temp = arr[i];
	        arr[i] = arr[minIdx];
	        arr[minIdx] = temp;
	    }
	}
	
	/* Selection implementado sem swap mas com IndexLeft e Right*/
    public void selectionSort(Integer[] vetor, int leftIndex, int rightIndex) {
        if (vetor.length != 0 && vetor != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < vetor.length) {
            for (int i = leftIndex; i <= rightIndex; i++) { /*rightIndex é o len */
                int indiceMenor = i;
                for (int j = i + 1; j <= rightIndex; j++) {
                    if (vetor[j] < vetor[indiceMenor]) {
                        indiceMenor = j; 
                    } 
                }
                int aux = vetor[indiceMenor];
                vetor[indiceMenor] = vetor[i];
                vetor[i] = aux;
            }


        }

    }
	
    /*Swap*/
    // TROCAS
    private void swap(T[] array, int i, int j) {
          T aux = array[i];
          array[i] = array[j];
          array[j] = aux;

        }
    
    /*Selection com Swap*/ 
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
 
    
    /*Selection Recursivo*/
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
}
