package projetoLP;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	     System.out.println("Árvore de Expressões Aritméticas");

	        ExpreTree tree = new ExpreTree();
	        /*Expressões usadas para testes
	         * 
	         * e1 - Infix: (2+3)*4 Prefix: *+234
	         * res1 - 20
	         * e2 - Infix: 41*5+2*3 Prefix: +*45*23
	         * res2 - 26
	         * */
	        System.out.println("\nInserir equação na notação prefix: ");
	        tree.buildTree(scanner.next());
	 
	        System.out.print("\nPrefix:");
	        tree.prefix();
	        System.out.print("\nInfix:");
	        tree.infix();
	       
	       System.out.println("\nResultado = "+ tree.avaliaOperacao());
	}

}