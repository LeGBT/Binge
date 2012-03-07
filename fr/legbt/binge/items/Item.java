package fr.legbt.binge.items;

import java.awt.*;
import java.awt.event.*;
import fr.legbt.binge.Binge;


public abstract class Item {
	protected Binge game;
	public CollisionsManager collisionsmanager;
	public PaintManager paintmanager;
	public ActionsManager actionsmanager;
	protected int x;
	protected int y;

	protected Item(Binge game, int x, int y){
		this.game = game;
		this.x = x;
		this.y = y;
		this.collisionsmanager = game.collisionsmanager;
		this.paintmanager = game.paintmanager;
		this.actionsmanager = game.actionsmanager;
		//this.actionsmanager.register(this); 
		//this.collisionsmanager.register(this); 
		//this.paintmanager.register(this); 
		this.registerThis(this.actionsmanager);
		this.registerThis(this.collisionsmanager);
		this.registerThis(this.paintmanager);
	}

	public int getX(){return this.x;}
	public int getY(){return this.y;}

	protected abstract Boolean collideWith(MovableItem mitem);
	protected abstract void traceMe(Graphics g);
	protected abstract void action();
	protected abstract void registerThis(Manager manager);

}
