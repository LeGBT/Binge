package fr.legbt.binge;

//import java.awt.*;
import javax.swing.*;
import fr.legbt.binge.data.*;
import fr.legbt.binge.graphics.BGComp;
import fr.legbt.binge.graphics.BackgroundsStruct;
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
	private DrawThread dt;
	@SuppressWarnings("unused")
		private int framerate;

	/**Create a new game.*/
	public Binge(ItemFactory factory, String name, String lvlfile, int width, int height, int framerate, BackgroundsStruct bg){
		this.factory = factory;
		this.res = 80;
		this.paintmanager = new PaintManager(this);
		this.framerate = framerate;
		dt = new DrawThread(this,name,width,height,framerate,bg);
		this.lvl = new Level(16,9);
	}
	public Binge(ItemFactory factory, String name, String lvlfile, int width, int height, int framerate){
		this.factory = factory;
		this.res = 80;
		this.paintmanager = new PaintManager(this);
		this.framerate = framerate;
		dt = new DrawThread(this,name,width,height,framerate,new BackgroundsStruct());
		this.lvl = new Level(16,9);
	}
	public Binge(ItemFactory factory, String lvlfile){
		this.factory = factory;
		this.res = 80;
		this.paintmanager = new PaintManager(this);
		this.framerate = 20;
		dt = new DrawThread(this,"A Simple Game",1280,720,20,new BackgroundsStruct());
		this.lvl = new Level(16,9);
	}
	public Binge(String lvlfile){
		this.factory = new ItemFactory();
		this.res = 80;
		this.paintmanager = new PaintManager(this);
		this.framerate = 20;
		dt = new DrawThread(this,"A Simple Game",1280,720,20,new BackgroundsStruct());
		this.lvl = new Level(16,9);
	}
	public Binge(String lvlfile, BackgroundsStruct bg){
		this.factory = new ItemFactory();
		this.res = 80;
		this.paintmanager = new PaintManager(this);
		this.framerate = 20;
		dt = new DrawThread(this,"A Simple Game",1280,720,20,bg);
		this.lvl = new Level(16,9);
	}
	/**This load method is used to launch the game with saved lvl.*/
	public void load(String lvlfile){
		this.lvl = Level.loadLvl(lvlfile,this);
		//run thread !
		dt.execute();
	}

	/** Move the background according to your players moves */
	public void backgroundMove(int delta){
		BGComp[] compos = this.dt.getPanel().getBGComps();
		for(int i=0;i<compos.length;i++){
			compos[i].addXshift(delta);
		}
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
	public void timedActions(){}


	public UIShow getUIShow(){return dt.getPanel().getUIShow();}
	public DrawZone getDrawZone(){return dt.getPanel().getDrawZone();}
	public JFrame getFrame(){return	dt.getPanel().getFrame();}
	/**
	 * Gets the res for this instance.
	 *
	 * @return The resolution of the game.
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
