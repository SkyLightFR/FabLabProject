package com.virtualMuseum.model;

public class Segments {

	Points p1;
	Points p2;
	int posP1;
	int posP2;
	
	

	public Segments(Points p1, Points p2){
		this.p1=p1;
		this.p2=p2;
	}
	
	public String toString(){
		return posP1+" "+posP2;
	}
	
	public Points getP1() {
		return p1;
	}

	public void setP1(Points p1) {
		this.p1 = p1;
	}
	public Points getP2() {
		return p2;
	}

	public void setP2(Points p2) {
		this.p2 = p2;
	}

	public int getPosP1() {
		return posP1;
	}

	public void setPosP1(int posP1) {
		this.posP1 = posP1;
	}

	public int getPosP2() {
		return posP2;
	}

	public void setPosP2(int posP2) {
		this.posP2 = posP2;
	}

}
