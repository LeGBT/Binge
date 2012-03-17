package fr.legbt.binge.items;

import java.awt.Graphics;

import fr.legbt.binge.*;


/**
 * PlanYMin describe a top horizontal half plan item for simple bounding collisions.
 */
public class PlanYMin extends Plan{
	private static final long serialVersionUID = 1l;
	protected int y;

	/**
	 * Ymay Plan construction 
	 */
	public PlanYMin(Binge game, int y){
		super(game);
		this.y = y;
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
