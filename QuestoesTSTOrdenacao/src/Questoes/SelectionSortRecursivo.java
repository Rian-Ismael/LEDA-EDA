package Questoes;

import java.util.Arrays;
import java.util.Scanner;

 class SelectionSortRecursivo {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int[] arrayInt = arrayToInt(sc.nextLine().split(" "));
	selectionRecursivo(arrayInt, 0);
	
	
	}
	
	private static int[] arrayToInt(String[] arrayString) {
		int[] arrayInt = new int[arrayString.length];
		for(int i = 0; i < arrayString.length; i++) {
			arrayInt[i] = Integer.parseInt(arrayString[i]);
		}
		return arrayInt;
	}
	
	public static void selectionRecursivo(int[] array, int indice) {
		
		if(indice == array.length-1) {
			
		} else {
			int i_menor = indice;
			for(int j = indice+1; j < array.length; j++) {
				if(array[j] < array[i_menor]) {
					i_menor = j;
				
				}
			}
			if(indice != i_menor) {
				int aux = array[indice];
				array[indice] = array[i_menor];
				array[i_menor] = aux;
				
			}
			System.out.println(Arrays.toString(array));
			selectionRecursivo(array, indice+1);
		}
	}
}
