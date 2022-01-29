package main.domain;

import java.util.Objects;

public abstract class Conta {

	private static int SEQUENCIAL = 1;

	protected Agencia agencia;
	protected int idConta;
	protected double saldo;
	protected Pessoa cliente;

	public Conta(Agencia agencia, Pessoa cliente) {
		this.idConta = SEQUENCIAL++;
		this.agencia = agencia;
		this.cliente = cliente;
	}

	public boolean sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			return true;
		} else
			return false;
	}

	public boolean depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			return true;
		} else
			return false;
	}

	public boolean transferir(double valor, Conta contaDestino) {
		if (this.sacar(valor)) {
			contaDestino.depositar(valor);
			return true;
		} else
			return false;
	}

	public int getIdConta() {
		return idConta;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.print(String.format("Banco: %d ", this.agencia.getBanco().getIdBanco()));
		System.out.println(String.format("%s", this.agencia.getBanco().getNome()));
		System.out.print(String.format("Agencia: %d ", this.agencia.getIdAgencia()));
		System.out.println(String.format("Conta: %d", this.idConta));
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("CPF/CNPJ: %s", this.cliente.getDocumento()));
		System.out.println(String.format("Saldo R$: %.2f", this.saldo));
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, cliente, idConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(cliente, other.cliente)
				&& idConta == other.idConta;
	}

}
