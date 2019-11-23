package br.univille.poo.mvc.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.univille.poo.mvc.dao.ProdutosDAO;
import br.univille.poo.mvc.util.Observer;
import br.univille.poo.mvc.util.Subject;

public class Produto implements  Subject{
	
	private long id;
	private String nome;
	private String codigoDeBarras;
	private String preco;
	private List<Observer> list;
	
	public Produto() {
		list = new ArrayList<Observer>();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public List<Observer> getList() {
		return list;
	}

	public void setList(List<Observer> list) {
		this.list = list;
	}

	public void novoRegistro() {
		id = 0;
		nome = "";
		codigoDeBarras = "";
		preco = "";
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return "PessoaModel [id=" + id + ", nome=" + nome + ", codigoDeBarras=" + codigoDeBarras + ", preço=" + preco + "]";
	}
	
	
	@Override
	public void attach(Observer o) {
		list.add(o);
	}

	@Override
	public void detach(Observer o) {
		list.remove(o);
	}

	@Override
	public void notifyObservers() {
		// Avisa cada um dos observadores
		for(Observer o : list) {
			// Atualiza a informacao no observador
			o.update(this, this);
		}
	}
	
	public void deletar() {
		ProdutosDAO dao = new ProdutosDAO();
		Produto produto = new Produto();
		produto.setId(id);
		dao.delete(produto);
	}

	public void salvar() throws Exception {
		ProdutosDAO dao = new ProdutosDAO();
		
		if(codigoDeBarras == null || codigoDeBarras.isEmpty()) {
			throw new Exception("Código de Barras está inválido");
		}
		if(nome == null || nome.isEmpty()) {
			throw new Exception("Nome está inválido");
		}
		if(preco == null || preco.isEmpty()) {
			throw new Exception("Preço está inválido");
		}
		
		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(nome);
		produto.setCodigoDeBarras(codigoDeBarras);
		produto.setPreco(preco);
		
		//Novo registro
		if(id == 0) {
			// Gera um id
			id = (new Random()).nextInt(100);
			dao.insert(produto);
		}else {
			dao.update(produto);
		}
		notifyObservers();
	}
	
public Produto pesquisar() throws Exception {
		ProdutosDAO dao = new ProdutosDAO();
		Produto produto = dao.getByCode(codigoDeBarras);
		notifyObservers();
		
		return produto;
	}
}
