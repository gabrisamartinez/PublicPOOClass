package br.univille.poo.mvc.control;

import br.univille.poo.mvc.model.Produto;
import br.univille.poo.mvc.view.CadastroPessoaView;

public class CadastroPessoaControl {
	
	private CadastroPessoaView view;
	private Produto model;
	
	public CadastroPessoaControl(CadastroPessoaView view, Produto model) {
		this.view = view;
		this.model = model;
		model.attach(view);
		view.setModel(model);
		view.setControl(this);
	}
	
	public void exibirTela() {
		view.show();
		model.notifyObservers();
	}

	public void deletar() {
		model.deletar();
		view.setMensagemStatusBar("Registro deletado.");
		view.getBotaoDeletar().setEnabled(false);
	}

	public void novo() {
		model.novoRegistro();
		view.getBotaoDeletar().setEnabled(false);
		view.setMensagemStatusBar("Registro novo.");
	}
	
	public void salvar() {
		model.setNome(view.getName());
		model.setCodigoDeBarras(view.getCodigoDeBarras());
		model.setPreco(view.getPreco());
		
		try {
			model.salvar();
			view.setMensagemStatusBar("Registro salvo com sucesso.");
			view.getBotaoDeletar().setEnabled(true);
		} catch(Exception e) {
			e.printStackTrace();
			view.setMensagemStatusBar("Erro: "+e.getMessage());
		}
	}
	
	public void pesquisar() throws Exception {
		model.setCodigoDeBarras(view.getCodigoDeBarras());
		model.pesquisar();
	}

}
