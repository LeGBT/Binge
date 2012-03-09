package fr.legbt.binge;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import fr.legbt.binge.items.*;
import fr.legbt.binge.timers.*;
import fr.legbt.binge.data.*;

public class Binge extends JPanel{
	private static final long serialVersionUID = 3l; //serialisation warnings
	public Rectangle screen, bounds;
	public JFrame frame;
	public BingeTask atimer;
	public CollisionsManager collisionsmanager;
	public PaintManager paintmanager;
	public ActionsManager actionsmanager;
	private ArrayList<Item> itemlist;
	private String lvlfile;
	private Level lvl;



	public Binge(String name,String lvlfile, int width, int height, int framerate){
		super();
		// test !!
		//		try{
		//			this.lvl = new Level(16,9);
		//			int[] aline = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,16};
		//			lvl.setLine(2,aline);
		//		IOManager.storeLevel(lvl);
		//		lvl = IOManager.readLevel();
		//		} catch(Exception e){
		//			System.out.println(" binge segfault :" + e);
		//			e.printStackTrace();
		//		}
		// fin test !!
		//	Level lvl = IOManager.readLevel();
		this.screen = new Rectangle(0,0,width,height);
		this.bounds = new Rectangle(0,0,width,height - 20);
		this.frame = new JFrame(name);
		this.atimer = new BingeTask(this);
		java.util.Timer newtimer = new java.util.Timer();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setFocusable(true);
		this.frame.setSize(width,height);
		this.collisionsmanager = new CollisionsManager();
		this.paintmanager = new PaintManager(this);
		this.actionsmanager = new ActionsManager();
		this.lvlfile = lvlfile;
		loadLvl(lvlfile);
		this.frame.setContentPane(this);
		this.frame.setVisible(true);
		newtimer.schedule(this.atimer,0,framerate);
	}


	public void timedActions(){
		this.actionsmanager.actionThemAll();
		this.collisionsmanager.testCollisions();
		this.frame.repaint();
	}

	public void paintComponent(Graphics g){
		this.bounds = g.getClipBounds();
		g.clearRect(screen.x,screen.y,screen.width,screen.height);
		this.paintmanager.traceThemAll();
	}

	public Level getLvl(){
		return this.lvl;
	}

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
