package examples.bouncing_balls;

import fr.legbt.binge.items.*;
import fr.legbt.binge.*;
import java.awt.*;
import javax.swing.*;

public class Pad extends Rect{
	private int xpos;
	private int speedi;

	public Pad(Binge game,int x){
		super(game,x,300,200,30);
		this.xpos = x;
		speedi = 20;
		setListener();
	}

	public void onKeyDown(int key){
		switch(key){
			case 85 : yspeed = speedi;break;
			case 87 : yspeed = -speedi;break;
		}
	}

	public void onKeyUp(int key){
		 yspeed = 0;
	}

	public void onLoaded(Binge game){setListener();}
	public void onCollide(FixedItem fitem){}
	public void onCollide(MovableItem mitem){
		this.collided = true;
	}
	public void action(){
		this.move(x,y+(int)yspeed);
	}

}

