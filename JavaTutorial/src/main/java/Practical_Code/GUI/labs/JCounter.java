package Practical_Code.GUI.labs;

import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import javax.swing.*;

class JCounter extends JFrame 
{
	public JCounter(String title)
	{
		super(title);
		this.setLayout(new FlowLayout());
		
		JTextArea ta = new JTextArea(20,45);
		JScrollPane scroll = new JScrollPane(ta);
		JButton wordbtn = new JButton("Word");
		JButton charbtn = new JButton("Character");
		
		//counting number of words
		wordbtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					String inputString = ta.getText();
					StringTokenizer tokenizer = new StringTokenizer(inputString);
					int count = tokenizer.countTokens();
					JOptionPane.showConfirmDialog(JCounter.this, "Total words : "+count, "Counting words ..",JOptionPane.DEFAULT_OPTION);
				}
		});
		
		//counting number of characters 
		charbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String inputString = ta.getText();
				long chars = inputString.chars().count();
				JOptionPane.showConfirmDialog(JCounter.this, "Total Characters with space : "+chars, "Counting Characters ..",JOptionPane.DEFAULT_OPTION);
			}
		});
		
		add(scroll);
		add(wordbtn);
		add(charbtn);
	}

	public static void main(String args[])
	{
		JCounter ui = new JCounter("Lab 2");
		ui.setSize(500, 400);
		ui.setResizable(false);
		ui.setVisible(true);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}