package fr.legbt.binge.items;

//import java.awt.*;
import java.awt.event.*;

public abstract class Item implements KeyListener{
	public CollisionsManager collisionsmanager;
	public Boolean collided;
	public Boolean collide;
	public Boolean wasneverfree;
	protected int x;
	protected int y;
	//public Graphics graphics;

	protected Item(CollisionsManager cm, int x, int y){
		this.x = x;
		this.y = y;
		this.collisionsmanager = cm;
		this.wasneverfree = true;
		this.collided = true;
		this.collisionsmanager.register(this); 
	}


	protected void move(int newx, int newy){
		this.collisionsmanager.tryToMove(this,newx,newy);	
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
	protected abstract void collide();
	public abstract void traceMe();
	protected abstract void onKeyUp(int keycode);
	protected abstract void onKeyDown(int keycode);
}
