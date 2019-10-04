package br.com.univille.poo.jdbc;

import java.util.Date;

public class Pessoa {
	
	private int id;
	private String nome;
	private String identificacaoFederal;
	private Date dataNascimento;
	private Date dataCriacao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdentificacaoFederal() {
		return identificacaoFederal;
	}
	public void setIdentificacaoFederal(String identificacaoFederal) {
		this.identificacaoFederal = identificacaoFederal;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
