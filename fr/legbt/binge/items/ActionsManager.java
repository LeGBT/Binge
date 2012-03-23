package fr.legbt.binge.items;


/**
 * Manage all "normal" actions, i.e. all actions to items whose are not in collisions.
 */
public class ActionsManager extends Manager {

	public ActionsManager(){
		super();
	}
	/** Call the action method of every registered item.*/
	public void actionThemAll(){
		try{
			for(int i=0;i<movableitemlist.size();i++){
				MovableItem mitem = movableitemlist.get(i);
				mitem.action();
			}

		}catch(Exception e){
			//System.out.println("ActionManager segfault ? " + e);
			e.printStackTrace();
		}
	}
}
