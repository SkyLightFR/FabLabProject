package com.virtualMuseum.model;

import java.awt.Color;
import java.awt.Graphics;

public class Light {
	
	int posX;
	int posY;
	int posZ;
	Points start;
	
	public Light(int posX, int posY, int posZ){
		this.posX=posX;
		this.posY=posY;
		this.posZ=posZ;
		start = new Points(posX,posY, posZ);
	}
	
	public void lighting(Faces f,Vecteur normal,Graphics g,int value){
		g.setColor(new Color((int)((g.getColor().getRed()*value)/500),(int)((g.getColor().getGreen()*value)/500), (int)((g.getColor().getBlue()*value)/500)));
		
	}
	public Vecteur vectorCalcul(int x,int y, int z, int x2, int y2, int z2){
		
		return new Vecteur(x+x2,y+y2,z+z2 );
	}
	
	public Vecteur createDirectorVector(int x, int y, int z){
		return new Vecteur(x,y,z);
	}
	
	public Vecteur createNormalVector(Vecteur v1, Vecteur v2){
		return new Vecteur((v1.y*v2.z)-(v1.z*v2.y),(v1.z*v2.x)-(v1.x*v2.z),(v1.x*v2.y)-(v1.y*v2.x));
	}
	public int scalaireProduct(Vecteur v1, Vecteur v2){
		
		return (v1.x*v2.x)+(v1.y*v2.y);
		
		
	}
	public Vecteur getDirectorVector(){
		return new Vecteur(this.posX,this.posY,this.posZ);
	}
	

}
