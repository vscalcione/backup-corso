/**
 * Questo piccolo progetto sviluppato in Java, consente di generare password random attraverso una semplice 
 * interfaccia grafica implementata con Java Swing. Utilizza infatti i componenti JPanel, JLabe, JTextField,
 * JButton e molti altri ancora
 */

package it.intersistemi.corsojava.esercizi;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordGenerator extends JFrame{
	JPanel panel = new JPanel(new GridLayout(4,1));
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JLabel labelTitle = new JLabel("Password Generator");
	JLabel label = new JLabel("Password Length: ");
	final Integer[] lenghts = {8, 9, 10, 11, 12, 13, 14, 15};
	final JComboBox<Integer> comboLengths = new JComboBox<Integer>(lenghts);
	JButton generatePswButton = new JButton("Generate Password ");
	JTextField textFieldPassword = new JTextField(15);
	
	public PasswordGenerator() {
		panel1.add(labelTitle);
		panel2.add(label);
		panel2.add(comboLengths);
		panel3.add(generatePswButton);
		Font f = new Font("Quicksand", Font.PLAIN, 24);		
		textFieldPassword.setFont(f);
		textFieldPassword.setHorizontalAlignment(JTextField.CENTER);
		textFieldPassword.setEditable(false);
		textFieldPassword.setBackground(Color.cyan);
		panel4.add(textFieldPassword);
		generatePswButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String passwordGenerated = generatePassword(comboLengths.getSelectedIndex()+8);
				textFieldPassword.setText(passwordGenerated);
			}
		});
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		this.getContentPane().add(panel);
		this.setResizable(true);
		this.pack();
		this.setVisible(true);
	}
	
	private String generatePassword(int l) {
		String maiuscle = "ABCDEFGHIJKLMNOPQRTSTUWXYZ".toLowerCase();
		String simble = "_-()?!*@$&#";
		int nLetters = maiuscle.length();
		int nSimbles = simble.length();
		String result="";
		for (int i = 0; i <= 1; i++) {
			int n = (int)(Math.random() * nLetters);
			result += maiuscle.substring(n, n+1);
		}
		for (int i = 2; i <= 3; i++) {
			int n = (int)(Math.random() * nSimbles);
			result += simble.substring(n, n+1);
		}
		for (int i = 4; i <= 5; i++) {
			int n = (int)(Math.random() * 10);
			result += ""+n;
		}
		for (int i = 6; i <= l-1; i++) {
			int n = (int)(Math.random() * nLetters);
			result += maiuscle.substring(n, n+1);
		}
		return result;
	}
	public static void main(String[] args) {
		PasswordGenerator pswGenerator = new PasswordGenerator();
	}
}