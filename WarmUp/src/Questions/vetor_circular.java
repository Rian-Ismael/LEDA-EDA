package Questions;

import java.util.Scanner;

class vetor_circular {
	 
	 public static void main(String[] args) {
		 
		 Scanner sc = new Scanner(System.in);
			 
		 // sequencia de numeros
		 String[] numeros = sc.nextLine().split(" ");
		 
		 // repeticoes
		  int rep = Integer.parseInt(sc.nextLine());
		 
		 String out = "";
		 int i = 0;
		 int aux = 0;
		 while (rep != aux) {
			 out +=  numeros[i] + " ";
			 i++;
			 aux++;
			 if(i == numeros.length) {
				 i = 0;
			 }
			 }
			 
		 System.out.println(out.trim());
	 }
}
