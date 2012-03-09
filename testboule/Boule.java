package testboule;

import fr.legbt.binge.*;
import javax.swing.*;
import java.awt.*;
import fr.legbt.binge.items.*;
import fr.legbt.binge.data.*;
//import fr.legbt.binge.*.*;

public class Boule extends Binge{
	UneBoule boule1;
	UneBoule boule2;
	UneBoule boule3;
	UneBoule boule4;
	UneBoule boule5;
	UneBoule boule6;
	UneBoule boule7;
	UneBoule boule8;
	UneBoule boule9;
	UneBoule boule10;
	UneBoule boule11;
	UneBoule boule12;
	UneBoule boule13;
	UneBoule boule14;
	UneBoule boule15;
	Plan planxa;
	Plan planxi;
	Plan planya;
	Plan planyi;

	public Boule(String name,String lvlfile, int width, int height, int framerate){
		super(name,lvlfile,width,height,framerate);
//		boule1 = new UneBoule(this,500,500,30,8);
//		boule2 = new UneBoule(this,300,500,30,5);
//		boule3 = new UneBoule(this,700,500,30,11);
//		boule4 = new UneBoule(this,200,400,30,4);
//		boule5 = new UneBoule(this,100,100,30,6);
//		boule6 = new UneBoule(this,200,550,30,2);
//		boule7 = new UneBoule(this,600,400,30,4);
//		boule8 = new UneBoule(this,500,300,30,4);
//		boule9 = new UneBoule(this,500,200,30,4);
//		boule10 = new UneBoule(this,500,100,30,4);
//		boule11 = new UneBoule(this,550,100,30,4);
//		boule12 = new UneBoule(this,600,100,30,4);
//		boule13 = new UneBoule(this,650,100,30,4);
//		boule14 = new UneBoule(this,750,100,30,4);
//		boule15 = new UneBoule(this,800,100,30,4);
//		planxa = new PlanXMax(this,1000);
//		planxi = new PlanXMin(this,100);
//		planya = new PlanYMax(this,600);
//		planyi = new PlanYMin(this,100);
//		try{
//			IOManager.storeLevel(this.getLvl());
//		} catch(Exception e){
//			e.printStackTrace();
//		}
	}
	public static void main(String arg[]){
		Boule jeux = new Boule("jeux de boules","balls",1280,720,20);
	}
}
