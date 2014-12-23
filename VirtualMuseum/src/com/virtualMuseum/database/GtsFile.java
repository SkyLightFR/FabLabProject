package com.virtualMuseum.database;

import java.util.Date;

import javax.swing.ImageIcon;

public class GtsFile {
	private int nbPoints;
	private int nbSegments;
	private int nbFaces;
	private String name;
	private String[] keyWords;
	private ImageIcon img;
	String chaineKeyWords;
	private String date;
	
	public GtsFile(String name,int nbPoints, int nbSegments, int nbFaces, ImageIcon img,String keyWords){
		this.name=name;
		this.nbPoints=nbPoints;
		this.nbSegments=nbSegments;
		this.nbFaces=nbFaces;
		this.img=img;
		chaineKeyWords=keyWords;
	}
	public GtsFile(String name,int nbPoints, int nbSegments, int nbFaces,String keyWords,String date){
		this.name=name;
		this.nbPoints=nbPoints;
		this.nbSegments=nbSegments;
		this.nbFaces=nbFaces;
		chaineKeyWords=keyWords;
		this.date=date;
	}
	
	
	public String getChaineKeyWords() {
		return chaineKeyWords;
	}
	public void setChaineKeyWords(String chaineKeyWords) {
		this.chaineKeyWords = chaineKeyWords;
	}
	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public int getNbSegments() {
		return nbSegments;
	}

	public void setNbSegments(int nbSegments) {
		this.nbSegments = nbSegments;
	}

	public int getNbFaces() {
		return nbFaces;
	}

	public void setNbFaces(int nbFaces) {
		this.nbFaces = nbFaces;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}

	

}
