package SelectionSortAlgoritmo;

public class Algoritmo {
	
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
}

