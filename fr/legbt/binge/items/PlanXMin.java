package fr.legbt.binge.items;

import java.awt.Graphics;

import fr.legbt.binge.*;


/**
 * Plan describe a right vertical half plan item for simple bounding collisions.
 */
public class PlanXMin extends Plan{
	protected int x;

	/**
	 * Xmax Plan construction 
	 */
	public PlanXMin(Binge game, int x){
		super(game,"PlanXMin");
		this.x = x;
	}

	public PlanXMin selfCreate(Binge game, DataItem data, int line, int column){
		return new PlanXMin(game, line*80);
	}

	protected Boolean collideWith(MovableItem mitem){
		if (mitem instanceof Rect){
			if (mitem.xnext <= x){ return true;} else {
				return false;}
		}
		if (mitem instanceof Ball){
			if (mitem.xnext <= x){ return true;} else {
				return false;}
		}	
		return false;
	}
	public void traceMe(Graphics g){
		g.fillRect(0,0,x,(int)g.getClipBounds().getHeight());
	}

}
