package com.virtualMuseum.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.virtualMuseum.controler.OpenFiles;

public class MyMenuAddFile extends JFrame {
	JPanel panel=new JPanel();
	JPanel buttonPanel=new JPanel();
	JLabel name;
	JLabel keyWords;
	JTextField text=new JTextField();
	JButton addKeyWords=new JButton("Ajouter le mot clé");
	JButton addInBDD=new JButton("Ajouter à la bibliothèque");
	OpenFiles readFile;
	
	public MyMenuAddFile(OpenFiles readFile){
		this.setVisible(true);
		this.setTitle("Ajouter un fichier a la bibliothèque");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		this.setSize(510,150);
		this.setLocationRelativeTo(null);
		this.readFile=readFile;
		ButtonListener listener = new ButtonListener();
		text.setPreferredSize(new Dimension(100,25));
		panel.setPreferredSize(new Dimension(510,150));
		addKeyWords.setPreferredSize(new Dimension(100,25));
		addKeyWords.addActionListener(listener);
		addInBDD.addActionListener(listener);
		addInBDD.setPreferredSize(new Dimension(100,25));
		name=new JLabel(readFile.getFile());
		name.setFont(new Font("Helvetica",Font.BOLD,20));
		keyWords=new JLabel(readFile.getKeyWords().toString());
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.add(Box.createVerticalGlue());
		panel.add(name);
		panel.add(keyWords);
		panel.add(text);
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.LINE_AXIS));
		buttonPanel.add(addKeyWords);
		buttonPanel.add(addInBDD);
		panel.add(buttonPanel);
		
		this.setContentPane(panel);
		
	}
	
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==addKeyWords){
				if(text.getText()!=""){
					readFile.getKeyWords().add(text.getText());	
				}
			}
			if(e.getSource()==addInBDD){
				MyMenuAddFile.this.dispose();
			}
			
			
		}
		
	}
	
	
	

}
