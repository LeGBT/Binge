package fr.legbt.binge.items;

/**
 * Plan describe a half plan item for simple bounding collisions.
 */
public abstract class Plan extends FixedItem{
	//final static int XMAX = 3;
	//final static int XMIN = 12;
	//final static int YMAX = 5;
	//final static int YMIN = 10;


	/**
	 * Simple Plan class
	 */
	public Plan(CollisionsManager cm){
		super(cm);
	}

	abstract protected Boolean collideWith(Item item);
}
