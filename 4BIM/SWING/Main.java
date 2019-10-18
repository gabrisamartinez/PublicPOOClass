package br.univille.poo.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import br.univille.poo.swing.componentes.UtilizacaoJRadioButton;

public class Main {
	
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//            	// Instancia a nova Janela
//            	Login login =  new Login();
//            	// Finaliza o programa quando fechar a janela
//            	login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            	// Exibe a janela
//            	login.show();
//            	
            	TwoLabels l = new TwoLabels();
            	l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	l.show();
            }
        });
	}

}
