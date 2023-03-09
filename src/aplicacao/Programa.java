package aplicacao;

import entidades.Conta;
import entidades.ContaJuridica;
import entidades.ContaPoupanca;

public class Programa {

	public static void main(String[] args) {
		Conta conta = new Conta(100,"Alex",0.0);
		ContaJuridica cj = new ContaJuridica(123,"Lojas Renner",500000.00, 50000.00);
		System.out.println("Saldo da Conta = "+cj.getSaldo());
		
		// Upcasting
		// As conversões são naturais.
		// As subclasses são um tipo da Superclasse 
		
		Conta conta1 = cj;
		Conta conta2 = new ContaJuridica(456,"Lojas Americanas",0.0,100000.00);
		Conta conta3 = new ContaPoupanca(789,"Anna",7000.0,0.1);
		
		// Downcasting
		// As conversões precisam ser explicitadas 
		// A associação abaixo gera erro
		// ContaJuridica conta5 = conta2;
		
		// resolvendo o problema...
		ContaJuridica conta4 = (ContaJuridica)conta2;
		conta4.emprestimo(1000.0);
		
		// A associação abaixo não indica erro pelo compilador
		// mas indica erro na execução por que contaPoupanca
		// não herda de contaJuridica
		// ContaJuridica conta5 = (ContaJuridica)conta3;
		
		// Para evitar erros como o indicado anteriormente
		// pode ser utilizado o comando instanceof
		if (conta3 instanceof ContaJuridica) {
			ContaJuridica conta5 = (ContaJuridica)conta3;
			conta5.emprestimo(200.0);
			System.out.println("Empréstimo Realizado!");
		}
		
		if (conta3 instanceof ContaPoupanca) {
			ContaPoupanca conta5 = (ContaPoupanca)conta3;
			conta5.atualizarSaldo();
			System.out.println("Saldo Atualizado!");
		}		
	}
}
