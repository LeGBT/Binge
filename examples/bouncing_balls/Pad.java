package examples.bouncing_balls;

import fr.legbt.binge.items.*;
import fr.legbt.binge.*;
import java.awt.*;
import javax.swing.*;

public class Pad extends Rect{
	private int xpos;

	public Pad(Binge game,int x){
		super(game,x,300,200,30);
		this.xpos = x;
	}

	public void onKeyDown(int key){
	}
	public void onKeyUp(int key){
	}

	public void onCollide(FixedItem fitem){}
	public void onCollide(MovableItem mitem){}
	public void onLoaded(Binge game){}
	public void action(){}

}

