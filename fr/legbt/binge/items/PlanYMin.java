package fr.legbt.binge.items;

import java.awt.Graphics;

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
		super(game,"PlanYMin");
		this.y = y;
	}

	public static Item selfCreate(Binge game, DataItem data, int line, int column){
		return new PlanYMin(game, column*80);
	}

	protected Boolean collideWith(MovableItem mitem){
		if (mitem instanceof Rect){
			if (mitem.ynext <= y){ return true;} else {
				return false;}
		}
		if (mitem instanceof Ball){
			if (mitem.ynext <= y){ return true;} else {
				return false;}
		}	
		return false;
	}

	public void traceMe(Graphics g){
		g.fillRect(0,0,(int)g.getClipBounds().getWidth(),y);
	}

}
