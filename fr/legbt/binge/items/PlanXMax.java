package fr.legbt.binge.items;

import java.awt.Graphics;

import fr.legbt.binge.*;


/**
 * PlanXMax describe a right vertical half plan item for simple bounding collisions.
 */
public class PlanXMax extends Plan{
	protected int x;

	/**
	 * Xmax Plan construction 
	 */
	public PlanXMax(Binge game, int column){
		super(game,"PlanXMax",0,column,null);
		this.x = column*game.getRes();
	}
	public PlanXMax(DataItem data, int column){
		super(data,0,column);
		this.x = column*data.getRes();
	}

	protected Boolean collideWith(MovableItem mitem){
		if (mitem instanceof Rect){
			if (mitem.xnext+((Rect)mitem).width >= x){ return true;} else {
				return false;}
		}
		if (mitem instanceof Disc){
			if (mitem.xnext+((Disc)mitem).diameter >= x){ return true;} else {
				return false;}
		}	
		return false;
	}

	public void traceMe(Graphics g){
		g.fillRect(x,0,(int)g.getClipBounds().getWidth()-x,(int)g.getClipBounds().getHeight());
	}	
}
