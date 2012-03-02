package fr.legbt.binge.items;

/**
 * Plan describe a right vertical half plan item for simple bounding collisions.
 */
public abstract class PlanXMin extends Plan{

	protected int x;

	/**
	 * Xmax Plan construction 
	 */
	public PlanXMin(CollisionsManager cm, int x){
		super(cm);
		this.x = x;
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Rect){
			if (item.x <= x){ return true;} else {
				return false;}
		}
		if (item instanceof Ball){
			if (item.x <= x){ return true;} else {
				return false;}
		}	
		return false;
	}
}
