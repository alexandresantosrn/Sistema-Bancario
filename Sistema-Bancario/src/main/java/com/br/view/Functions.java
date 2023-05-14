package com.br.view;

import java.util.Scanner;

import com.br.model.Conta;
import com.br.repository.BDRepository;

public class Functions {

	Scanner input = new Scanner(System.in);
	BDRepository bd = new BDRepository();

	// Método que implementa o cadastro da conta.
	public void cadastrarConta() {

		Conta conta = new Conta();

		System.out.print("Informe o número da conta a ser criada: ");
		int numConta = input.nextInt();

		try {
			conta.setNumeroConta(numConta);
			conta.setSaldo(0.0);
			bd.adicionarConta(conta);
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

	// Método que implementa o crédito em uma conta.
	public void creditarConta() {

		System.out.print("Informe o número da conta desejada para consulta: ");
		int numConta = input.nextInt();

		Conta conta = bd.retornaContaByNumero(numConta);

		if (conta != null) {
			System.out.print(
					"Conta número: " + conta.getNumeroConta() + " localizada. Informe o valor a ser creditado: ");
			double valor = input.nextDouble();

			try {
				conta.creditarConta(valor);
				System.out.println("Credito realizado com sucesso!! Novo saldo: " + conta.getSaldo() + " \n");
			} catch (Exception e) {
				System.out.println("Erro na realização do cŕedito na conta!!" + " \n");
			}
		}

		else {
			System.out.println("Não foram localizadas contas bancária com o número informado." + " \n");
		}

	}

	// Método que implementa o débito em uma conta.
	public void debitarConta() {

		System.out.print("Informe o número da conta desejada para consulta: ");
		int numConta = input.nextInt();

		Conta conta = bd.retornaContaByNumero(numConta);

		if (conta != null) {
			System.out
					.print("Conta número: " + conta.getNumeroConta() + " localizada. Informe o valor a ser debitado: ");
			double valor = input.nextDouble();

			try {
				conta.debitarConta(valor);
				System.out.println("Débito realizado com sucesso!! Novo saldo: " + conta.getSaldo() + " \n");
			} catch (Exception e) {
				System.out.println("Erro na realização do cŕedito na conta!!" + " \n");
			}
		}

		else {
			System.out.println("Não foram localizadas contas bancária com o número informado." + " \n");
		}
	}

	// Método que implementa a transferência de recursos entre contas.
	public void transferirRecurso() {

		System.out.print("Informe o número da conta de origem: ");
		int numConta = input.nextInt();

		System.out.print("Informe o número da conta de destino: ");
		int numConta2 = input.nextInt();

		Conta conta1 = bd.retornaContaByNumero(numConta);
		Conta conta2 = bd.retornaContaByNumero(numConta2);

		if (conta1 != null || conta2 != null) {
			System.out.print("Contas localizadas. Informe o valor a ser transferido: ");
			double valor = input.nextDouble();

			try {
				conta1.debitarConta(valor);
				conta2.creditarConta(valor);
				System.out.println("Transferência realizada com sucesso!!");
				System.out.println("Saldo da conta de origem: " + conta1.getSaldo());
				System.out.println("Saldo da conta de destino: " + conta2.getSaldo() + " \n");
			} catch (Exception e) {
				System.out.println("Erro na realização do cŕedito na conta!!" + " \n");
			}
		}

		else {
			System.out.println("Não foram localizadas contas bancária com os números informados." + " \n");
		}
	}

}
