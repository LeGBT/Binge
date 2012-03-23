package fr.legbt.binge.items;

import java.util.HashMap;

import fr.legbt.binge.Binge;


/**
 * Implement a FixedItem to represent any non movable object with collisions and graphic gestion.
 */
public abstract class FixedItem  extends Item{

	protected FixedItem(Binge game, String nametype, int line, int column, HashMap<String,Object> raw){
		super(game,nametype,line,column,raw);
	}
	protected FixedItem(DataItem data, int line, int column){
		super(data,line,column);
	}
	/**
	 * This is a method to track the item on the go with the managers (collisions or paint)
	 */
	public void setGame(Binge game){
		game.registerItem(this);
	}
}
