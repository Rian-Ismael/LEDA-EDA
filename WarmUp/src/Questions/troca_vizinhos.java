package Questions;

import java.util.Arrays;
import java.util.Scanner;

class troca_vizinhos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		
		String[] valores = sc.nextLine().split(" ");
		for(int i = 1; i < valores.length; i++) {
			String aux = valores[i-1];
			valores[i-1] = valores[i];
			valores[i] = aux;
			i++;
		}
		
		System.out.println(Arrays.toString(valores));
	}
}
