package com.virtualMuseum.view;
//test
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.virtualMuseum.controler.ResearchFileByKeyWords;
import com.virtualMuseum.view.PrincipalPanel.ButtonListener;

public class MyMenuTools extends JPanel{
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int height = (int)screenSize.getHeight();
	int width = (int)screenSize.getWidth();
	JToolBar toolsBar = new JToolBar();
	JButton toolsave;
	JButton toolopen;
	JButton tooladd;
	JButton toolremove;
	JButton toolresearch;
	JTextField search;
	JCheckBox keyWordsResearch=new JCheckBox("Recherche par mot clé",false);
	JCheckBox dateResearch = new JCheckBox("Recherche par date",false);
	
	public MyMenuTools(ButtonListener listener){
		toolsBar.setFloatable(false);
		toolsave = makeNavigationButton("save","Sauvegarder");
		toolsave.addActionListener(listener);
		toolopen = makeNavigationButton("open", "Ouvrir");
		toolopen.addActionListener(listener);
		tooladd = makeNavigationButton("add","Ajouter a la base de donnee");
		tooladd.addActionListener(listener);
		toolremove = makeNavigationButton("remove", "Supprimer de la base de donnee");
		toolremove.addActionListener(listener);
		toolresearch = makeNavigationButton("research", "Rechercher dans la base de donnee");
		toolresearch.addActionListener(listener);
		keyWordsResearch.addActionListener(listener);
		dateResearch.addActionListener(listener);
		search = new JTextField();
		search.setPreferredSize(new Dimension(70, 10));
		search.setSize(100, 10);
		
		
		toolsBar.addSeparator();
		toolsBar.add(toolopen);
		toolsBar.add(toolsave);
		toolsBar.addSeparator();
		toolsBar.add(tooladd);
		toolsBar.add(toolremove);
		toolsBar.addSeparator();
		toolsBar.add(search);
		toolsBar.add(toolresearch);
		toolsBar.add(keyWordsResearch);
		toolsBar.add(dateResearch);
		toolsBar.addSeparator();
		toolsBar.setPreferredSize(new Dimension(width,40));

		this.add(toolsBar);
		
	}
	protected JButton makeNavigationButton(String imageName, String toolTipText) {
		String imgLocation = "images/" + imageName + ".png";
		
		JButton button = new JButton();
		button.setToolTipText(toolTipText);
		button.add(new JLabel(new ImageIcon(imgLocation)));
		button.setSize(new Dimension(24,24));
	
		return button;
	}

	public JButton getToolsave() {
		return toolsave;
	}

	public JButton getToolopen() {
		return toolopen;
	}

	public JButton getTooladd() {
		return tooladd;
	}

	public JButton getToolremove() {
		return toolremove;
	}

	public JButton getToolresearch() {
		return toolresearch;
	}

	public JTextField getSearch() {
		return search;
	}
	public JCheckBox getKeyWordsResearch() {
		return keyWordsResearch;
	}
	public JCheckBox getDateResearch() {
		return dateResearch;
	}
	

}
