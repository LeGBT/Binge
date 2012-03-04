package fr.legbt.binge;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import fr.legbt.binge.items.*;
import fr.legbt.binge.timers.*;

public class Binge extends JPanel{
	private static final long serialVersionUID = 3l; //serialisation warnings
	public Rectangle screen, bounds;
	public JFrame frame;
	public BingeTask atimer;
	public CollisionsManager collisionsmanager;
	private ArrayList<Item> itemlist;
	private ArrayList<FixedItem> fixeditemlist;



	public Binge(String name, int width, int height, int framerate){
		super();
		this.screen = new Rectangle(0,0,width,height);
		this.bounds = new Rectangle(0,0,width,height - 20);
		this.frame = new JFrame(name);
		this.atimer = new BingeTask(this);
		java.util.Timer newtimer = new java.util.Timer();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setFocusable(true);
		this.frame.setSize(width,height);
		this.collisionsmanager = new CollisionsManager();
		this.frame.setContentPane(this);
		this.frame.setVisible(true);
		newtimer.schedule(this.atimer,0,framerate);
	}

	public void timedActions(){
		this.collisionsmanager.testCollisions();
		this.frame.repaint();
	}

	public void paintComponent(Graphics g){
		this.bounds = g.getClipBounds();
		g.clearRect(screen.x,screen.y,screen.width,screen.height);
	}

	/*	public static void main(String arg[]){
		java.util.Timer montimer = new java.util.Timer();
		Binge panel = new Binge();

		panel.frame.setSize(1280,720);
		panel.frame.setMinimumSize(new Dimension(800,600));
		panel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // app exit when window close.
		panel.frame.setFocusable(true);
	//panel.frame.addKeyListener(panel.lepad);
	panel.frame.setContentPane(panel);
	panel.frame.setVisible(true);
	montimer.schedule(panel.atimer,0,20);
	}
	*/
}
