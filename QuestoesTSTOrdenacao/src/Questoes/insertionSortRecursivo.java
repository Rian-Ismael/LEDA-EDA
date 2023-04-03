package Questoes;

import java.util.Arrays;
import java.util.Scanner;

 class insertionSortRecursivo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arrayString = sc.nextLine().split(" ");
		
		int[] arrayInt = arrayToInt(arrayString);
		insertionRecursivo(arrayInt, 0);
	}
	
	
	private static int[] arrayToInt(String[] arrayString) {
		int[] arrayInt = new int[arrayString.length];
		for(int i = 0; i < arrayString.length; i++) {
			arrayInt[i] = Integer.parseInt(arrayString[i]);
		}
		return arrayInt;
	}
	
	public static void insertionRecursivo(int[] array, int indice) {
		if(indice == array.length-1) {
			
		
		} else {
			int j = indice + 1;
			while(j > 0 && array[j] < array[j - 1]) {
				int aux = array[j];
				array[j] = array[j - 1];
				array[j - 1] = aux;
				j--;
			}
			System.out.println(Arrays.toString(array));
			insertionRecursivo(array, indice+1);
		}
	}
	
}
