package fr.legbt.binge;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.legbt.binge.graphics.TexturesLoader;
import fr.legbt.binge.items.ActionsManager;
import fr.legbt.binge.items.CollisionsManager;
import fr.legbt.binge.items.FixedItem;
import fr.legbt.binge.items.MovableItem;
import fr.legbt.binge.items.PaintManager;
import fr.legbt.binge.ui.StaticInfo;


abstract class Manager{
	private CollisionsManager collisionsmanager;
	protected PaintManager paintmanager;
	private ActionsManager actionsmanager;
	static private TexturesLoader texturesloader;

	Manager(){
		this.collisionsmanager = new CollisionsManager();
		this.actionsmanager = new ActionsManager();
		texturesloader = new TexturesLoader();	
	}


	/** Retrieve the buffered image for texturing by it's name */
	static public BufferedImage getTexture(String image){
		return texturesloader.get(image);
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
	public void traceItems(Graphics g){this.paintmanager.traceItems(g);}
	public void traceUI(Graphics g){this.paintmanager.traceUI(g);}
	public void actionThemAll(){this.actionsmanager.actionThemAll();}
	public void testCollisions(){this.collisionsmanager.testCollisions();}
}

