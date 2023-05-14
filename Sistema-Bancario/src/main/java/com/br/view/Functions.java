package com.br.view;

import java.util.Scanner;

import com.br.model.Conta;
import com.br.repository.BDRepository;

public class Functions {

	Scanner input = new Scanner(System.in);
	BDRepository bd = new BDRepository();

	// Método que implementa o cadastro da conta.
	public void cadastrarConta() {

		Conta c1 = new Conta();

		System.out.print("Informe o número da conta a ser criada: ");
		int numConta = input.nextInt();

		try {
			c1.setNumeroConta(numConta);
			c1.setSaldo(0.0);
			bd.adicionarConta(c1);
			System.out.println("Conta cadastrada com sucesso!!" + " \n");
		} catch (Exception e) {
			System.out.println("Erro na criação da conta!!" + " \n");
		}

	}

	// Método que implementa a consulta do saldo da conta.
	public void consultarSaldo() {

		System.out.print("Informe o número da conta desejada para consulta: ");
		int numConta = input.nextInt();

		Conta conta = bd.retornaContaByNumero(numConta);

		if (conta != null) {
			System.out.println("Saldo da conta desejada: " + conta.getSaldo() + " \n");
		}

		else {
			System.out.println("Não foram localizadas contas bancária com o número informado." + " \n");
		}

	}

}
