package it.intersistemi.corsojava.esercizi;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ByteConverter extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel panel1 = new JPanel(new GridLayout(4,1));
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JLabel labelTitle = new JLabel("Byte To Other Converter");
	JLabel label1 = new JLabel("Quanto vuoi convertire? ");
	JButton convertButton = new JButton("Converti");
	JTextField text = new JTextField(10);
	JTextField textFieldGenerator = new JTextField(45);
	
	public ByteConverter(JTextField text) {
		this.text = text;
	}
	
	public ByteConverter() {
		panel2.add(labelTitle);
		panel3.add(label1);
		panel4.add(text);
		panel4.add(convertButton);
		Font f = new Font("Segoe UI", Font.PLAIN, 24);
		textFieldGenerator.setFont(f);
		textFieldGenerator.setHorizontalAlignment(JTextField.CENTER);
		textFieldGenerator.setEditable(false);
		textFieldGenerator.setBackground(Color.cyan);
		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double inputValue = Double.parseDouble(text.getText());
				String byteConverted = byteToOther(inputValue, 3);
				textFieldGenerator.setText(byteConverted);
			}
		});
		panel5.add(textFieldGenerator);
		panel1.add(panel2);
		panel1.add(panel3);
		panel1.add(panel4);
		panel1.add(panel5);
		this.getContentPane().add(panel1);
		this.setResizable(true);
		this.pack();
		this.setVisible(true);	
	}
	
	public static String byteToOther(double bytes, int digits) {
		 String[] dataDimension = {"bytes", "KiloBytes", "MegaBytes", "GigaBytes", "TeraBytes", "PetaBytes", "EtaBytes", "ZetaBytes", "YetaBytes" };
		 int i = 0;
		 for (i = 0;  i < dataDimension.length;  i++) {
	         if (bytes < 1024) {
	        	 break;
	         }
	         double initialInput = bytes;
	         bytes = (initialInput  / 1024);
	     }
	     return String.format("%." + digits + "f", bytes) + " " + dataDimension[i] + " =====> "+(bytes*1024)+" "+dataDimension[i-1];	 
	 }
	
	public static void main(String[] args) {
		ByteConverter converter = new ByteConverter();
	}
}