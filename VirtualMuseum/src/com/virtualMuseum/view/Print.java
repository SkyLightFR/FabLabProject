package com.virtualMuseum.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.virtualMuseum.controler.OpenFiles;
import com.virtualMuseum.model.Light;

public class Print extends JPanel {

	int zoom =30;
	int xsize;
	int ysize;
	private int light;
	JCheckBox lightBox=new JCheckBox("Lumiere",false);

	Light lightObject = new Light(0,0,0);

	OpenFiles readFile;
	public Print(OpenFiles readFile){
		this.readFile=readFile;
		this.setPreferredSize(new Dimension(600,400));
		this.add(lightBox);
		

	}



	@Override
	public void paintComponent(final Graphics g){
		super.paintComponent(g);

		xsize = this.getWidth();
		ysize = this.getHeight();
		


		this.readFile.insertSort(this.readFile.getTabFaces());	

		Color color = new Color(223,175,44);
		for(int i=0; i<this.readFile.getNbFaces(); i++){
			
			g.setColor(color);
			Polygon p = new Polygon(new int[]{(int)(this.readFile.getTabFaces()[i].getP()[0].getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[1].getX()*zoom)+xsize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[2].getX()*zoom)+xsize/2},
					new int[]{(int)(this.readFile.getTabFaces()[i].getP()[0].getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[1].getY()*zoom)+ysize/2,
					(int)(this.readFile.getTabFaces()[i].getP()[2].getY()*zoom)+ysize/2},3);


			g.fillPolygon(p);
			g.setColor(color);
			g.drawLine( (int)(this.readFile.getTabFaces()[i].getS1().getP1().getX()*zoom)+xsize/2,
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
					(int)(this.readFile.getTabFaces()[i].getS3().getP2().getY()*zoom)+ysize/2);


		}		
		//System.out.println((int)((g.getColor().getRed()*getLight())/ratio+" "+(int)((g.getColor().getGreen()*getLight())/ratio)+" "+ (int)((g.getColor().getBlue()*getLight())/ratio))));
		//System.out.println(ratio);
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

	public int getLight() {
		return light;
	}


	public void setLight(int light) {
		this.light = light;
	}
	public void setReadFile(OpenFiles readFile) {
		this.readFile = readFile;
	}








}