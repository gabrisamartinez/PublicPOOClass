package br.univille.poo.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class TwoLabels extends JFrame{
	public TwoLabels() {
		// Titulo da Janela
		setTitle("Panels");
		// Tamanho da Janela
		setSize(500, 500);
		// Nao permite modificar o tamanho da Tela
		setResizable(false);
		// Configura a tela
		setLayout();
	}
	
	// Configura a tela
	private void setLayout() {
		JPanel panel = new JPanel();
		GridLayout experimentLayout = new GridLayout(0,2);
		
		// Retira o gerenciador de layout
		panel.setLayout(experimentLayout);
		
		//Cria o painel de RadioButton
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,1));
		

		JTextArea textArea = new JTextArea();

		JCheckBox r1 = new JCheckBox("Norte");
		JCheckBox r2 = new JCheckBox("Sul");
		JCheckBox r3 = new JCheckBox("Leste");
		JCheckBox r4 = new JCheckBox("Oeste");
		JCheckBox r5 = new JCheckBox("Centro");
		
		

		// Adiciona atalhos nos componentes
		r1.setMnemonic(KeyEvent.VK_N);
		r2.setMnemonic(KeyEvent.VK_S);
		r3.setMnemonic(KeyEvent.VK_L);
		r4.setMnemonic(KeyEvent.VK_O);
		r5.setMnemonic(KeyEvent.VK_C);
		// Configura o radiobutton como selecionado
		r1.setSelected(true);
		r2.setSelected(true);
		r3.setSelected(true);
		r4.setSelected(true);
		r5.setSelected(true);
		
		

		panel1.add(r1);
		panel1.add(r2);
		panel1.add(r3);
		panel1.add(r4);
		panel1.add(r5);
		
		//Cria painel 2
		JPanel panel2 = new JPanel();
		 // Adiciona o gerenciador BorderLayout
		panel2.setLayout( new BorderLayout(5,5));
        
        //Cria os paineis
        JPanel norte = criarPanel(Color.RED,"Norte");
        JPanel leste = criarPanel(Color.YELLOW,"Leste");
        JPanel oeste = criarPanel(Color.BLUE,"Oeste");
        JPanel sul = criarPanel(Color.WHITE,"Sul");
        JPanel centro = criarPanel(Color.GREEN,"Centro");
        
        
        // Adiciona o painel no norte
        panel2.add(norte, BorderLayout.NORTH);
        // Adiciona o painel no sul
        panel2.add(sul, BorderLayout.SOUTH);
        // Adiciona o painel no leste
        panel2.add(leste, BorderLayout.EAST);
        // Adiciona o painel no oeste
        panel2.add(oeste, BorderLayout.WEST);
        // Adiciona o painel no centro
        panel2.add(centro, BorderLayout.CENTER);
        
        //Ação do click
    	// Cria o action listener
		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox radio = (JCheckBox) e.getSource();
				String name = radio.getText();
				switch (name) {
				case "Norte":
					norte.setVisible(radio.isSelected());
					break;
				case "Sul":
					sul.setVisible(radio.isSelected());
					break;
				case "Leste":
					leste.setVisible(radio.isSelected());
					break;
				case "Oeste":
					oeste.setVisible(radio.isSelected());
					break;
				case "Centro":
					centro.setVisible(radio.isSelected());
					break;
				default:
					norte.setVisible(true);
					sul.setVisible(true);
					centro.setVisible(true);
					oeste.setVisible(true);
					leste.setVisible(true);
					break;
				}
				
			}
		};
        
		// Adiciona o action listener nos radiobuttons
				r1.addActionListener(l);
				r2.addActionListener(l);
				r3.addActionListener(l);
				r4.addActionListener(l);
				r5.addActionListener(l);
		
		panel.add(panel1);
		panel.add(panel2);
		
		//Adiciona o painel no frame
		add(panel);
	}
	
	
	private JPanel criarPanel(Color color, String texto) {
    	JPanel panel = new JPanel();
    	panel.setBackground(color);
    	panel.add(new JLabel(texto));
    	// Configura um tamanho padrao do painel
    	return panel;
    }

}
