package com.sistema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TratamentoExc {
	
	private static Scanner input;

	public static int lerInt() {
		input = new Scanner(System.in);
		
		while (true) {
			try {
				int valor = input.nextInt();
				return valor;
				
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
			} finally {
				input.nextLine();
			}
		}
		
	}
	
	public static double lerDouble() {
		input = new Scanner(System.in);
		
		while (true) {
			try {
				double valor = input.nextDouble();
				return valor;
				
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida.");
			} finally {
				input.nextLine();
			}
		}
		
	}
}
