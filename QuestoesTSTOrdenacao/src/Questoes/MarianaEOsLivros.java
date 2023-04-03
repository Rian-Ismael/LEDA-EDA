package Questoes;

import java.util.Arrays;
import java.util.Scanner;

class MarianaEOsLivros {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] estante = sc.nextLine().split(", ");
		insertionLivros(estante);
	}
	
	public static void insertionLivros(String[] estante) {
		for(int i = 1; i < estante.length; i++) {
			int j = i;
			while(j > 0 && (estante[j].compareTo(estante[j-1]) < 0)) {
				String aux = estante[j-1];
				estante[j-1] = estante[j];
				estante[j] = aux;
				j--;
			}
			System.out.println(Arrays.toString(estante));
		}
	}
	
	
}
// se essa comparação for menor que 0, significa que
// estante[j] é menor que estante[j-1]
//<T extends Comparable<String>> 