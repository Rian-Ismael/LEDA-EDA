package Questions;

import java.util.Scanner;

class warm_up_eda {

	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int n = Integer.parseInt(sc.nextLine());
		 
		 String[] valores = sc.nextLine().split(" ");
		 String out = "";
		 
		 for(int i = 0; i < valores.length; i++) {
			 out += Integer.parseInt(valores[i])*n + " ";
		 }
		 System.out.println(out.trim());
	 }
}
