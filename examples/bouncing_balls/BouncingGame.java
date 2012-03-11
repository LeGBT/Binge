package examples.bouncing_balls;

import fr.legbt.binge.*;
import javax.swing.*;
import java.awt.*;
import fr.legbt.binge.items.*;
import fr.legbt.binge.data.*;

public class BouncingGame extends Binge{
	private static Counter score;

	public BouncingGame(String name,String lvlfile, int width, int height, int framerate){
		super(name,lvlfile,width,height,framerate);
	}
	public static void main(String arg[]){
		BouncingGame jeux = new BouncingGame("jeux de boules","level",1280,720,17);
		score = new Counter(jeux,0,30,30);
		if((arg.length != 0)){
			System.out.println("reloaded");
			Balls	boule1 = new Balls(jeux,500,500,30,8);
			Balls	boule2 = new Balls(jeux,300,500,30,5);
			Balls	boule3 = new Balls(jeux,700,500,30,11);
			Balls	boule4 = new Balls(jeux,200,400,30,4);
			Balls	boule5 = new Balls(jeux,100,100,30,6);
			Balls	boule6 = new Balls(jeux,200,550,30,2);
			Balls	boule7 = new Balls(jeux,600,400,30,4);
			Balls	boule8 = new Balls(jeux,500,300,30,4);
			Balls	boule9 = new Balls(jeux,500,200,30,4);
			Balls	boule10 = new Balls(jeux,500,100,30,4);
			Balls	boule11 = new Balls(jeux,550,100,30,4);
			Balls	boule12 = new Balls(jeux,600,100,30,4);
			Balls	boule13 = new Balls(jeux,650,100,30,4);
			Balls	boule14 = new Balls(jeux,750,100,30,4);
			Balls	boule15 = new Balls(jeux,800,100,30,4);
			Borders borders = new Borders(jeux, 1200,50,700,50);
			LevelEditor le = new LevelEditor(jeux,"level");
			//	jeux.load();
		}else{
			jeux.load("level");
		}
	}

	public void upScore(){
		this.score.addCount();
	}
}
