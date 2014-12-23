package com.virtualMuseum.model;
import java.awt.Point;
import java.awt.Polygon;


public class Faces implements Comparable<Faces> {
	Segments s1;
	Segments s2;
	Segments s3;
	Points [] p; 
	int posS1;
	int posS2;
	int posS3;
	

	
	public Faces(Segments s1, Segments s2, Segments s3){
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
		p= new Points[3];
		p[0]=s1.p1;
		p[1]=s1.p2;
		if(!s2.p1.equals(p[0])&&!s2.p1.equals(p[1])){
			p[2]= s2.p1;
		}
		else{
			p[2]= s2.p2;
		}
	}
	public Points getGravityCenter(){
		double x=0;
		double y=0;
		double z=0;
		x=(s1.getP1().getX()+s1.getP2().getX()+s2.getP2().getX())/3;
		y=(s1.getP1().getY()+s1.getP2().getY()+s2.getP2().getY())/3;
		z=(s1.getP1().getZ()+s1.getP2().getY()+s2.getP2().getZ())/3;
		Points gravityCenter=new Points(x,y,z);
		return gravityCenter;
	}
	
	
	
	
	public Points[] getP() {
		return p;
	}
	public void setP(Points[] p) {
		this.p = p;
	}
	public String toString(){
		return posS1+" "+posS2+" "+posS3;
	}
	public Segments getS1() {
		return s1;
	}
	public void setS1(Segments s1) {
		this.s1 = s1;
	}
	public Segments getS2() {
		return s2;
	}
	public void setS2(Segments s2) {
		this.s2 = s2;
	}
	public Segments getS3() {
		return s3;
	}
	public void setS3(Segments s3) {
		this.s3 = s3;
	}
	@Override
	public int compareTo(Faces e) {
		return this.getGravityCenter().compareTo(e.getGravityCenter());
		
	}
	public int getPosS1() {
		return posS1;
	}
	public void setPosS1(int posS1) {
		this.posS1 = posS1;
	}
	public int getPosS2() {
		return posS2;
	}
	public void setPosS2(int posS2) {
		this.posS2 = posS2;
	}
	public int getPosS3() {
		return posS3;
	}
	public void setPosS3(int posS3) {
		this.posS3 = posS3;
	}
	
}
