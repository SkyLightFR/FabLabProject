package com.virtualMuseum.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.virtualMuseum.view.PrincipalPanel.ButtonListener;

public class MyMenuBar extends JPanel{
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int height = (int)screenSize.getHeight()-50;
	int width = (int)screenSize.getWidth()-50;
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("Fichier");
	JMenuItem open = new JMenuItem("Ouvrir");
	JMenuItem save = new JMenuItem("Enregistrer");
	JMenuItem saveAs = new JMenuItem("Enregistrer sous");
	JMenuItem help = new JMenuItem("Aide");
	JMenuItem exit = new JMenuItem("Quitter");
	public MyMenuBar(ButtonListener listener){
		Font font = new Font("Helvetica",0,13);
		open.addActionListener(listener);
		save.addActionListener(listener);
		saveAs.addActionListener(listener);
		help.addActionListener(listener);
		exit.addActionListener(listener);
		open.setFont(font);
		save.setFont(font);
		saveAs.setFont(font);		
		help.setFont(font);
		exit.setFont(font);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(help);
		file.add(exit);

		menuBar.add(file);
		menuBar.setPreferredSize(new Dimension(width,15));
		this.add(menuBar);
	}
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	public JMenu getFile() {
		return file;
	}
	public JMenuItem getOpen() {
		return open;
	}
	
	public JMenuItem getSave() {
		return save;
	}
	
	public JMenuItem getSaveAs() {
		return saveAs;
	}

	public JMenuItem getHelp() {
		return help;
	}
	
	public JMenuItem getExit() {
		return exit;
	}

	
	
	
	
}
