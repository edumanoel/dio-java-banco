package main.domain;

public class ContaPoupanca extends Conta {
	
	private int variacao;

	public ContaPoupanca(int variacao, Agencia agencia, Pessoa cliente) {
		super(agencia, cliente);
		this.variacao = variacao;
	}

	public int getVariacao() {
		return variacao;
	}
	
}
