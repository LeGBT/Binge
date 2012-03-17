package fr.legbt.binge.items;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.locks.*;
import fr.legbt.binge.Binge;
import fr.legbt.binge.data.*;

/**
 * Item is representing any drawable object with collisions capability.
 */
public abstract class Item implements Serializable {
	private int x;
	private int y;
	private transient UUID uniqueid;
	private ReentrantLock lock;

	/** Init an Item with coordinates x,y.*/
	protected Item(int x, int y){
		lock = new ReentrantLock();
		this.x = x;
		this.y = y;
		this.uniqueid = UUID.randomUUID();
	}

	/** Init an Item with coordinates x,y and registered for paint and collisions.*/
	protected Item(Binge game, int x, int y){
		lock = new ReentrantLock();
		this.x = x;
		this.y = y;
		this.uniqueid = UUID.randomUUID();
		this.setGame(game);
		game.getLvl().addItem(this);	
	}

	public void newID(){ this.uniqueid = UUID.randomUUID();}
	public UUID getID(){return uniqueid;}
	public int getX(){
		lock.lock();	
		try{
			return this.x;
		}finally{
			lock.unlock();
		}
	}
	public int getY(){
		lock.lock();	
		try{
			return this.y;
		}finally{
			lock.unlock();
		}
	}

	public void setX(int x){
		lock.lock();	
		try{
			 this.x = x;
		}finally{
			lock.unlock();
		}
	}
	public void setY(int y){
		lock.lock();	
		try{
			this.y = y;
		}finally{
			lock.unlock();
		}
	}

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
