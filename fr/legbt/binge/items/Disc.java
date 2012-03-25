package fr.legbt.binge.items;

import java.awt.geom.Ellipse2D;
import java.awt.*;
import java.util.HashMap;

import fr.legbt.binge.Binge;


/**
 * Disc is a simple disc item.
 */
public abstract class Disc extends MovableItem{
	protected int xcenter;
	protected int ycenter;
	protected int diameter;
	private Ellipse2D.Double theball;

	/**
	 * Constructor for Disc defined by the top left coordinate point of the smallest square containing the ball. 
	 */
	public Disc(Binge game,String nameid, int line, int column, int diameter,HashMap<String,Object> raw){
		super(game,nameid,line,column,raw);
		int x = column*game.getRes();
		int y = line*game.getRes();
		this.xcenter = x + diameter/2;
		this.ycenter = y + diameter/2;
		this.diameter = diameter;
		this.width = diameter;
		this.height = diameter;
		this.theball = new Ellipse2D.Double(x,y,diameter,diameter);
	}
	public Disc(DataItem data, int line, int column, int diameter){
		super(data,line,column);
		this.xcenter = column*data.getRes() + diameter/2;
		this.ycenter = line*data.getRes() + diameter/2;
		this.diameter = diameter;
		this.theball = new Ellipse2D.Double(column*data.getRes(),line*data.getRes(),diameter,diameter);
	}

	/** 
	 * Trace this ball in graphics g
	 */
	public void traceMe(Graphics g){
		theball.setFrame(this.getX(),this.getY(),diameter,diameter);
		((Graphics2D)g).fill(theball);
	}

	public int getDiameter(){
		return this.diameter;
	}
	/**
	 * Return the actual graphic disc.
	 */
	protected Ellipse2D.Double getDisc(){
		theball.setFrame(this.getX(),this.getY(),diameter,diameter);
		return this.theball;
	}

	/**
	 * Implement simple collisions with either Rect items or other Disc.
	 */
	protected Boolean collideWith(MovableItem mitem){
		if (mitem instanceof Disc){
			Disc it = (Disc) mitem; 
			Double dist = Math.pow((it.xnext-this.xnext +  it.diameter/2 - this.diameter/2),2) + Math.pow((it.ynext-this.ynext + it.diameter/2 - this.diameter/2),2);
			if (dist <= ((it.diameter/2+this.diameter/2)*(it.diameter/2+this.diameter/2))){
				return true;
			}
			return false;
		}
		if (mitem instanceof Rect){
			Rect it = (Rect) mitem;
			theball.setFrame(xnext,ynext,diameter,diameter);
			Ellipse2D.Double circle = this.theball;
			if (circle.intersects(it.xnext, it.ynext, it.width, it.height)){
				theball.setFrame(this.getX(),this.getY(),diameter,diameter);
				return true;
			}
			theball.setFrame(this.getX(),this.getY(),diameter,diameter);
			return false;
		}
		return false;
	}
}	
