package main.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

	protected String nome;
	protected List<Telefone> telefones = new ArrayList<>();
	protected List<Endereco> enderecos = new ArrayList<>();

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void addTelefones(Telefone telefone) {
		this.telefones.add(telefone);
	}

	public void removeTelefones(Telefone telefone) {
		this.telefones.remove(telefone);
	}

	public List<Endereco> getEndereco() {
		return enderecos;
	}

	public void addEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}

	public void removeEndereco(Endereco endereco) {
		this.enderecos.remove(endereco);
	}

	public abstract String getDocumento();

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);

}
