package fr.legbt.binge;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import fr.legbt.binge.items.*;
import fr.legbt.binge.timers.*;
import fr.legbt.binge.data.*;
import fr.legbt.binge.graphics.*;

public class Binge {
	private CollisionsManager collisionsmanager;
	private PaintManager paintmanager;
	private ActionsManager actionsmanager;
	private BingeTask atimer;
	private ArrayList<Item> itemlist;
	private String lvlfile;
	private Level lvl;
	private BingePanel bpanel;
	private int framerate;
	private java.util.Timer timer;

	/**
	 * Create a new game.
	 */
	public Binge(String name,String lvlfile, int width, int height, int framerate){
		this.framerate = framerate;
		this.bpanel = new BingePanel(this,name,width,height);
		this.atimer = new BingeTask(this);
		this.timer = new java.util.Timer();
		this.collisionsmanager = new CollisionsManager();
		this.paintmanager = new PaintManager(this);
		this.actionsmanager = new ActionsManager();
		this.lvlfile = lvlfile;
		this.lvl = new Level(0,0);
	}

	/**
	 * This load method is used to launch the game with saved lvl.
	 */
	public void load(String lvlfile){
		this.lvl = Level.loadLvl(lvlfile,this);
		timer.schedule(this.atimer,0,this.framerate);
	}
	/**
	 * This load method is used to launch the game, all the items must have been already initilized.
	 */
	public void load(){
		timer.schedule(this.atimer,0,this.framerate);
	}
	/** 
	 * This method is called at each ticks
	 * It's not advised to override it.
	 */
	public void timedActions(){
		this.actionsmanager.actionThemAll();
		this.collisionsmanager.testCollisions();
		this.bpanel.getFrame().repaint();
	}
/** 
 * Each movable item can be correctly initialized on the go for trace and collisions with this method.
 */
	public void registerItem(MovableItem item){
		collisionsmanager.register(item);
		paintmanager.register(item);
		actionsmanager.register(item);
	}
/** 
 * Each fixed item can be correctly initialized on the go for trace and collisions with this method.
 */
	public void registerItem(FixedItem item){
		collisionsmanager.register(item);
		paintmanager.register(item);
		actionsmanager.register(item);
	}
/** 
 * Each movable item can be correctly removed on the go for trace and collisions with this method.
 */
	public void unRegisterItem(MovableItem item){
		collisionsmanager.unRegister(item);
		paintmanager.unRegister(item);
		actionsmanager.unRegister(item);
	}
/** 
 * Each fixed item can be correctly removed on the go for trace and collisions with this method.
 */
	public void unRegisterItem(FixedItem item){
		collisionsmanager.unRegister(item);
		paintmanager.unRegister(item);
		actionsmanager.unRegister(item);
	}


	/**
	 * @deprecated Will soon be replaced by {@link #getGraphics}
	 */
	@Deprecated
		public Graphics getItemDrawZoneGraphics(){return this.bpanel.getItemDrawZoneGraphics();}
	public Graphics getGraphics(){return this.bpanel.getItemDrawZoneGraphics();}
	public Graphics getUIGraphics(){return this.bpanel.getUIGraphics();}
	public void traceThemAll(){this.paintmanager.traceThemAll();}
	public JFrame getFrame(){return	this.bpanel.getFrame();}
	public Level getLvl(){return this.lvl;}
	/**
	 * Return the width of the scene.
	 */
	public int getWidth(){return this.bpanel.getFrame().getWidth();}
	/**
	 * Return the height of the scene.
	 */
	public int getHeight(){return this.bpanel.getFrame().getHeight();}
}
