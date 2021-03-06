package com.virtualMuseum.view;

import java.awt.Dimension;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.virtualMuseum.view.PrincipalPanel.ButtonListener;

/*
 * Barre d'outil 
 * Permet l'ajout et la suppression du modèle à la base donnée
 * Outil de recherche et recherche par critère
 */
public class MyMenuTools extends JPanel{
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int height = (int)screenSize.getHeight();
	int width = (int)screenSize.getWidth();
	JToolBar toolsBar = new JToolBar();
	JButton toolsave; // bouton sauvegarder
	JButton toolopen; // bouton ouvrir 
	JButton tooladd; // bouton ajouter à la base de donnée
	JButton toolremove; // bouton supprimer de la base de donnée
	JButton toolresearch; // bouton rechercher
	JTextField search; // champ de texte pour la recherche
	JCheckBox keyWordsResearch=new JCheckBox("Recherche par mot clé",false); // critère de recherche par mot clé
	JCheckBox dateResearch = new JCheckBox("Recherche par date",false); // critère de recherche par date d'ajout
	
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
		search.setPreferredSize(new Dimension(100, 10));
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
	
	/*
	 * Crée les boutons en leur associant une image et un texte d'information
	 * @param imageName nom de l'image correspond au bouton
	 * @param toolTipText associe un texte d'information au bouton quand on passe la souris dessus
	 */
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
