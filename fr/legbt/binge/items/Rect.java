package fr.legbt.binge.items;

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
}
