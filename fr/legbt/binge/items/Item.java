package fr.legbt.binge.items;

import java.awt.*;
import java.util.Stack;
import java.util.ArrayList;
import java.awt.event.*;

public abstract class Item extends ItemId implements KeyListener{
	public CollisionsManager cm;
	public Graphics g;
	private int x;
	private int y;


	protected void move(int newx, int newy){
		this.cm.tryToMove(this,newx,newy);	
	}
	protected void setPosition(int newx, int newy){
		this.x = newx;
		this.y = newy;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.x;
	}
	public void keyPressed(KeyEvent key){
		onKeyDown(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key){
		onKeyUp(key.getKeyCode());
	}
	public void keyTyped(KeyEvent key){}

	protected abstract void collide();
	public abstract void traceMe();
	public abstract void onKeyUp(int keycode);
	public abstract void onKeyDown(int keycode);
}
