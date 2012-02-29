package fr.legbt.binge.items;

/**
 * Rect is a simple rectangular item
 */
public abstract class Rect extends Item{
	protected int x;
	protected int y;
	protected int height;
	protected int width;

	/**
	 * Constructor for Rect defined by the top left point
	 */
	public Rect(int x, int y, int height, int width){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
}
