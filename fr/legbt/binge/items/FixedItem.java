package fr.legbt.binge.items;

import java.awt.*;
import fr.legbt.binge.Binge;

/**
 * Implement a FixedItem to represent any non movable object with collisions and graphic gestion.
 */
public abstract class FixedItem  extends Item{

	protected FixedItem(Binge game){
		super(game,0,0);
	}
/**
 * This is a method to track the item on the go with the managers (collisions or paint)
 */
	public void setGame(Binge game){
		game.registerItem(this);
	}

}
