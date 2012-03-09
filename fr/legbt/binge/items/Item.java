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
		game.getLvl().addItem(this);	
	}

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

	protected abstract Boolean collideWith(MovableItem mitem);
	protected abstract void traceMe(Graphics g);
	protected abstract void action();
	protected abstract void registerThis(Manager manager);

}
