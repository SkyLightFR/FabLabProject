package com.virtualMuseum.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.virtualMuseum.view.PrincipalPanel.ButtonListener;
import com.virtualMuseum.view.PrincipalPanel.MListener;

/*
 * Menu contenant l'outil de translation et de zoom
 * 
 */
public class MyMenuChanges extends JPanel{
	JButton transX=new JButton(new ImageIcon("images/X.png")); // bouton de translation vers la droite
	JButton transY=new JButton(new ImageIcon("images/Y.png")); // bouton de translation vers le haut
	JButton transLowerX=new JButton(new ImageIcon("images/lowerX.png")); // bouton de translation vers la gauche
	JButton transLowerY=new JButton(new ImageIcon("images/lowerY.png")); // bouton de translation vers le bas
	JButton transCenter=new JButton(new ImageIcon("images/center.png")); // bouton de translation vers le centre
	JSlider zoomSlider = new JSlider(JSlider.HORIZONTAL); // slider pour régler le zoom
	Print printer;
	public MyMenuChanges(final Print printer,ButtonListener listener, MListener mouseListener){
		this.setPreferredSize(new Dimension(300,350));
		JPanel paneltrans = new JPanel();
		JPanel panelzoom = new JPanel();
		panelzoom.setLayout(new BoxLayout(panelzoom,BoxLayout.PAGE_AXIS));
		this.printer=printer;
		setButton(transX,listener,mouseListener);
		setButton(transY,listener,mouseListener);
		setButton(transLowerX,listener,mouseListener);
		setButton(transLowerY,listener,mouseListener);
		setButton(transCenter,listener,mouseListener);
		paneltrans.setLayout(new BorderLayout());
		JLabel zoomLabel = new JLabel("-                   Zoom                      +");
		zoomLabel.setFont(new Font("Helvetica",Font.ITALIC,10));

		
		zoomSlider.setPreferredSize(new Dimension(150,30));
		this.setBorder(BorderFactory.createEtchedBorder());
		
		zoomSlider.setMaximum(150);
		zoomSlider.setMinimum(0);
		zoomSlider.setMajorTickSpacing(1);
		
		panelzoom.add(zoomSlider);
		panelzoom.add(zoomLabel);
		
		paneltrans.add(transY, BorderLayout.NORTH);
		paneltrans.add(transLowerX, BorderLayout.WEST);
		paneltrans.add(transCenter, BorderLayout.CENTER);
		paneltrans.add(transX, BorderLayout.EAST);
		paneltrans.add(transLowerY, BorderLayout.SOUTH);	
		this.add(paneltrans);
		this.add(panelzoom);
	}
	
	/*
	 * Créer les boutons permettant la translation
	 * 
	 */
	public void setButton(JButton button,ButtonListener listener, MListener mouseListener){
		button.setPreferredSize(new Dimension(50,50));
		button.addActionListener(listener);
		button.addMouseListener(mouseListener);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
	}

	public JButton getTransX() {
		return transX;
	}

	public JButton getTransY() {
		return transY;
	}

	public JButton getTransLowerX() {
		return transLowerX;
	}

	public JButton getTransLowerY() {
		return transLowerY;
	}

	public JButton getTransCenter() {
		return transCenter;
	}

	public JSlider getZoomSlider() {
		return zoomSlider;
	}
	
	
}
