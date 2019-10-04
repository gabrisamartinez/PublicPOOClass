package br.com.univille.poo.jdbc;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		PessoaDAO dao = new PessoaDAO();
		TarefaDAO tDao = new TarefaDAO();
		
		Pessoa p = new Pessoa();
		p.setNome("Gabrielly");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, 10, 26);
		p.setDataNascimento(calendar.getTime());
		p.setDataCriacao(new Date());
		p.setIdentificacaoFederal("482999819808");
		dao.insert(p);
		
		Tarefa t = new Tarefa();
		t.setDescricao("Fazer atividade Oracle");
		t.setAtiva(true);
		Calendar dataInicial = Calendar.getInstance();
		Calendar dataFinal = Calendar.getInstance();
		dataInicial.set(2019, 9, 01);
		dataFinal.set(2019, 10, 04);
		t.setDataInicial(dataInicial.getTime());
		t.setDataFinal(dataFinal.getTime());
		t.setUsuarioId(p);
		tDao.insert(t);
		
		System.out.println(dao.getById(1));
		System.out.println(tDao.getById(1));
		
		//implementa mais coisas ai :)
		
		for(Pessoa pessoa : dao.getAll()) {
			System.out.println(pessoa);
		}
		
		
		for(Tarefa tarefa : tDao.getAll()) {
			System.out.println(tarefa);
		}
	}

}
