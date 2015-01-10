package com.virtualMuseum.view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Polygon;
import java.awt.RadialGradientPaint;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import com.virtualMuseum.controler.OpenFiles;
import com.virtualMuseum.model.Vecteur;

/*
 * Dessine la figure à partir du modèle ouvert
 * Ajoute un effet de lumière
 * 
 */
public class Print extends JPanel {

	int zoom =30; // zoom sur la figure
	int xsize; // largeur du panel
	int ysize; // hauteur du panel
	OpenFiles readFile;
	
	public Print(OpenFiles readFile){
		this.readFile=readFile;
		this.setPreferredSize(new Dimension(600,300));
	}

	public void paintComponent(final Graphics g){
		super.paintComponent(g);
		xsize = this.getWidth();
		ysize = this.getHeight();

		this.readFile.quickSort(this.readFile.getTabFaces(),0,this.readFile.getTabFaces().length-1);	

		for(int i=0; i<this.readFile.getNbFaces(); i++){

			Vecteur v1 = new Vecteur(this.readFile.getTabFaces()[i].getP()[1].getX() - this.readFile.getTabFaces()[i].getP()[0].getX(),
					this.readFile.getTabFaces()[i].getP()[1].getY() - this.readFile.getTabFaces()[i].getP()[0].getY(),
					this.readFile.getTabFaces()[i].getP()[1].getZ() - this.readFile.getTabFaces()[i].getP()[0].getZ());
			
			Vecteur v2 = new Vecteur(this.readFile.getTabFaces()[i].getP()[2].getX() - this.readFile.getTabFaces()[i].getP()[0].getX(),
					this.readFile.getTabFaces()[i].getP()[2].getY() - this.readFile.getTabFaces()[i].getP()[0].getY(),
					this.readFile.getTabFaces()[i].getP()[2].getZ() - this.readFile.getTabFaces()[i].getP()[0].getZ());
			
			Vecteur lum = new Vecteur(10,10,10);

			Vecteur norm = new Vecteur(v1.Y*v2.Z-v1.Z*v2.Y, v1.Z*v2.X-v1.X-v2.Z, v1.X*v2.Y-v1.Y*v2.X);
			
			Polygon p = new Polygon(new int[]{(int)(this.readFile.getTabFaces()[i].getP()[0].getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[1].getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[2].getX()*zoom)+xsize/2},
					new int[]{(int)(this.readFile.getTabFaces()[i].getP()[0].getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[1].getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[2].getY()*zoom)+ysize/2},3);
			
			double cos = (norm.X*lum.X+norm.Y*lum.Y+norm.Z*lum.Z)/(Math.sqrt((norm.X*norm.X+norm.Y*norm.Y+norm.Z*norm.Z)*(lum.X*lum.X+lum.Y*lum.Y+lum.Z*lum.Z)));

			g.setColor(new Color(Math.abs((int)(255*cos)),0,0));
			g.fillPolygon(p);	
		}
	}

	public OpenFiles getReadFile() {
		return readFile;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public void setReadFile(OpenFiles readFile) {
		this.readFile = readFile;
	}

	public int getXsize() {
		return xsize;
	}

	public int getYsize() {
		return ysize;
	}
}