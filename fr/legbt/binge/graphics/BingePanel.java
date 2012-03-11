package fr.legbt.binge.graphics;

import java.awt.*;
import javax.swing.*;
import fr.legbt.binge.Binge;

public class BingePanel extends JPanel{
	private static final long serialVersionUID = 3l; //serialisation warnings
	private Rectangle screen, bounds;
	private JFrame frame;
	private DrawZone drawzone;
	Binge game;

	public BingePanel(Binge game,String name, int width, int height){
		super();
		this.setLayout(null);
		this.game = game;
		this.screen = new Rectangle(0,0,width,height);
		this.bounds = new Rectangle(0,0,width,height);
		this.drawzone = new DrawZone(this,width,height);
		this.add(drawzone);
		drawzone.setSize(width,height);
		this.frame = new JFrame(name);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setFocusable(true);
		this.frame.setSize(width,height);
		this.frame.setContentPane(this);
		this.frame.setVisible(true);
	}

	public boolean isOpaque(){
		return true;
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
	}
	public DrawZone getDZ(){
		return this.drawzone;
	}
	public JFrame getFrame(){
		return this.frame;
	}
	//	drawzone.setLocation(drawzone.zoneoff,0);
}
