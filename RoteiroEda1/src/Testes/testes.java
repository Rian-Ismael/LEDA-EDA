package Testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Roteiro.BubbleSort;
import Roteiro.InsertionSort;
import Roteiro.SelectionSort;

class testes {
	private SelectionSort<Integer> selectionSort = new SelectionSort<>();
	private InsertionSort<Integer> insertionSort = new InsertionSort<>();
	private BubbleSort<Integer> bubbleSort = new BubbleSort<>();
	
	@Test
	void testSelectionSort() {
		Integer[] array1 = {2, 3, 1, 0};
		Integer[] array2 = {0, 1, 2, 3};
		selectionSort.sort(array1);
		assertArrayEquals(array1, array2);
	}

	@Test
	void testInsertionSort() {
		Integer[] array1 = {2, 3, 1, 0};
		Integer[] array2 = {0, 1, 2, 3};
		insertionSort.sort(array1);
		assertArrayEquals(array1, array2);
	}
	
	@Test
	void testbubbleSort() {
		Integer[] array1 = {2, 3, 1, 0};
		Integer[] array2 = {0, 1, 2, 3};
		bubbleSort.sort(array1);
		assertArrayEquals(array1, array2);
	}
}
