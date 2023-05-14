package com.br.view;

import java.util.Scanner;

import com.br.model.Conta;

public class Functions {

	Scanner input = new Scanner(System.in);

	// Método que implementa o cadastro da conta.
	public void cadastrarConta() {

		Conta c1 = new Conta();

		System.out.print("Informe o número da conta a ser criada: ");
		int numConta = input.nextInt();

		try {
			c1.setNumeroConta(numConta);
			c1.setSaldo(0.0);
			System.out.println("Conta cadastrada com sucesso!!" + " \n");
		} catch (Exception e) {
			System.out.println("Erro na criação da conta!!" + " \n");
		}

	}

}
