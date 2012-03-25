package fr.legbt.binge.items;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.concurrent.locks.*;
import fr.legbt.binge.Binge;


/**
 * Item is representing any drawable object with collisions capability.
 */
public abstract class Item {
	private int x;
	private int y;
	protected  Binge game;
	private ReentrantLock lock;
	protected DataItem data;
	// for the moment only the resolution 1280 by 720 is supported.
	// the lvl MUST be a 16 by 9 too.
	private final int res = 80;


	/** Init an Item from the lvl file.*/
	protected Item(DataItem data,int line, int column){
		lock = new ReentrantLock();
		this.x = res*column;
		this.y = res*line;
		this.data = data;
	}

	/** Init an Item with coordinates x,y and registered for paint and collisions.*/
	protected Item(Binge game,String nameid, int line, int column, HashMap<String,Object> raw){
		lock = new ReentrantLock();
		this.game = game;
		this.x = column*res;
		this.y = line*res;
		this.data = new DataItem(nameid,raw);
		game.getLvl().setTile(line,column,data);	
		this.setGame(game);
	}

	protected static  HashMap<String,Object> putRaw(String s,Object object){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(s,object);
		return map;
	}



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
		System.out.println("Item n°"+ data.getNameType() + " is a" + this.getClass().getName());
	}

	/** This method is called whenever a collition between this item and mitem is detected.*/
	protected abstract Boolean collideWith(MovableItem mitem);
	/** traceMe must define the way the item is drawn.*/
	protected abstract void traceMe(Graphics g);
	/** action is called at each frame ticks, use it to define the way you want your item to move.*/
	//protected abstract void action();
	public abstract void onLoaded(Binge game);
	public abstract void setGame(Binge game);

}
