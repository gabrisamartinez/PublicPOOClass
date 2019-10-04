package br.com.univille.poo.jdbc;

import java.util.Date;

public class Tarefa {
	private int id;
	private String descricao;
	private boolean ativa;
	private Date dataInicial;
	private Date dataFinal;
	private Pessoa usuarioId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(boolean active) {
		this.ativa = active;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Pessoa getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Pessoa usuarioId) {
		this.usuarioId = usuarioId;
	}
}
