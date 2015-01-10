package com.virtualMuseum.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.virtualMuseum.controler.SaveFiles;
import com.virtualMuseum.database.Connexion;

/*
 * Menu affichant les informations concernant le modèle afficher
 * Miniature, nombre de points, segments et faces, mots clés, date d'ajout.
 */
public class MyMenuInformations extends JPanel {
	JLabel JnbPoints=new JLabel(); // label du nombre de point
	JLabel JnbSegments=new JLabel(); // label du nombre de segment
	JLabel JnbFaces=new JLabel(); // label du nombre de face
	JLabel name=new JLabel(""); // label du nom
	JLabel keyWords=new JLabel(""); // label des mots clés
	JLabel Jdate = new JLabel(""); // label de la date d'ajout
	ImageIcon img=new ImageIcon("");  // image de la miniature du modèle
	JButton buttonImg=buttonImg=new JButton(img); // bouton contenant la miniature
	Print printer;
	File currentFile;
	String format = "dd/MM/yy"; // format pour la date d'ajout
	SimpleDateFormat formater = new SimpleDateFormat(format);
	
	public MyMenuInformations(Print print,MyMenuTree menuTree,File current){
		this.printer=print;
		this.currentFile=current;
		
		if(printer!=null){
			this.setPreferredSize(new Dimension(240,400));
			this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
			buttonImg.setPreferredSize(new Dimension(250,120));
			buttonImg.setBorderPainted(false);
			buttonImg.setContentAreaFilled(false);
			buttonImg.setFocusable(false);
			JnbPoints.setFont(new Font("Helvetica",Font.ITALIC,12));
			JnbSegments.setFont(new Font("Helvetica",Font.ITALIC,12));
			JnbFaces.setFont(new Font("Helvetica",Font.ITALIC,12));
			JnbPoints.setText("Points : "+printer.readFile.getNbPoints());
			JnbSegments.setText("Segments : "+printer.readFile.getNbSegments());
			JnbFaces.setText("Faces : "+printer.readFile.getNbFaces());
			Jdate.setText("Date d'ajout : "+formater.format(printer.readFile.getDate() ));
			String buf="";
			if(printer.readFile.getKeyWords().size()>0){
				for(int i=0; i<printer.readFile.getKeyWords().size(); i++){
					buf+=" "+printer.readFile.getKeyWords().get(i);
				}
			}
			keyWords.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Connexion con = new Connexion("Database.db");
					con.connect();
					String buffer=keyWords.getText();
					TextField answer = new TextField(15);
					String pane =JOptionPane.showInputDialog(answer,
							buffer+"\nDéfinir un mot clé : ", "Mot clés",
							JOptionPane.QUESTION_MESSAGE);
					buffer+=" "+pane;
	                 if(pane!=null) {
	                	 if(buffer.length()>19){
	                		 buffer="\n"+buffer;
	                	 }
	                	keyWords.setText(buffer);
	                	 
	                	 printer.readFile.getKeyWords().add(pane);
	                
	                 con.addKeyWord(buffer.substring(12,buffer.length()), currentFile.getName());
	                 }
	                 
	                 new SaveFiles(currentFile.getName(), printer);	
	                 con.close();
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			keyWords.setText("Mot clés :"+buf);
			img.setImage(Toolkit.getDefaultToolkit().getImage("images/"+currentFile.getName()+".png"));
			name.setText("Nom du fichier : "+currentFile.getName());
			buttonImg.repaint();
			this.add(buttonImg);
			this.add(name);
			this.add(keyWords);		
			this.add(JnbPoints);
			this.add(JnbSegments);
			this.add(JnbFaces);
			this.add(Jdate);
			
		}
	}
	public MyMenuInformations(){
		this.setPreferredSize(new Dimension(240,400));

	}
	public JLabel getKeyWords() {
		return keyWords;
	}
	public JButton getButtonImg() {
		return buttonImg;
	}
	public ImageIcon getImg() {
		return img;
	}

}
