package fr.legbt.binge.items;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import fr.legbt.binge.Binge;
import fr.legbt.binge.data.*;

/**
 * Item is representing any drawable object with collisions capability.
 */
public abstract class Item implements Serializable {
	protected int x;
	protected int y;
	private transient int uniqueid;

	/** Init an Item with coordinates x,y.*/
	protected Item(int x, int y){
		this.x = x;
		this.y = y;
	}

	/** Init an Item with coordinates x,y and registered for paint and collisions.*/
	protected Item(Binge game, int x, int y){
		this.x = x;
		this.y = y;
		this.uniqueid = 0;
		this.setGame(game);
		game.getLvl().addItem(this);	
	}

	public void setID(int i){ this.uniqueid = i;}
	public int getID(){return uniqueid;}
	public int getX(){return this.x;}
	public int getY(){return this.y;}


	public void printNFO(){
		System.out.println("Item n°"+ uniqueid + " is a" + this.getClass().getName());
	}

	/** This method is called whenever a collition betwin this item and mitem is detected.*/
	protected abstract Boolean collideWith(MovableItem mitem);
	/** traceMe must define the way the item is drawn.*/
	protected abstract void traceMe(Binge game);
	/** action is called at each frame ticks, use it to define the way you want your item to move.*/
	protected abstract void action();
	public abstract void onLoaded(Binge game);
	public abstract void setGame(Binge game);

}
