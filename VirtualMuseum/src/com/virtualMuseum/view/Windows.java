package com.virtualMuseum.view;
import java.awt.Dimension;

import javax.swing.JFrame;




public class Windows extends JFrame {
	
	
	
	PrincipalPanel panel;
	

	public Windows(PrincipalPanel panel) {
		this.setVisible(true);
		this.panel=panel;
		this.setTitle("Musée Virtuel");
		this.setResizable(false);
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
