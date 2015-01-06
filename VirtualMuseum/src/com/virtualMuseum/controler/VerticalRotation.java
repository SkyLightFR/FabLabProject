package com.virtualMuseum.controler;

import com.virtualMuseum.view.Print;

public class VerticalRotation {
	
	public VerticalRotation(Print printer,double angle){
		if(printer.getReadFile()!=null){
			for(int i=0; i<printer.getReadFile().getNbPoints(); i++){
				double y=printer.getReadFile().getTabPoints()[i].getY();
				double z=printer.getReadFile().getTabPoints()[i].getZ();
				printer.getReadFile().getTabPoints()[i].setY(y*Math.cos(angle/360)-z*Math.sin(angle/360));
				printer.getReadFile().getTabPoints()[i].setZ(y*Math.sin(angle/360)+z*Math.cos(angle/360));	
			}	
		}
	}
}
