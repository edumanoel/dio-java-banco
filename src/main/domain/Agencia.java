package main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

public class Agencia {

	private int idAgencia;
	private Banco banco;
	private Endereco endereco;
	private List<Telefone> telefones = new ArrayList<>();
	private List<Conta> contas = new ArrayList<>();

	public Agencia(Banco banco, int idAgencia) {
		this.idAgencia = idAgencia;
		this.banco = banco;
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public Banco getBanco() {
		return banco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void addTelefone(Telefone telefone) {
		this.telefones.add(telefone);
	}

	public void removeTelefones(Telefone telefone) {
		this.telefones.remove(telefone);
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void addConta(Conta conta) {
		if (this.equals(conta.agencia))
				this.contas.add(conta);
	}
		
	public boolean removeConta(Conta conta) {
		if (conta.saldo == 0)
			return this.contas.remove(conta);
		else
			return false;
	}

	public Conta abrirConta(Pessoa cliente, OptionalInt poupancaVariacao) {
		if (poupancaVariacao.isPresent())
			return new ContaPoupanca(poupancaVariacao.getAsInt(), this, cliente);
		else
			return new ContaCorrente(this, cliente);
	}

	@Override
	public int hashCode() {
		return Objects.hash(banco, idAgencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		return Objects.equals(banco, other.banco) && idAgencia == other.idAgencia;
	}

}
