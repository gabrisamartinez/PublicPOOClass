package br.univille.poo.mvc;

import br.univille.poo.mvc.control.CadastroPessoaControl;
import br.univille.poo.mvc.model.Produto;
import br.univille.poo.mvc.view.CadastroPessoaView;

public class Main {

	public static void main(String[] args) {
		Produto p = new Produto();
		
		CadastroPessoaControl control = new CadastroPessoaControl(new CadastroPessoaView(),p);
		control.exibirTela();
	}
}
