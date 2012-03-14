package fr.legbt.binge;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import fr.legbt.binge.items.*;
import fr.legbt.binge.timers.*;
import fr.legbt.binge.data.*;
import fr.legbt.binge.graphics.*;

public class Binge {
	public BingeTask atimer;
	public CollisionsManager collisionsmanager;
	public PaintManager paintmanager;
	public ActionsManager actionsmanager;
	private ArrayList<Item> itemlist;
	private String lvlfile;
	private Level lvl;
	private BingePanel bpanel;
	private int framerate;
	private java.util.Timer timer;

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
		//timer.schedule(this.atimer,0,this.framerate);
	}

	public void load(String lvlfile){
		this.lvl = Level.loadLvl(lvlfile,this);
		timer.schedule(this.atimer,0,this.framerate);
	}
	public void load(){
		timer.schedule(this.atimer,0,this.framerate);
	}

	public void timedActions(){
		this.actionsmanager.actionThemAll();
		this.collisionsmanager.testCollisions();
		//		this.bpanel.moveZone();
		this.bpanel.getFrame().repaint();
	}

	public Graphics getItemDrawZoneGraphics(){return this.bpanel.getItemDrawZoneGraphics();}
	public Graphics getUIGraphics(){return this.bpanel.getUIGraphics();}
	public JFrame getFrame(){return	this.bpanel.getFrame();}
	public Level getLvl(){return this.lvl;}
	public int getWidth(){return this.bpanel.getFrame().getWidth();}
	public int getHeight(){return this.bpanel.getFrame().getHeight();}
}
