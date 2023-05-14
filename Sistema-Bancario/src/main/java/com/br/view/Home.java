package com.br.view;

import java.util.Scanner;

public class Home {

	private static Scanner input;

	public static void main(String[] args) {

		int option = 1000;
		Functions functions = new Functions();
		
		input = new Scanner(System.in);

		// Carrega menu para interação com usuário.
		while (option != 0) {

			System.out.println("Caro cliente, informe a opção desejada:");
			System.out.println("1 - Cadastrar Conta");
			System.out.println("2 - Consultar Saldo");
			System.out.println("3 - Creditar Conta");
			System.out.println("4 - Debitar Conta");
			System.out.println("5 - Transferir Recursos");
			System.out.println("0 - Sair");
			System.out.print("Selecionar opção: ");
			option = input.nextInt();

			switch (option) {

			case 1:
				functions.cadastrarConta();
				break;
			
			case 2:
				functions.consultarSaldo();
				break;
				
			case 3:
				functions.creditarConta();
				break;	
				
			case 0:
				break;

			default:
				System.out.println("Opção inválida. Escolha uma opção entre 0 e 5!!" + " \n");
				break;
			}

		}

		System.out.println(" \n" + "Até Logo!!!");

	}

}
