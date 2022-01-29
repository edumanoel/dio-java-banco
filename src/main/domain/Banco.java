package main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Banco {

	private int idBanco;
	private String nome;
	private List<Agencia> agencias = new ArrayList<>();

	public Banco(int idBanco, String nome) {
		this.idBanco = idBanco;
		this.nome = nome;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public String getNome() {
		return nome;
	}

	public List<Agencia> getAgencias() {
		return agencias;
	}

	public void criarAgencia(int numeroAgencia) {
		this.agencias.add(new Agencia(this, numeroAgencia));
	}

	@Override
	public int hashCode() {
		return Objects.hash(idBanco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		return Objects.equals(idBanco, other.idBanco);
	}

}
