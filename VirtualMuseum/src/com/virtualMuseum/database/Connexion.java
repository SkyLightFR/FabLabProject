package com.virtualMuseum.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
	 
/*
 * Connexion à une base de donnée
 * @param DBPath indique le chemin de la base de donnée
 */
	public class Connexion {
	    private String DBPath = "";
	    private Connection connection = null;
	    private Statement statement = null;
	 
	    public Connexion(String dBPath) {
	        DBPath = dBPath;
	    }
	    
	    /*
	     * Ouvre une connection à la base de donnée indiquée avec DBPath
	     * 
	     */
	 
	    public void connect() {
	        try {
	            Class.forName("org.sqlite.JDBC");
	            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
	            statement = connection.createStatement();
	            System.out.println("Connexion a " + DBPath + " avec succes");
	        } catch (ClassNotFoundException notFoundException) {
	            notFoundException.printStackTrace();
	            System.out.println("Erreur de connection");
	        } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	            System.out.println("Erreur de connection");
	        }
	    }
	    
	    /*
	     * Ferme la connection
	     * 
	     */
	 
	    public void close() {
	        try {
	        	statement.close();
	            connection.close();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    /*
	     * Permet de créer une requète SQL
	     * @param request requète SQL sous forme d'une chaine de caractère
	     * @return result resultat de la requète
	     * 
	     */
	    public ResultSet query(String request) {
	        ResultSet result = null;
	        try {
	            result = statement.executeQuery(request);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Erreur dans la requet : " + request);
	        }
	        return result;
	  
	    }
	    /*
	     * Ajoute une fichier .gts dans la base de donnée
	     * @param gtsFile fichier gts à ajouter
	     */
	    public void addGtsFile(GtsFile gtsFile){
	    	
	    	String query = "";
	    	query += "INSERT INTO Filegts(name,nbPoints,nbSegments,nbFaces,motCle,date) VALUES (";
	    	query += "'" + gtsFile.getName() + "', ";
	    	query +=  gtsFile.getNbPoints() + ", ";
	    	query +=   gtsFile.getNbSegments() + ", ";
	    	query += gtsFile.getNbFaces() + ",'"+gtsFile.getChaineKeyWords()+"','"+gtsFile.getDate()+"' );";
	    	try {
	    		statement.executeUpdate(query);
	    	} catch (SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    

		}
	    /*
	     * Ajoute un mot clé donnée à un fichier précisé 
	     * @param words mot clé à ajouter
	     * @param filename nom du fichier à mettre à jour
	     */
	    public void addKeyWord(String words,String filename){
	    	String query = "UPDATE Filegts SET motCle='"+words+"' WHERE name='"+filename+"';";
	 
	    	try {
	    		statement.executeUpdate(query);
	    	} catch (SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    }
	 
	    /*
	     * Supprime un modele de la base de donnée
	     * @param name nom du fichier à supprimer
	     */
	    public void remove(String name){
	    	String query = "DELETE FROM FILEGTS WHERE name='"+name+"';";
	    	
	    	try {
	    		
	            statement.executeUpdate(query);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	   
	    
	   
	}


