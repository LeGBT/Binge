package examples.bounce;

import fr.legbt.binge.items.*;
import fr.legbt.binge.*;

public class Pad extends Rect{
	private static final long serialVersionUID = 0l;
	@SuppressWarnings("unused")
	private int xpos;
	private int speedi;

	public Pad(Binge game,int x){
		super(game,x,300,200,30);
		this.xpos = x;
		speedi = 20;
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

