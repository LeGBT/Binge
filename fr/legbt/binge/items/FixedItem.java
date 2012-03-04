package fr.legbt.binge.items;

import java.awt.*;
//import java.awt.event.*;
import fr.legbt.binge.Binge;

public abstract class FixedItem {
	protected Binge game;
	public CollisionsManager collisionsmanager;
	public PaintManager paintmanager;

	protected FixedItem(Binge game){
		this.game = game;
		this.collisionsmanager = game.collisionsmanager;
		this.paintmanager = game.paintmanager;
		this.collisionsmanager.register(this); 
		this.paintmanager.register(this); 
	}

	public abstract void traceMe(Graphics g);
	protected abstract Boolean collideWith(Item item);
}
