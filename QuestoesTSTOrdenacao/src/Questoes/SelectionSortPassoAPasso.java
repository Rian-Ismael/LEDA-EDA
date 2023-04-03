package Questoes;

import java.util.Arrays;
import java.util.Scanner;

 class SelectionSortPassoAPasso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arrayInt = arrayToInt(sc.nextLine().split(" "));
		
		for(int i = 0; i < arrayInt.length; i ++) {
			int i_menor = i;
			for(int j = i+1; j < arrayInt.length; j++) {
				if(arrayInt[j] < arrayInt[i_menor]) {
					i_menor = j;
				}
			}
			
		if(i != i_menor) {
			int aux = arrayInt[i];
			arrayInt[i] = arrayInt[i_menor];
			arrayInt[i_menor] = aux;
			System.out.println(Arrays.toString(arrayInt));
		}
		}
		
	}
	
	private static int[] arrayToInt(String[] arrayString) {
		int[] arrayInt = new int[arrayString.length];
		for(int i = 0; i < arrayString.length; i++) {
			arrayInt[i] = Integer.parseInt(arrayString[i]);
		}
		return arrayInt;
	}
}
