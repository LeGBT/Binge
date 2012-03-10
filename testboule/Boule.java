package testboule;

import fr.legbt.binge.*;
import javax.swing.*;
import java.awt.*;
import fr.legbt.binge.items.*;
import fr.legbt.binge.data.*;

public class Boule extends Binge{

	public Boule(String name,String lvlfile, int width, int height, int framerate){
		super(name,lvlfile,width,height,framerate);
	}
	public static void main(String arg[]){
		Boule jeux = new Boule("jeux de boules","balls",1280,720,17);
	}
}
