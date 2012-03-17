package fr.legbt.binge.items;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import fr.legbt.binge.Binge;


/**
 * Rect is a simple rectangular item
 */
@SuppressWarnings("serial")
public abstract class Rect extends MovableItem{
	private Rectangle2D.Double therect;
	protected int height;
	protected int width;

	/**
	 * Constructor for Rect defined by the top left point
	 */
	public Rect(Binge game, int x, int y, int height, int width){
		super(game,x,y);
		this.height = height;
		this.width = width;
		this.therect = new Rectangle2D.Double(x,y,width,height);
	}

	public void traceMe(Graphics g){
		therect.setFrame(this.getX(),this.getY(),width,height);
		g.fillRect(this.getX(),this.getY(),width,height);
	}

	public Rectangle2D.Double getRect(){
		return therect;
	}


	protected Boolean collideWith(MovableItem mitem){
		if (mitem instanceof Ball){
				Ellipse2D.Double circle = new Ellipse2D.Double(mitem.xnext, mitem.ynext, ((Ball)mitem).diameter, ((Ball)mitem).diameter);
		//	Ellipse2D.Double circle = ((Ball)mitem).getDisc();
			if (circle.intersects(this.xnext, this.ynext, this.width, this.height)){
				return true;
			}
			return false;
		}
		if (mitem instanceof Rect){
			Rectangle2D.Double rect = ((Rect)mitem).getRect();
			if (rect.intersects(this.xnext,this.ynext,this.width,this.height)){
				return true;
			}
			return false;
		}
		return false;
	}

}
