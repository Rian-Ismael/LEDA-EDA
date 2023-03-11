package InsertionSortAlgoritmo;

public class Algoritmo<T extends Comparable<T>> {
    
    /*InsertionSort sem RightIndex e LeftIndex*/
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
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
    
	/*InsertionSort com RightIndex e LeftIndex*/
    public void insertionSort1(T[] array, int leftIndex, int rightIndex) {
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
    
    /* Selection implementado sem swap mas com IndexLeft e Right*/
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
    
    /*InsertionSort recursivo*/
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
