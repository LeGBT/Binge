package fr.legbt.binge.items;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import fr.legbt.binge.*;


/**
 * Plan describe a half plan item for simple bounding collisions.
 */
public abstract class Plan extends FixedItem{
	private Rectangle2D lerect;

	/**
	 * Simple Plan class
	 */
	public Plan(Binge game, String nametype, int line, int column, HashMap<String,Object> raw){
		super(game,nametype,line,column,raw);
		this.lerect = new Rectangle2D.Double(0,0,0,0);
	}
	public Plan(DataItem data, int line, int column){
		super(data,line,column);
		this.lerect = new Rectangle2D.Double(0,0,0,0);
	}

	public abstract void traceMe(Graphics g);
	protected void action(){}
	public void onLoaded(Binge game){}
	/**
	 * Gets the lerect for this instance.
	 *
	 * @return The lerect.
	 */
	public Rectangle2D getLerect()
	{
		return this.lerect;
	}
	
}
