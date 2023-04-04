package Questoes;

import java.util.Scanner;

class MarianaEOsLivros <T extends Comparable<String>>  {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] estante = sc.nextLine().split(",");
		insertionLivros(estante);
	}
	
	public static void insertionLivros(String[] estante) {
		String listaDeLivros = String.join(", ", estante);
		System.out.println(listaDeLivros);
		for(int i = 1; i < estante.length; i++) {
			String saida = "";
			int j = i;
			while(j > 0 && (estante[j].compareTo(estante[j-1]) < 0)) {
				String aux = estante[j-1];
				estante[j-1] = estante[j];
				estante[j] = aux;
				j--;
				
			}
			for(int k = 0; k < estante.length; k++) {
				if(k == estante.length-1) {
					saida += estante[k];
				} else {
				saida += estante[k] + ", ";
				}
			}
			System.out.println(saida);
		}
	}
}