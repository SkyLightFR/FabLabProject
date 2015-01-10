package com.virtualMuseum.database;

import java.util.Date;

import javax.swing.ImageIcon;

/*
 * Modélise un fichier d'extension .gts
 * @param nbPoints nombre de points du modèle
 * @param nbSegments nombre de segment du modèle
 * @param nbFaces nombre de face du modèle
 * @param name nom du fichier
 * @param chaineKeyWords chaine de caractère contenant tous les mots clé du modèle
 * @param date date d'ajout du fichier
 */
public class GtsFile {
	private int nbPoints;
	private int nbSegments;
	private int nbFaces;
	private String name;
	String chaineKeyWords;
	private String date;
	
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
