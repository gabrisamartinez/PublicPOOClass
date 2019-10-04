package br.com.univille.poo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO extends BasicoDAO {
	public void insert(Tarefa tarefa) {

		String sql = " insert into TAREFA(descricao, ativa, data_inicial, da_final, usuario_id) values(?,?,?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, tarefa.getDescricao());
			statement.setBoolean(2, tarefa.isAtiva());
			statement.setDate(3, new java.sql.Date(tarefa.getDataInicial().getTime()));
			statement.setDate(4, new java.sql.Date(tarefa.getDataFinal().getTime()));
			statement.setObject(5, tarefa.getUsuarioId());
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletar uma tarefa pelo id
	 * @param tarefa
	 */
	public void delete(Tarefa tarefa) {
		
		String sql = " delete from tarefa where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, tarefa.getId());
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualizar uma tarefa pelo id
	 * @param tarefa
	 */
	public void update(Tarefa tarefa) {
		String sql = " update tarefa set descricao = ?, ativa = ?, data_inicial = ?, da_final = ?, where id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setInt(5, tarefa.getId());
			statement.setString(1, tarefa.getDescricao());
			statement.setBoolean(2, tarefa.isAtiva());
			statement.setDate(3, new java.sql.Date(tarefa.getDataInicial().getTime()));
			statement.setDate(4, new java.sql.Date(tarefa.getDataFinal().getTime()));
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obter uma tarefa pelo id
	 * @param id
	 * @return
	 */
	public Tarefa getById(int id) {
		Tarefa tarefa = null;
		String sql = " select id, descricao, ativa, data_inicial, da_final, usuario_id from tarefa where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				tarefa = new Tarefa();
				tarefa.setId(resultSet.getInt(1));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tarefa;
	}
	
	/**
	 * Obter todas as pessoas da tabel
	 * @return
	 */
	public List<Tarefa> getAll(){
		List<Tarefa> list = new ArrayList<>();
		String sql = " select id, descricao, ativa, data_inicial, da_final, usuario_id from tarefa order by id";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(resultSet.getInt(1));
				
				
				list.add(tarefa);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
