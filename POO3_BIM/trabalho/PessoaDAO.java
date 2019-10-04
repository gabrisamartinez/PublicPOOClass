package br.com.univille.poo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Pessoa Data Acess Object
 * @author lerandersonandre but reconfigurate by gabrielly rsrs
 *
 */
public class PessoaDAO extends BasicoDAO{
	public void insert(Pessoa pessoa) {

		String sql = " insert into pessoa(nome, identificacao_federal, data_nascimento, data_criacao) values(?,?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getIdentificacaoFederal());
			statement.setDate(3, new java.sql.Date(pessoa.getDataNascimento().getTime()));
			statement.setDate(4, new java.sql.Date(pessoa.getDataCriacao().getTime()));
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletar uma pessoa pelo id
	 * @param pessoa
	 */
	public void delete(Pessoa pessoa) {
		
		String sql = " delete from pessoa where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, pessoa.getId());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualizar uma pessoa pelo id
	 * @param pessoa
	 */
	public void update(Pessoa pessoa) {
		String sql = " update pessoa set nome = ?, identificacao_federal = ?, data_nascimento = ?, data_criacao = ? where id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getIdentificacaoFederal());
			statement.setDate(3, new java.sql.Date(pessoa.getDataNascimento().getTime()));
			statement.setDate(4, new java.sql.Date(pessoa.getDataCriacao().getTime()));
			statement.setInt(5, pessoa.getId());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obter uma pessoa pelo id
	 * @param id
	 * @return
	 */
	public Pessoa getById(int id) {
		Pessoa pessoa = null;
		String sql = " select id, nome, sobrenome from pessoa where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				pessoa = new Pessoa();
				pessoa.setId(resultSet.getInt(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setIdentificacaoFederal(resultSet.getString(3));
				pessoa.setDataNascimento(resultSet.getDate(4));
				pessoa.setDataCriacao(resultSet.getDate(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pessoa;
	}
	
	/**
	 * Obter todas as pessoas da tabel
	 * @return
	 */
	public List<Pessoa> getAll(){
		List<Pessoa> list = new ArrayList<>();
		String sql = " select id, nome, identificacao_federal, data_nascimento, data_criacao from pessoa order by nome";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getInt(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setIdentificacaoFederal(resultSet.getString(3));
				pessoa.setDataNascimento(resultSet.getDate(4));
				pessoa.setDataCriacao(resultSet.getDate(5));
				
				list.add(pessoa);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
