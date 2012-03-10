package examples.bouncing_balls;

import fr.legbt.binge.*;
import javax.swing.*;
import java.awt.*;
import fr.legbt.binge.items.*;
import fr.legbt.binge.data.*;

public class BouncingGame extends Binge{

	public BouncingGame(String name,String lvlfile, int width, int height, int framerate){
		super(name,lvlfile,width,height,framerate);
	}
	public static void main(String arg[]){
		BouncingGame jeux = new BouncingGame("jeux de boules","level",1280,720,17);
	//	Balls ball1 = new Balls(jeux, 100,100,20,5);
	//	Borders borders = new Borders(jeux, 1200,50,700,50);
	//	LevelEditor le = new LevelEditor(jeux,"level");
		jeux.load("level");
	}
}
