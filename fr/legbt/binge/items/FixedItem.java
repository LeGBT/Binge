package fr.legbt.binge.items;

import java.awt.*;
//import java.awt.event.*;
import fr.legbt.binge.Binge;

public abstract class FixedItem  extends Item{

	protected FixedItem(Binge game){
		super(game,0,0);
	}
	
	protected void registerThis(Manager manager){
		manager.register(this);
	}
}
