package fr.legbt.binge.items;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import fr.legbt.binge.Binge;


/**
 * Rect is a simple rectangular item
 */
public abstract class Rect extends MovableItem{
	private Rectangle2D.Double therect;
	private BufferedImage texture;
	private boolean topcollide;
	private boolean botomcollide;
	private boolean leftcollide;
	private boolean rightcollide;

	/**
	 * Constructor for Rect defined by the top left point
	 */
	public Rect(Binge game,String nameid, int line, int column, int height, int width,HashMap<String,Object> raw){
		super(game,nameid,line,column,raw);
		this.height = height;
		this.width = width;
		this.therect = new Rectangle2D.Double(this.getX(),this.getY(),width,height);
		this.texture = null;
		this.leftcollide = false;
		this.rightcollide = false;
		this.topcollide = false;
		this.botomcollide = false;
	}


	public void setTexture(String image){
		this.texture = Binge.getTexture(image);
	}


	public void traceMe(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		therect.setFrame(this.getX(),this.getY(),width,height);
		if(texture == null){
			//g.fillRect(this.getX(),this.getY(),width,height);
			g2.fill(therect);
		}else{
			g2.drawImage(texture,this.getX(),this.getY(),null);
			//g2.fill(therect);
		}
	}

	public Rectangle2D.Double getRect(){
		return therect;
	}


	protected Boolean collideWith(MovableItem mitem){
		if (mitem instanceof Disc){
			Ellipse2D.Double circle = new Ellipse2D.Double(mitem.xnext, mitem.ynext, ((Disc)mitem).diameter, ((Disc)mitem).diameter);
			//	Ellipse2D.Double circle = ((Disc)mitem).getDisc();
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

	/**
	 * Gets the height for this instance.
	 *
	 * @return The height.
	 */
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * Gets the width for this instance.
	 *
	 * @return The width.
	 */
	public int getWidth()
	{
		return this.width;
	}


	/**
	 * Determines if this instance is topcollision.
	 *
	 * @return The topcollision.
	 */
	public boolean topCollide()
	{
		return this.topcollide;
	}


	/**
	 * Determines if this instance is botomcollision.
	 *
	 * @return The botomcollision.
	 */
	public boolean botomCollide()
	{
		return this.botomcollide;
	}


	/**
	 * Determines if this instance is leftcollision.
	 *
	 * @return The leftcollision.
	 */
	public boolean leftCollide()
	{
		return this.leftcollide;
	}


	/**
	 * Determines if this instance is rightcollision.
	 *
	 * @return The rightcollision.
	 */
	public boolean rightCollide()
	{
		return this.rightcollide;
	}

}
