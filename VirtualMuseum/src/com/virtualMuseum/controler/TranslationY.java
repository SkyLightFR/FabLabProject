package com.virtualMuseum.controler;

import com.virtualMuseum.view.Print;

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
