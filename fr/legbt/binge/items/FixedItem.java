package fr.legbt.binge.items;

//import java.awt.*;
//import java.awt.event.*;

public abstract class FixedItem {
	public CollisionsManager collisionsmanager;


	protected FixedItem(CollisionsManager cm){
		this.collisionsmanager = cm;
		this.collisionsmanager.register(this); 
	}

	public abstract void traceMe();
}
