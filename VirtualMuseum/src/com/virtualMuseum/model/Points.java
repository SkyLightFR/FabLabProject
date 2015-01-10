package com.virtualMuseum.model;

/*
 * Représente un point du modèle
 * @param x position x du point
 * @param y position y du point
 * @param z position z du point
 * implemente l'interface Comparable pour comparer 2 position z
 */
public class Points implements Comparable<Points> {
	
	private double x;
	private double y;
	private double z;
	
	public Points(double x, double y, double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public String toString(){
		return x+" "+y+" "+z;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	/*
	 * Compare la position z de ce point avec celui en paramètre
	 * @param e point à comparer
	 * @return 1 quand la position z de ce point est plus grande
	 * @return -1 quand la position z de ce point est plus petite
	 * @return 0 quand les positions sont égales
	 */
	@Override
	public int compareTo(Points e) {
		// TODO Auto-generated method stub
		if(this.z>e.z){
			return 1;
		}
		else if(this.z<e.z){
			return -1;
		}else{
			return 0;
		}
	}

	public boolean equals(Points p) {
		// TODO Auto-generated method stub
		return (p.x==x && p.y==y && p.z==z);
	}
}