package fr.legbt.binge.items;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Rect is a simple rectangular item
 */
public abstract class Rect extends Item{
	protected int height;
	protected int width;

	/**
	 * Constructor for Rect defined by the top left point
	 */
	public Rect(CollisionsManager cm, int x, int y, int height, int width){
		super(cm,x,y);
		this.height = height;
		this.width = width;
	}
	protected Boolean collideWith(Item item){
		if (item instanceof Ball){
			Ellipse2D.Double circle = new Ellipse2D.Double(item.x, item.y, ((Ball)item).radius, ((Ball)item).radius);
			if (circle.intersects(this.x, this.y, this.width, this.height)){
				return true;
			}
			return false;
		}
		if (item instanceof Rect){
			Rectangle2D.Double lerect = new Rectangle2D.Double(this.x,this.y,this.width,this.height);
			if (lerect.intersects(item.x,item.y,((Rect)item).width,((Rect)item).height)){
				return true;
			}
			return false;
		}
		return false;
	}
}
