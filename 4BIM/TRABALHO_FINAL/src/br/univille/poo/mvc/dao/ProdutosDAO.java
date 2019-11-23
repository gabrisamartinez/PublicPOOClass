package br.univille.poo.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univille.poo.mvc.model.Produto;

public class ProdutosDAO extends BasicDao {
	public void insert(Produto produto) {

		String sql = " insert into PRODUTO(id, nome, codigo_de_barras, preco) values(?,?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setLong(1, produto.getId());
			statement.setString(2, produto.getNome());
			statement.setString(3, produto.getCodigoDeBarras());
			statement.setString(4, produto.getPreco());
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletar uma tarefa pelo id
	 * @param produto
	 */
	public void delete(Produto produto) {
		
		String sql = " delete from PRODUTO where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setLong(1, produto.getId());
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualizar uma produto pelo id
	 * @param produto
	 */
	public void update(Produto produto) {
		String sql = " update PRODUTO set nome = ?,codigo_de_barras = ?, preco = ?, where id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setLong(4, produto.getId());
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getCodigoDeBarras());
			statement.setString(3, produto.getPreco());
			
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obter uma produto pelo id
	 * @param id
	 * @return
	 */
	public Produto getByCode(String codigoDeBarras) {
		Produto produto = null;
		String sql = " select id, nome, codigo_de_barras, preco from tarefa where codigo_de_barras = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, codigoDeBarras);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				produto = new Produto();
				produto.setId(resultSet.getLong(1));
				produto.setNome(resultSet.getString(2));
				produto.setCodigoDeBarras(resultSet.getString(3));
				produto.setPreco(resultSet.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}
	
}
