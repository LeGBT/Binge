package fr.legbt.binge.items;

import java.awt.*;
//import java.util.Stack;
//import java.util.ArrayList;
import java.awt.event.*;

public abstract class Item implements KeyListener{
	public CollisionsManager collisionsmanager;
	public Boolean collided;
	public Boolean collide;
	public Boolean wasneverfree;
	//public Graphics graphics;


	protected Item(CollisionsManager cm){
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
	// il faut changer ça pour que la modif se fasse que quand tout les tests ont été fait puis peut être restester si c'est bon ?
	abstract void setXY(int x, int y);
	protected abstract void collide();
	public abstract void traceMe();
	protected abstract void onKeyUp(int keycode);
	protected abstract void onKeyDown(int keycode);
}
