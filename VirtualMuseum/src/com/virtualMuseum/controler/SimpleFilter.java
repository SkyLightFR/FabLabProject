package com.virtualMuseum.controler;
import java.io.File;

import javax.swing.filechooser.FileFilter;

/*
 * Filtre l'extension .gts lors de l'ouverture d'un modele
 * @param description indique la nature du filtre
 * @param extension indique le type d'extension à filtrer
 */

public class SimpleFilter extends FileFilter{
   private String description;
   private String extension;

   public SimpleFilter(String description, String extension){
      if(description == null || extension ==null){
         throw new NullPointerException("La description (ou extension) ne peut �tre null.");
      }
      this.description = description;
      this.extension = extension;
   }
   /*
    * Implémentation du filtre
    */
   public boolean accept(File file){
      if(file.isDirectory()) { 
         return true; 
      } 
      String nomFichier = file.getName().toLowerCase(); 
 
      return nomFichier.endsWith(extension);
   }
      public String getDescription(){
    	  return description;
   }
}
