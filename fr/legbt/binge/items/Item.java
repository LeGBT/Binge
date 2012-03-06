package fr.legbt.binge.items;

import java.awt.*;
import java.awt.event.*;
import fr.legbt.binge.Binge;


public abstract class Item implements KeyListener{
	private Binge game;
	public CollisionsManager collisionsmanager;
	public PaintManager paintmanager;
	public ActionsManager actionsmanager;
	public Boolean collided;
	public Boolean collide;
	public Boolean wasneverfree;
	protected int x;
	protected int y;
	protected double xspeed;
	protected double yspeed;
	public int xnext;
	public int ynext;
	//public Graphics graphics;

	protected Item(Binge game, int x, int y){
		this.game = game;
		this.x = x;
		this.y = y;
		this.xspeed = 0d;
		this.yspeed = 0d;
		this.xnext = x;
		this.ynext = y;
		this.collisionsmanager = game.collisionsmanager;
		this.paintmanager = game.paintmanager;
		this.actionsmanager = game.actionsmanager;
		this.wasneverfree = true;
		this.collided = true;
		this.collide = false;
		this.collisionsmanager.register(this); 
		this.paintmanager.register(this); 
		this.actionsmanager.register(this); 
	}

	final protected void move(int newx, int newy){
		this.xnext = newx;
		this.ynext = newy;
	}

	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public double getXSpeed(){return this.xspeed;}
	public double getYSpeed(){return this.yspeed;}
	public void setXSpeed(double nxs){ this.xspeed = nxs;}
	public void setYSpeed(double nys){ this.yspeed = nys;}

	protected void setListener(){
		this.game.frame.addKeyListener(this);
	}
	protected void unSetListener(){
		this.game.frame.removeKeyListener(this);
	}

	public void keyPressed(KeyEvent key){
		this.onKeyDown(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key){
		this.onKeyUp(key.getKeyCode());
	}
	public void keyTyped(KeyEvent key){}

	void setPosition(int x, int y){
		this.setXY(x,y);
	}
	void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	protected abstract Boolean collideWith(Item item);
	protected abstract void onCollide(Item item);
	protected abstract void onCollide(FixedItem fixeditem);
	protected abstract void traceMe(Graphics g);
	protected abstract void action();
	protected abstract void onKeyUp(int keycode);
	protected abstract void onKeyDown(int keycode);
}
