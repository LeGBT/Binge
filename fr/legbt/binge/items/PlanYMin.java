package fr.legbt.binge.items;

import java.awt.geom.Rectangle2D;
import java.awt.*;
import fr.legbt.binge.*;

/**
 * PlanYMin describe a top horizontal half plan item for simple bounding collisions.
 */
public class PlanYMin extends Plan{
	protected int y;

	/**
	 * Ymay Plan construction 
	 */
	public PlanYMin(Binge game, int y){
		super(game);
		this.y = y;
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Rect){
			if (item.ynext <= y){ return true;} else {
				return false;}
		}
		if (item instanceof Ball){
			if (item.ynext <= y){ return true;} else {
				return false;}
		}	
		return false;
	}

	public void traceMe(Graphics g){
		g.fillRect(0,0,game.getWidth(),y);

	}

}
