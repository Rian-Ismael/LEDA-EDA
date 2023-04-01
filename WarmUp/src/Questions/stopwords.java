package Questions;

import java.util.Arrays;
import java.util.Scanner;

public class stopwords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] valores = sc.nextLine().split(" ");
		String[] aSerRetirado = sc.nextLine().split(" ");
		String out = "";
		
		for(int i = 0; i < valores.length; i++) {
			if(!Arrays.asList(aSerRetirado).contains(valores[i])) {
				out += valores[i] + " ";
			}
		}
		System.out.println(out.trim());
	}
}
