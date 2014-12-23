package com.virtualMuseum.controler;

import java.awt.Dimension;

import com.virtualMuseum.view.PrincipalPanel;
import com.virtualMuseum.view.Print;

public class TranslationCenter {
	public TranslationCenter(Print printer,PrincipalPanel panel){
		try{
			panel.printFile(panel.getCurrentFile().getName());
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		for(int i=0; i<printer.getReadFile().getNbPoints(); i++){
			double x=printer.getReadFile().getTabPoints()[i].getX();
			double z=printer.getReadFile().getTabPoints()[i].getZ();
			double y=printer.getReadFile().getTabPoints()[i].getY();
			printer.getReadFile().getTabPoints()[i].setY(y);
			printer.getReadFile().getTabPoints()[i].setX(x);
			printer.getReadFile().getTabPoints()[i].setZ(z);
			
					
		}
		
	}

}
