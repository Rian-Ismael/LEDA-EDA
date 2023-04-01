package Questions;

import java.util.Scanner;

class elementos_duplicados {
	
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 String[] entrada = sc.nextLine().split(" ");
		 System.out.println((verificador(entrada)));
	 }


	public static boolean verificador(String[] valores) {
		 for(int i = 0; i < valores.length; i++) {
			  for(int j = 0; j < valores.length; j++) {
				  if(valores[j].equals(valores[i]) && i != j) {
					  return true;
				  }
			  }
		 }
		return false;
		}
	}
