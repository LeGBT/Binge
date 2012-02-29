package fr.legbt.binge.items;

import java.awt.*;
import java.util.Stack;
import java.util.ArrayList;
import java.awt.event.*;

public abstract class Item implements KeyListener{
	public CollisionsManager cm;
	public Graphics g;


	protected void move(int newx, int newy){
		this.cm.tryToMove(this,newx,newy);	
	}
	public void keyPressed(KeyEvent key){
		onKeyDown(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key){
		onKeyUp(key.getKeyCode());
	}
	public void keyTyped(KeyEvent key){}

	protected abstract void setPosition(int x, int y);
		// il faut changer ça pour que la modif se fasse que quand tout les tests ont été fait puis peut être restester si c'est bon ?
	protected abstract void collide();
	public abstract void traceMe();
	public abstract void onKeyUp(int keycode);
	public abstract void onKeyDown(int keycode);
}
