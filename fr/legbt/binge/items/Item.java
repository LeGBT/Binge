package fr.legbt.binge.items;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import fr.legbt.binge.Binge;
import fr.legbt.binge.data.*;


public abstract class Item implements Serializable {
	protected transient Binge game;
	public transient CollisionsManager collisionsmanager;
	public transient PaintManager paintmanager;
	public transient ActionsManager actionsmanager;
	protected int x;
	protected int y;
	private transient int uniqueid;

	protected Item(int x, int y){
		this.x = x;
		this.y = y;
	}


	protected Item(Binge game, int x, int y){
		this.game = game;
		this.x = x;
		this.y = y;
		this.collisionsmanager = game.collisionsmanager;
		this.paintmanager = game.paintmanager;
		this.actionsmanager = game.actionsmanager;
		this.registerThis(this.actionsmanager);
		this.registerThis(this.collisionsmanager);
		this.registerThis(this.paintmanager);
		this.uniqueid = 0;
		game.getLvl().addItem(this);	
	}

	public void setID(int i){ this.uniqueid = i;}
	public int getID(){return uniqueid;}
	public int getX(){return this.x;}
	public int getY(){return this.y;}

	public void setGame(Binge game){
		this.game = game;
		this.collisionsmanager = game.collisionsmanager;
		this.paintmanager = game.paintmanager;
		this.actionsmanager = game.actionsmanager;
		this.registerThis(game.actionsmanager);
		this.registerThis(game.collisionsmanager);
		this.registerThis(game.paintmanager);
	}

	public void printNFO(){
		System.out.println("Item n°"+ uniqueid + " is a" + this.getClass().getName());
	}

	protected abstract Boolean collideWith(MovableItem mitem);
	protected abstract void traceMe(Graphics g);
	protected abstract void action();
	protected abstract void registerThis(Manager manager);

}
