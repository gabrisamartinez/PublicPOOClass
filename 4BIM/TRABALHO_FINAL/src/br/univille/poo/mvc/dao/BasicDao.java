package br.univille.poo.mvc.dao;

import java.sql.Connection;

public abstract class BasicDao{
	
	
	public Connection getConnection() {
		return FabricaDeConexoes.getInstance().getConnection();
	}

}