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


public class Print extends JPanel {

	int zoom =30;
	int xsize;
	int ysize;
	OpenFiles readFile;
	public Print(OpenFiles readFile){
		this.readFile=readFile;
		this.setPreferredSize(new Dimension(600,400));
		

	}

	/*public void paintComponent (Graphics g){
		super.paintComponent(g);
		xsize = this.getWidth();
		ysize = this.getHeight();
		this.readFile.quickSort(this.readFile.getTabFaces(),0,this.readFile.getTabFaces().length-1);	
		Graphics2D g2d = (Graphics2D)g;
		java.awt.geom.Point2D center = new java.awt.geom.Point2D.Float(0,0 );
		float radius = 30;
		float[] dist = {0.0f, 1.0f};
		Color[] colors = {new Color(0.0f, 0.0f, 0.0f, 0.0f), Color.BLACK};
		RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, colors);
		g2d.setPaint(p);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
		for(int i=0; i<this.readFile.getNbFaces(); i++){
			Polygon p1 = new Polygon(new int[]{(int)(this.readFile.getTabFaces()[i].getP()[0].getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[1].getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[2].getX()*zoom)+xsize/2},
					new int[]{(int)(this.readFile.getTabFaces()[i].getP()[0].getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[1].getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[2].getY()*zoom)+ysize/2},3);
				g2d.fillPolygon(p1);	
		}
		
		g2d.dispose();
	}*/


	public void paintComponent(final Graphics g){
		super.paintComponent(g);

		xsize = this.getWidth();
		ysize = this.getHeight();



		this.readFile.quickSort(this.readFile.getTabFaces(),0,this.readFile.getTabFaces().length-1);	

		Color color = new Color(223,175,44);
		for(int i=0; i<this.readFile.getNbFaces(); i++){
			double normX=0;
			double normY=0;
			double normZ=0;

			double lumX=2;
			double lumY=2;
			double lumZ=2;
			
			Polygon p = new Polygon(new int[]{(int)(this.readFile.getTabFaces()[i].getP()[0].getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[1].getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[2].getX()*zoom)+xsize/2},
					new int[]{(int)(this.readFile.getTabFaces()[i].getP()[0].getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[1].getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[2].getY()*zoom)+ysize/2},3);
			
			
			normX = (this.readFile.getTabFaces()[i].getP()[2].getY()-this.readFile.getTabFaces()[i].getP()[1].getY())*(this.readFile.getTabFaces()[i].getP()[2].getZ()-this.readFile.getTabFaces()[i].getP()[0].getZ()) - 
					(this.readFile.getTabFaces()[i].getP()[1].getZ()-this.readFile.getTabFaces()[i].getP()[0].getZ())*(this.readFile.getTabFaces()[i].getP()[2].getY()-this.readFile.getTabFaces()[i].getP()[0].getY());
			normY = (this.readFile.getTabFaces()[i].getP()[1].getZ()-this.readFile.getTabFaces()[i].getP()[0].getZ())*(this.readFile.getTabFaces()[i].getP()[2].getX()-this.readFile.getTabFaces()[i].getP()[0].getX()) - 
					(this.readFile.getTabFaces()[i].getP()[1].getX()-this.readFile.getTabFaces()[i].getP()[0].getX())*(this.readFile.getTabFaces()[i].getP()[2].getZ()-this.readFile.getTabFaces()[i].getP()[0].getZ());	
			normZ = (this.readFile.getTabFaces()[i].getP()[1].getX()-this.readFile.getTabFaces()[i].getP()[0].getX())*(this.readFile.getTabFaces()[i].getP()[2].getY()-this.readFile.getTabFaces()[i].getP()[0].getY()) - 
					(this.readFile.getTabFaces()[i].getP()[1].getY()-this.readFile.getTabFaces()[i].getP()[0].getY())*(this.readFile.getTabFaces()[i].getP()[2].getX()-this.readFile.getTabFaces()[i].getP()[0].getX());

			double cos = (normX*lumX+normY*lumY+normZ*lumZ)/(Math.sqrt((normX*normX+normY*normY+normZ*normZ)*(lumX*lumX+lumY*lumY+lumZ*lumZ)));
			g.setColor(new Color(Math.abs((int)(255*cos)),0,0));
			g.fillPolygon(p);
			
			g.setColor(color.red);
			/*g.drawLine( (int)(this.readFile.getTabFaces()[i].getS1().getP1().getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getS1().getP1().getY()*zoom)+ysize/2,	
					(int)(this.readFile.getTabFaces()[i].getS1().getP2().getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getS1().getP2().getY()*zoom)+ysize/2);
			g.drawLine((int)(this.readFile.getTabFaces()[i].getS2().getP1().getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getS2().getP1().getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getS2().getP2().getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getS2().getP2().getY()*zoom)+ysize/2);	
			g.drawLine((int)(this.readFile.getTabFaces()[i].getS3().getP1().getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getS3().getP1().getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getS3().getP2().getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getS3().getP2().getY()*zoom)+ysize/2);*/


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