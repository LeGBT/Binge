package testboule;

import fr.legbt.binge.*;
import javax.swing.*;
import java.awt.*;
import fr.legbt.binge.items.*;
//import fr.legbt.binge.*.*;

public class Boule extends Binge{
	UneBoule uneboule;
	UneBoule unboule;
	UneBoule boule3;
	Plan planxa;
	Plan planxi;
	Plan planya;
	Plan planyi;

	public Boule(String name, int width, int height, int framerate){
		super(name,width,height,framerate);
		uneboule = new UneBoule(this,500,500,70,8);
		unboule = new UneBoule(this,300,500,70,5);
	//	boule3 = new UneBoule(this,700,500,40,11);
		planxa = new PlanXMax(this,1000);
		planxi = new PlanXMin(this,100);
		planya = new PlanYMax(this,600);
		planyi = new PlanYMin(this,100);
	}


	public static void main(String arg[]){
		Boule jeux = new Boule("jeux de boules",1280,720,20);
	}

}
