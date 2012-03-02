package fr.legbt.binge.items;

/**
 * PlanYMin describe a top horizontal half plan item for simple bounding collisions.
 */
public abstract class PlanYMin extends Plan{

	protected int y;

	/**
	 * Ymay Plan construction 
	 */
	public PlanYMin(CollisionsManager cm, int y){
		super(cm);
		this.y = y;
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Rect){
			if (item.y <= y){ return true;} else {
				return false;}
		}
		if (item instanceof Ball){
			if (item.y <= y){ return true;} else {
				return false;}
		}	
		return false;
	}
}
