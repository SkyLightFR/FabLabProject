package com.virtualMuseum.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.virtualMuseum.view.PrincipalPanel.ButtonListener;

public class MyMenuBar extends JPanel{
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int height = (int)screenSize.getHeight();
	int width = (int)screenSize.getWidth();
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("Fichier");
	JMenuItem open = new JMenuItem("Ouvrir");
	JMenuItem save = new JMenuItem("Enregistrer");
	JMenuItem saveAs = new JMenuItem("Enregistrer sous");
	JMenuItem help = new JMenuItem("Aide");
	JMenuItem exit = new JMenuItem("Quitter");
	public MyMenuBar(ButtonListener listener){
		file.setMnemonic(KeyEvent.VK_F);
		Font font = new Font("Helvetica",0,13);
		open.addActionListener(listener);
		KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		open.setAccelerator(keyStrokeToOpen);
		open.addActionListener(listener);
		KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
		save.setAccelerator(keyStrokeToSave);
		saveAs.addActionListener(listener);
		KeyStroke keyStrokeToSaveAs = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
		saveAs.setAccelerator(keyStrokeToSaveAs);
		help.addActionListener(listener);
		KeyStroke keyStrokeToHelp = KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK);
		help.setAccelerator(keyStrokeToHelp);
		exit.addActionListener(listener);
		KeyStroke keyStrokeToExit = KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK);
		exit.setAccelerator(keyStrokeToExit);
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
		menuBar.setPreferredSize(new Dimension(width+75,15));
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
