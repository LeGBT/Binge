package fr.legbt.binge.items;

import java.awt.Rectangle;
import java.awt.event.*;
import java.util.HashMap;

import fr.legbt.binge.Binge;



public abstract class MovableItem extends Item implements KeyListener {
	Boolean collided;
	Boolean collide;
	public Boolean wasneverfree;
	protected double xspeed;
	protected double yspeed;
	protected int width;
	protected int height;
	public int xnext;
	public int ynext;

	protected MovableItem(Binge game, String nameid, int line, int column, HashMap<String,Object> raw){
		super(game,nameid,line,column,raw);
		this.xspeed = 0d;
		this.yspeed = 0d;
		this.xnext = this.getX();
		this.ynext = this.getY();
		this.wasneverfree = true;
		this.collided = false;
		this.collide = false;
	}
	protected MovableItem(DataItem data, int line, int column){
		super(data,line,column);
		this.xspeed = 0d;
		this.yspeed = 0d;
		this.xnext = this.getX();
		this.ynext = this.getY();
		this.wasneverfree = true;
		this.collided = false;
		this.collide = false;
	}

	final protected void move(int newx, int newy){
		this.xnext = newx;
		this.ynext = newy;
	}

	final public void setGame(Binge game){game.registerItem(this);}
	final public void unRegister(Binge game){game.unRegisterItem(this);}
	final public int getX(){return super.getX();}
	final public int getY(){return super.getY();}
	final public int getNextX(){return this.xnext;}
	final public int getNextY(){return this.ynext;}
	final public double getXSpeed(){return this.xspeed;}
	final public double getYSpeed(){return this.yspeed;}
	final public void setXSpeed(double nxs){ this.xspeed = nxs;}
	final public void setYSpeed(double nys){ this.yspeed = nys;}
	protected void setListener(Binge game){game.getFrame().addKeyListener(this);}
	protected void unSetListener(Binge game){game.getFrame().removeKeyListener(this);}
	final public void keyPressed(KeyEvent key){this.onKeyDown(key.getKeyCode());}
	final public void keyReleased(KeyEvent key){this.onKeyUp(key.getKeyCode());}
	public void keyTyped(KeyEvent key){}


	protected abstract void onCollide(MovableItem mitem);
	protected abstract void onCollide(FixedItem fitem);
	protected abstract void onKeyUp(int keycode);
	protected abstract void onKeyDown(int keycode);
	protected abstract void action();

	void preAction(){
		this.action();
	}


	/**
	 * Gets the collided for this instance.
	 *
	 * @return The collided.
	 */
	public Boolean getCollided()
	{
		return this.collided;
	}
	/**
	 * Gets the collide for this instance.
	 *
	 * @return The collide.
	 */
	public Boolean getCollide()
	{
		return this.collide;
	}
}
