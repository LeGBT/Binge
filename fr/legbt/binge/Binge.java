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


	public Binge(String name,String lvlfile, int width, int height, int framerate){
		this.bpanel = new BingePanel(this,name,width,height);
		this.atimer = new BingeTask(this);
		java.util.Timer newtimer = new java.util.Timer();
		this.collisionsmanager = new CollisionsManager();
		this.paintmanager = new PaintManager(this);
		this.actionsmanager = new ActionsManager();
		this.lvlfile = lvlfile;
		loadLvl(lvlfile);
		newtimer.schedule(this.atimer,0,framerate);
	}


	public void timedActions(){
		this.actionsmanager.actionThemAll();
		this.collisionsmanager.testCollisions();
		this.bpanel.moveZone();
		this.bpanel.getFrame().repaint();
	}

	public DrawZone getDZ(){
		return this.bpanel.getDZ();
	}
	public JFrame getFrame(){return	this.bpanel.getFrame();}
	public Level getLvl(){return this.lvl;}
	public int getWidth(){return this.bpanel.getFrame().getWidth();}
	public int getHeight(){return this.bpanel.getFrame().getHeight();}

	public void loadLvl(String lvlfile){
		try{
			this.lvl = IOManager.readLevel();
		} catch(Exception e){
			System.out.println(" binge segfault :" + e);
			e.printStackTrace();
		}
		this.itemlist =	this.lvl.getItemList();
		for(int i=0; i<itemlist.size(); i++){
			this.itemlist.get(i).setGame(this);
		}
	}
}
