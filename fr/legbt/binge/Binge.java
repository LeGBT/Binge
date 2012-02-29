package fr.legbt.binge;

import java.awt.*;
import javax.swing.*;
import fr.legbt.binge.items.*;
import fr.legbt.binge.timers.*;

public class Binge extends JPanel{
	private static final long serialVersionUID = 3l; //serialisation warnings
	public Rectangle screen, bounds;
	public JFrame frame;
	public BingeTask atimer;
	public Ball laballe;
	public CollisionsManager cm;

	public Binge(){
		super();
		screen = new Rectangle(300,200,1280,720);
		bounds = new Rectangle(0,0,1280,700);
		frame = new JFrame("Mon vieux pong");
		atimer = new BingeTask(this);
	//	laballe = new Ball(40,7,7,70,70);
		cm = new CollisionsManager();
	}

	public void timedActions(){
	//	laballe.register(cm);
		cm.testCollisions();
		frame.repaint();
	}

	public void paintComponent(Graphics g){
		bounds = g.getClipBounds();
		g.clearRect(screen.x,screen.y,screen.width,screen.height);
	//	laballe.traceMe();
	}

	public static void main(String arg[]){
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
}
