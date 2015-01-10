package com.virtualMuseum.controler;

import com.virtualMuseum.view.Print;

/*
 * Effectue une translation du modele hverticalement
 * @param angle indique de quel coté effectuer la translation (haut = 1 ou bas = -1)
 * 
 */
public class TranslationY {
	public TranslationY(Print printer,int angle){
		if(printer.getReadFile()!=null){
			for(int i=0; i<printer.getReadFile().getNbPoints(); i++){
				double y=printer.getReadFile().getTabPoints()[i].getY();
				if(angle<0){
					y+=1;
				}else{
					y-=1;
				}
				printer.getReadFile().getTabPoints()[i].setY(y);
			
				
			}
			
		}
		
	}

}
