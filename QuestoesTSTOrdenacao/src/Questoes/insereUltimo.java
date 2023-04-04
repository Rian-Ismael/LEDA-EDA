package Questoes;

import java.util.Arrays;
import java.util.Scanner;

 class insereUltimo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] arrayString = sc.nextLine().split(" ");

		int[] arrayInt = new int[arrayString.length];
		
		for(int i = 0; i < arrayString.length; i++) {
			arrayInt[i] = Integer.parseInt(arrayString[i]);
		}

		int j = arrayInt.length-1;
		while(j>0 && arrayInt[j] < arrayInt[j-1]) {
			int aux = arrayInt[j];
			arrayInt[j] = arrayInt[j-1];
			arrayInt[j-1] = aux;
			j--;
		}
		System.out.println(Arrays.toString(arrayInt));
	}
}