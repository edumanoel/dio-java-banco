package main.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PessoaFisica extends Pessoa {

	private String cpf;
	private LocalDate dataNascimento;
	private Genero genero;

	public PessoaFisica(String nome, String cpf, String dataNascimento, Genero genero) {
		super(nome);
		this.cpf = cpf;
		this.dataNascimento = stringToLocalDate(dataNascimento);
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDocumento() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = stringToLocalDate(dataNascimento);
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public LocalDate stringToLocalDate(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(data, formatter);
		return localDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(cpf, other.cpf);
	}

}
