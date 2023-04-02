package Testes;

import java.util.Arrays;

import Roteiro.BubbleSort;
import Roteiro.InsertionSort;
import Roteiro.SelectionSort;

public class Main {
	
	public static void main(String[] args) {
		
		SelectionSort<Integer> selectionSort = new SelectionSort<>();   // {1, 2, 3, 6}
		InsertionSort<Integer> insertionSort = new InsertionSort<>();   // {1, 2, 3, 6}
		BubbleSort<Integer> bubbleSort = new BubbleSort<>();			// {1, 2, 3, 6}
		Integer[] array1 = {2, 3, 1, 0};
		
		//selectionSort.sort(array1);
		//System.out.println(Arrays.toString(array1));
		
		//insertionSort.sort(array1);
		//System.out.println(Arrays.toString(array1));
		
		bubbleSort.sort(array1);
		System.out.println(Arrays.toString(array1));
	}
}
