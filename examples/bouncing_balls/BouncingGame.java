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
		BouncingGame jeux = new BouncingGame("jeux de boules","level",1280,720,3);
		score = new Counter(jeux,0,30,30);
		if((arg.length != 0)){
			System.out.println("reloaded");
			new Pad(jeux,20);
			new Balls(jeux,500,500,30,8);
			new Balls(jeux,300,500,30,5);
			new Balls(jeux,700,500,30,11);
			new Balls(jeux,200,400,30,4);
			new Balls(jeux,100,100,30,6);
			new Balls(jeux,200,550,30,2);
			new Balls(jeux,600,400,30,4);
			new Balls(jeux,500,300,30,4);
			new Balls(jeux,500,200,30,4);
			new Balls(jeux,500,100,30,4);
			new Balls(jeux,550,100,30,4);
			new Balls(jeux,600,100,30,4);
			new Balls(jeux,650,100,30,4);
			new Balls(jeux,750,100,30,4);
			new Balls(jeux,800,100,30,4);
			new Borders(jeux, 1200,0,700,50);
			new LevelEditor(jeux,"level");
			//	jeux.load();
		}else{
			jeux.load("level");
		}
	}

	public void upScore(){
		this.score.addCount();
	}
}
