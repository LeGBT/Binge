package fr.legbt.binge;

//import java.awt.*;
import javax.swing.*;
import fr.legbt.binge.data.*;
import fr.legbt.binge.graphics.DrawZone;
import fr.legbt.binge.graphics.UIShow;
import fr.legbt.binge.items.*;
import fr.legbt.binge.thread.*;
import fr.legbt.binge.timers.*;


/** 
 * Main class of binge;
 * Just instantiate one and let the magic free !
 */ 
public class Binge  extends Manager{
	@SuppressWarnings("unused")
		private BingeTask atimer;
	private int res;
	private Level lvl;
	private ItemFactory factory;
	//	private BingePanel bpanel;
	private DrawThread dt;
	@SuppressWarnings("unused")
		private int framerate;
	@SuppressWarnings("unused")
		private java.util.Timer timer;

	/**Create a new game.*/
	public Binge(ItemFactory factory, String name, String lvlfile, int width, int height, int framerate){
		this.factory = factory;
		this.res = 80;
		this.paintmanager = new PaintManager(this);
		this.framerate = framerate;
		dt = new DrawThread(this,name,width,height,framerate);
		this.lvl = new Level(16,9);
	}

	/**This load method is used to launch the game with saved lvl.*/
	public void load(String lvlfile){
		this.lvl = Level.loadLvl(lvlfile,this);
		//run thread !
		dt.execute();
	}

	/**This load method is used to launch the game, all the items must have been already initilized.*/
	public void load(){
		//run thread !
		dt.execute();
	}

	/** 
	 * This method is called at each ticks
	 * It's not advised to override it.
	 */
	public void timedActions(){
		//	this.actionsmanager.actionThemAll();
		//	this.collisionsmanager.testCollisions();
		//this.bpanel.getFrame().repaint();
	}
	//	/**@deprecated Will soon be replaced by {@link #getGraphics}*/
	//	@Deprecated
	//	public Graphics getItemDrawZoneGraphics(){return dt.getPanel().getItemDrawZoneGraphics();}
	//	public Graphics getGraphics(){return dt.getPanel().getItemDrawZoneGraphics();}
	public UIShow getUIShow(){return dt.getPanel().getUIShow();}
	public DrawZone getDrawZone(){return dt.getPanel().getDrawZone();}
	public JFrame getFrame(){return	dt.getPanel().getFrame();}
	/**
	 * Gets the res for this instance.
	 *
	 * @return The res.
	 */
	public int getRes()
	{
		return this.res;
	}

	public Level getLvl(){return this.lvl;}

	/**
	 * Gets the factory for this instance.
	 *
	 * @return The factory.
	 */
	public ItemFactory getFactory()
	{
		return this.factory;
	}
}
