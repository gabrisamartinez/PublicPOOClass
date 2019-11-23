package br.univille.poo.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.univille.poo.mvc.control.CadastroPessoaControl;
import br.univille.poo.mvc.model.Produto;
import br.univille.poo.mvc.util.Observer;
import br.univille.poo.mvc.util.Subject;

public class CadastroPessoaView extends JFrame implements Observer{

	private Produto model;
	private CadastroPessoaControl control;
	
	private JTextField codigoTextField;
	private JTextField nomeTextField;
	private JTextField codigoDeBarras;
	private JTextField preco;
	private JButton    salvarButton;
	private JButton    cancelarButton;
	private JButton    novoButton;
	private JButton    deletarButton;
	private JButton    pesquisarButton;
	private JLabel statusLabel;
	
	public CadastroPessoaView() {
		setSize(400,280);
		setTitle("Cadastro do Produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildLayout();
	}
	
	public void setModel(Produto model) {
		this.model = model;
	}
	
	public void setControl(CadastroPessoaControl control) {
		this.control = control;
	}

	private void buildLayout() {
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createCompoundBorder(
				
				  BorderFactory.createEmptyBorder(20, 20, 0, 20)
				, BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Detalhes da Pessoa")
						,BorderFactory.createEmptyBorder(10, 10, 10, 10))));

		codigoTextField = new JTextField(20);
		codigoTextField.setEnabled(false);
		nomeTextField = new JTextField(20);
		codigoDeBarras = new JTextField(20);
		preco = new JTextField(20);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setToolTipText("Salvar as alterações");
		salvarButton.addActionListener(e -> salvar());
		
		cancelarButton = new JButton("Cancelar");
		novoButton = new JButton("Novo");
		novoButton.setToolTipText("Criar novo registro de pessoa");
		novoButton.addActionListener(e -> novo());
		deletarButton = new JButton("Deletar");
		deletarButton.setToolTipText("Excluir registro de pessoa");
		deletarButton.setEnabled(true);
		deletarButton.addActionListener(e -> deletar());
		pesquisarButton = new JButton("Pesquisar");
		pesquisarButton.setToolTipText("Pesquisar pelo Codigo de Barras");
		pesquisarButton.setEnabled(true);
		pesquisarButton.addActionListener(e -> {
			try {
				pesquisar();
			} catch (Exception e1) {
				//do nothing
			}
		});
		
		
		JLabel l = new JLabel("código",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(codigoTextField);
		
		l = new JLabel("Nome do Produto",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(nomeTextField);
		l = new JLabel("Código de Barras",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(codigoDeBarras);
		l = new JLabel("Preço do Pruduto",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(preco);
		l = new JLabel();
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(novoButton);
		panel.add(salvarButton);
		panel.add(deletarButton);
		panel.add(pesquisarButton);
		
		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
		statusLabel = new JLabel("Cadastre um novo produto");
		statusPanel.add(statusLabel);
		
		
		root.add(statusPanel,BorderLayout.SOUTH);
		root.add(panel,BorderLayout.CENTER);
		
		add(root);
	}
	
	private void exibirDados() {
		codigoTextField.setText(Long.toString(model.getId()));
		nomeTextField.setText(model.getNome());
		preco.setText(model.getPreco());
		codigoDeBarras.setText(model.getCodigoDeBarras());
	}
	
	
	private void salvar() {
		control.salvar();
	}
	
	private void deletar() {
		control.deletar();
	}
	
	private void novo() {
		control.novo();
	}
	
	private void pesquisar() throws Exception {
		control.pesquisar();
	}
	
	public JButton getBotaoDeletar() {
		return deletarButton;
	}

	public void setMensagemStatusBar(String text) {
		statusLabel.setText(text);
	}

	@Override
	public void update(Subject s, Object o) {
		model = (Produto) o;
		exibirDados();
	}

	public String getNome() {
		return nomeTextField.getText();
	}
	
	public String getCodigoDeBarras() {
		return codigoDeBarras.getText();
	}

	public String getPreco() {
		return preco.getText();
	}
}
