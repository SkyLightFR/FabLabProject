package com.virtualMuseum.controler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.virtualMuseum.model.Faces;
import com.virtualMuseum.model.Points;
import com.virtualMuseum.model.Segments;
import com.virtualMuseum.view.Print;





public class SaveFiles {
	private String name;
	private int nbPoints;
	private int nbSegments;
	private int nbFaces;
	private Points tabPoints[];
	private Segments tabSegments[];
	private Faces tabFaces[];
	private ArrayList<String> keyWords;
	PrintWriter saver = null;
	OpenFiles readFile;
	
	public SaveFiles(String name, Print printer) {
		if(printer!=null ){
			try{
				readFile=new OpenFiles(printer.getReadFile().getFile());
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			this.name=name;
			nbPoints=readFile.getNbPoints();
			nbSegments=readFile.getNbSegments();
			nbFaces=readFile.getNbFaces();
			tabPoints=readFile.getTabPoints();
			tabSegments=readFile.getTabSegments();
			tabFaces=readFile.getTabFaces();
			keyWords=printer.getReadFile().getKeyWords();
		}

		try{
			saver =new PrintWriter(new BufferedWriter(new FileWriter(name)));
			saver.println(nbPoints+" "+nbSegments+" "+nbFaces);
			for(int i=0; i<nbPoints; i++){
				saver.println(tabPoints[i].toString());
			}
			for(int i=0; i<nbSegments; i++){
				saver.println(tabSegments[i].toString());
				
			}
			for(int i=0; i<nbFaces; i++){
				saver.println(tabFaces[i].toString());
				
			}
			for(int i=0; i<keyWords.size(); i++){
				System.out.println(keyWords.get(i));
				saver.println(keyWords.get(i));
				
			}
			saver.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		
	}
	

	
	

}
