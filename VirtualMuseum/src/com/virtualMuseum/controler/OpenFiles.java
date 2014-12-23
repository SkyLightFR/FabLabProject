package com.virtualMuseum.controler;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.virtualMuseum.database.Connexion;
import com.virtualMuseum.model.Faces;
import com.virtualMuseum.model.Points;
import com.virtualMuseum.model.Segments;


public class OpenFiles {
	private String file;
	private int nbPoints;
	

	private int nbSegments;
	private int nbFaces;
	private Points tabPoints[];
	private Segments tabSegments[];
	private Faces tabFaces[];
	private ArrayList<String> keyWords;
	
	private Date date; 
	

	public OpenFiles(String file) throws Exception {
		this.file = file;
		FileReader reader = new FileReader(file);
		Scanner sc = new Scanner(reader);
		sc.useDelimiter("\\s");
		nbPoints = Integer.parseInt(sc.next());
		nbSegments = Integer.parseInt(sc.next());
		nbFaces = Integer.parseInt(sc.next());
		tabPoints = new Points[nbPoints];
		tabSegments = new Segments[nbSegments];
		tabFaces = new Faces[nbFaces];
		keyWords = new ArrayList<String>();
		
		Connexion con = new Connexion("Database.db");
		con.connect();
		String query1 = "SELECT name FROM Filegts WHERE name='"+this.file+"';";
		ResultSet rs = con.query(query1);
		if(rs.next()){
			String query2 ="SELECT date FROM Filegts WHERE name='"+this.file+"';";
			ResultSet rs2 = con.query(query2);
			rs.next();
			if(rs.getString(1).equals("0")){
				date= new Date();
			}else{
				date = new Date(Integer.parseInt(rs.getString(1).substring(6,8)),Integer.parseInt(rs.getString(1).substring(3,5)),Integer.parseInt(rs.getString(1).substring(0,2)));
				
			}
			con.close();
		}else{
			date=new Date();
		}
		System.out.println(date);
	
		
		sc.nextLine();		
			for(int i=0; i<nbPoints; i++){
					tabPoints[i] = new Points(Float.parseFloat(sc.next()),
						Float.parseFloat(sc.next()), Float.parseFloat(sc.next()));	
					
			}
			for(int j=0; j<nbSegments; j++){
				int buf=Integer.parseInt(sc.next()) - 1;
				int buf2=Integer.parseInt(sc.next()) - 1;
				tabSegments[j] = new Segments(
						tabPoints[buf],	
						tabPoints[buf2]);
				tabSegments[j].setPosP1(buf+1);
				tabSegments[j].setPosP2(buf2+1);
			}
			
			for(int k=0; k<nbFaces; k++){
				int buf=Integer.parseInt(sc.next()) - 1;
				int buf2=Integer.parseInt(sc.next()) - 1;
				int buf3=Integer.parseInt(sc.next()) - 1;
				
				tabFaces[k] = new Faces(
						tabSegments[buf],
						tabSegments[buf2],
						tabSegments[buf3]);
				
				tabFaces[k].setPosS1(buf+1);
				tabFaces[k].setPosS2(buf2+1);
				tabFaces[k].setPosS3(buf3+1);
				
				
			}
			while(sc.hasNext()){
				keyWords.add(sc.next());
			}
			
			

		

	}
	
	public void insertSort(Faces[] tab) {
    	int iEnd=tab.length;
    	Faces tmp;
    	int i,j;
    	for(i=0; i<iEnd; i++){
    		tmp=tab[i];
    		for(j=i; j>0 && tab[j-1].compareTo(tmp)>0; j--){
    			tab[j]=tab[j-1];
    			
    		}
    		tab[j]=tmp;
    		
    		
    	}
    	
    }
	

	
	public ArrayList<String> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(ArrayList<String> keyWords) {
		this.keyWords = keyWords;
	}

	public Points[] getTabPoints() {
		return tabPoints;
	}

	public void setTabPoints(Points[] tabPoints) {
		this.tabPoints = tabPoints;
	}

	public Segments[] getTabSegments() {
		return tabSegments;
	}

	public void setTabSegments(Segments[] tabSegments) {
		this.tabSegments = tabSegments;
	}

	public Faces[] getTabFaces() {
		return tabFaces;
	}

	public void setTabFaces(Faces[] tabFaces) {
		this.tabFaces = tabFaces;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getDate() {
		return date;
	}
	

	

}
