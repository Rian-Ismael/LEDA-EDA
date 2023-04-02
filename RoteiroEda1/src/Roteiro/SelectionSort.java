package Roteiro;

public class SelectionSort<T extends Comparable<T>> implements Sorting<T>{

	@Override
	public void sort(T[] elements) {
		for(int i = 0; i < elements.length; i++) {
			int i_menor = i;
			for(int j = i + 1; j < elements.length; j++) {
				if((elements[i_menor].compareTo(elements[j])) > 0) {
					i_menor = j;
				}
			}

			T aux = (T) elements[i];
			elements[i] = elements[i_menor];
			elements[i_menor] = aux;
		}
	} 
	
}
