package fr.legbt.binge.items;

import java.awt.*;
import java.awt.event.*;
import fr.legbt.binge.Binge;


public abstract class Item implements KeyListener{
	public CollisionsManager collisionsmanager;
	public PaintManager paintmanager;
	public Boolean collided;
	public Boolean collide;
	public Boolean wasneverfree;
	protected int x;
	protected int y;
	protected int xspeed;
	protected int yspeed;
	protected int xnext;
	protected int ynext;
	//public Graphics graphics;

	protected Item(Binge game, int x, int y){
		this.x = x;
		this.y = y;
		this.xspeed = 0;
		this.yspeed = 0;
		this.xnext = x;
		this.ynext = y;
		this.collisionsmanager = game.collisionsmanager;
		this.paintmanager = game.paintmanager;
		this.wasneverfree = true;
		this.collided = true;
		this.collisionsmanager.register(this); 
		this.paintmanager.register(this); 
	}

	final protected void move(int newx, int newy){
		this.xnext = newx;
		this.ynext = newy;
	}

	public void keyPressed(KeyEvent key){
		onKeyDown(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key){
		onKeyUp(key.getKeyCode());
	}
	public void keyTyped(KeyEvent key){}

	void setPosition(int x, int y){
		if ((!collide)||(wasneverfree)){
			this.setXY(x,y);
		}
	}
	void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	protected abstract Boolean collideWith(Item item);
	public abstract void traceMe(Graphics g);
	protected abstract void onKeyUp(int keycode);
	protected abstract void onKeyDown(int keycode);
}
