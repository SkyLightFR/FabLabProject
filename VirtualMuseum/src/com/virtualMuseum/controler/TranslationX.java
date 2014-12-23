package com.virtualMuseum.controler;

import com.virtualMuseum.view.Print;

public class TranslationX {
	public TranslationX(Print printer,int angle){
		if(printer.getReadFile()!=null){
			for(int i=0; i<printer.getReadFile().getNbPoints(); i++){
				double x=printer.getReadFile().getTabPoints()[i].getX();	
				if(angle<0){
					x+=1;
				}else{
					x-=1;
				}
			
				printer.getReadFile().getTabPoints()[i].setX(x);
				
			}
			
		}
		
	}

}
