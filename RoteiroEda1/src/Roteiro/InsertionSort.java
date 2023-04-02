package Roteiro;

public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {

	@Override
	public void sort(T[] elements) {
		for(int i = 1; i < elements.length; i++) {
			int j = i;
			while(j > 0 && elements[j].compareTo(elements[j-1]) < 0) {
				T aux = (T) elements[j];
				elements[j] = elements[j-1];
				elements[j-1] = aux;
				j--;
			}
		}
	}


}
