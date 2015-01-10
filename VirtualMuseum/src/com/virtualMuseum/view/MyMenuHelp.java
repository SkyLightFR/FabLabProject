package com.virtualMuseum.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyMenuHelp extends JFrame {
	
/*
 * Menu affichant les informations lié aux développeurs
 * 
 */
	
	public MyMenuHelp(){
		JPanel panel = new JPanel();
		this.setVisible(true);
		this.setTitle("Aide");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		this.setSize(600,150);
		this.setLocationRelativeTo(null);
		JLabel text=  new JLabel("Logiciel developper par Grandjean Rémi, Chevalier Benjamin et Quenon Thomas.");
		JLabel text2=new JLabel("Réalisé au cour de la deuxième année de DUT informatique.");
		JLabel text3 = new JLabel("Pour nous contacter en cas de problème d'utilisation du logiciel  :");
		JLabel text4 = new JLabel("grandjeanremi0@gmail.com");
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.add(text);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(text2);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(text3);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(text4);
		this.add(panel);
	}
	




}
