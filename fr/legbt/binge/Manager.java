package fr.legbt.binge;

import fr.legbt.binge.items.*;
import fr.legbt.binge.data.*;
import fr.legbt.binge.ui.*;

abstract class Manager{
	private CollisionsManager collisionsmanager;
	protected PaintManager paintmanager;
	private ActionsManager actionsmanager;

	Manager(){
		this.collisionsmanager = new CollisionsManager();
		this.actionsmanager = new ActionsManager();
	}
	
	/**Each movable item can be correctly initialized on the go for trace and collisions with this method.*/
	public void registerItem(MovableItem item){
		collisionsmanager.register(item);
		paintmanager.register(item);
		actionsmanager.register(item);
	}
	/**Each fixed item can be correctly initialized on the go for trace and collisions with this method.*/
	public void registerItem(FixedItem item){
		collisionsmanager.register(item);
		paintmanager.register(item);
		actionsmanager.register(item);
	}
	/**Each movable item can be correctly removed on the go for trace and collisions with this method.*/
	public void unRegisterItem(MovableItem item){
		collisionsmanager.unRegister(item);
		paintmanager.unRegister(item);
		actionsmanager.unRegister(item);
	}
	/**Each fixed item can be correctly removed on the go for trace and collisions with this method.*/
	public void unRegisterItem(FixedItem item){
		collisionsmanager.unRegister(item);
		paintmanager.unRegister(item);
		actionsmanager.unRegister(item);
	}
	public void registerUI(StaticInfo sti){paintmanager.register(sti);}
	public void unRegisterUI(StaticInfo sti){paintmanager.unRegister(sti);}
	public void traceThemAll(){this.paintmanager.traceThemAll();}
}

