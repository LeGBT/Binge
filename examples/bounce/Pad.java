package examples.bounce;

import java.awt.Rectangle;

import fr.legbt.binge.items.*;
import fr.legbt.binge.*;

public class Pad extends Rect{
	@SuppressWarnings("unused")
	private int xpos;
	private int speedi;


	public Pad(Binge game,int column){
		super(game,"Pad",3,column,240,30,null);
		this.xpos = this.getX();
		speedi = 15;
		setListener(game);
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

	public void onLoaded(Binge game){setListener(game);}
	public void onCollide(FixedItem fitem){}
	public void onCollide(MovableItem mitem){}
	public void action(){
		this.move(this.getX(),this.getY()+(int)yspeed);
	}
}

