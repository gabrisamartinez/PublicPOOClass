package br.univille.poo.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	

	public Login() {
		// Titulo da Janela
		setTitle("Login");
		// Tamanho da Janela
		setSize(300, 300);
		// Nao permite modificar o tamanho da Tela
		setResizable(false);
		// Configura a tela
		setLayout();
	}
	
	// Configura a tela
	private void setLayout() {
		JPanel panel = new JPanel();
		// Retira o gerenciador de layout
		panel.setLayout(null);
		// Adiciona bordas
		panel.setBorder(BorderFactory.createCompoundBorder(
				// Margem
				BorderFactory.createEmptyBorder(20, 20, 20, 20)
				// Com titulo
			   ,BorderFactory.createTitledBorder("Login")));

		// Campo texto com 10 caracteres
		JTextField text = new JTextField(10);
		text.setBounds(130, 40, 100, 30);
		
		JLabel label = new JLabel("Usu·rio:");
		// Cor do texto
		label.setForeground(Color.BLUE);
		label.setBounds(70, 40, 80, 30);
		
		// Campo texto com 10 caracteres
		JPasswordField textP = new JPasswordField(10);
		textP.setBounds(130, 80, 100, 30);
		
		JLabel labelp = new JLabel("Senha:");
		// Cor do texto
		labelp.setForeground(Color.BLUE);
		labelp.setBounds(70, 80, 80, 30);
		
		JButton button = new JButton("Entrar");
		button.setBounds(130, 130, 100, 30);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = text.getText();
				label.setText(texto);
				
				//JOptionPane.showMessageDialog(null, 
				//		"Ol√°!");
			}
		});
		
		
		JLabel labelForgetPassword = new JLabel("Esqueci Minha Senha");
		// Cor do texto
		labelForgetPassword.setForeground(Color.MAGENTA);
		labelForgetPassword.setBounds(90, 150, 200, 100);
		labelForgetPassword.setFont(new Font("Esqueci minha senha", Font.ITALIC, 10));
	
		
		panel.add(text);
		panel.add(textP);
		panel.add(button);
		
		// Adiciona o label no painel
		panel.add(label);
		panel.add(labelp);
		panel.add(labelForgetPassword);
		
		//Adiciona o painel no frame
		add(panel);
	}
	

}
