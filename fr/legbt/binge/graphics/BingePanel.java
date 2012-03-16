package fr.legbt.binge.graphics;

import java.awt.*;
import javax.swing.*;
//import fr.legbt.binge.Binge;
import fr.legbt.binge.thread.DrawThread;

/**
 * BingePanel is a class only use by Binge
 * Dont extend it.
 */
public class BingePanel extends JPanel{
	private static final long serialVersionUID = 3l; //serialisation warnings
	private Rectangle screen, bounds;
	private JFrame frame;
	private DrawZone drawzone;
	private UI ui;
	//Binge game;
	public DrawThread dt;

	public BingePanel(DrawThread dt,String name, int width, int height){
		super();
		this.setLayout(null);
		//this.game = game;
		this.dt = dt;
		this.screen = new Rectangle(0,0,width,height);
		this.bounds = new Rectangle(0,0,width,height);
		this.drawzone = new DrawZone(this,width,height);
		this.ui = new UI(this,width,height);
		this.add(drawzone);
		this.add(ui);
		drawzone.setSize(width,height);
		drawzone.setOpaque(false);
		ui.setSize(width,height);
		ui.setOpaque(false);
		this.frame = new JFrame(name);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setFocusable(true);
		this.frame.setSize(width,height);
		this.frame.setContentPane(this);
		this.frame.setVisible(true);
	}

	protected void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public boolean isOpaque(){return true;}
	public Graphics getItemDrawZoneGraphics(){return this.drawzone.getGraphics();}
	public Graphics getUIGraphics(){return this.ui.getGraphics();}
	public JFrame getFrame(){return this.frame;}
	//	drawzone.setLocation(drawzone.zoneoff,0);
}
