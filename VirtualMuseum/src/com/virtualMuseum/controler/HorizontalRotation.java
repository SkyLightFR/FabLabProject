package com.virtualMuseum.controler;

import com.virtualMuseum.view.Print;

/*
 * Effectue une rotation horizontal autour de l'axe y
 * @param angle indique l'angle de rotation
 */

public class HorizontalRotation {
	public HorizontalRotation(Print printer,double angle){
		if(printer.getReadFile()!=null){
			
			
			for(int i=0; i<printer.getReadFile().getNbPoints(); i++){
				double x=printer.getReadFile().getTabPoints()[i].getX();
				double z=printer.getReadFile().getTabPoints()[i].getZ();
				printer.getReadFile().getTabPoints()[i].setX(x*Math.cos(angle/360)-z*Math.sin(angle/360));
				printer.getReadFile().getTabPoints()[i].setZ(x*Math.sin(angle/360)+z*Math.cos(angle/360));
				
			}
			
			
		}
	}

}
