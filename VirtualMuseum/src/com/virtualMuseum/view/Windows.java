package com.virtualMuseum.view;
import java.awt.Dimension;

import javax.swing.JFrame;

/*
 * Crée la fenètre du logiciel
 * @param panel panel contenant tous les composants
 * 
 */


public class Windows extends JFrame {

	PrincipalPanel panel;

	public Windows(PrincipalPanel panel) {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setVisible(true);
		this.panel=panel;
		this.setTitle("Project FabLab");
		this.setResizable(false);
		//this.setPreferredSize(screenSize);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args)  {
		PrincipalPanel panel = new PrincipalPanel();
		Windows w = new Windows(panel);
	}
}
