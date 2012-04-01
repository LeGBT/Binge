package fr.legbt.binge.graphics;

import java.awt.*;
import javax.swing.*;
import fr.legbt.binge.thread.DrawThread;

/**
 * BingePanel is a class only use by Binge
 * Dont extend it.
 */
public class BingePanel extends JPanel{
	private static final long serialVersionUID = 3l; //serialisation warnings
	//	private Rectangle bounds;
	private JFrame frame;
	private DrawZone drawzone;
	private BGComp[] bgcomps;
	private UIShow ui;
	//Binge game;
	private DrawThread dt;


	public BingePanel(DrawThread dt,String name, int width, int height, BackgroundsStruct bg){
		super();
		this.setLayout(null);
		//this.game = game;
		this.dt = dt;
		//		this.screen = new Rectangle(0,0,width,height);
		//		this.bounds = new Rectangle(0,0,width,height);
		this.drawzone = new DrawZone(this,width,height);
		bgcomps = new BGComp[bg.getBGLvl()];
		for(int i=0;i<bgcomps.length;i++){
			this.bgcomps[i] = new BGComp(this,width*2,height,bg.getTilenbs(i),i,bg.getBgyoff()[i]);
		}
		this.ui = new UIShow(this,width,height);
		this.add(drawzone);
		for(int i=0;i<bgcomps.length;i++){
			this.add(bgcomps[bgcomps.length-1-i]);
		}
		this.add(ui);
		for(int i=0;i<bgcomps.length;i++){
			bgcomps[i].setSize(width*2,height);
		//	bgcomps[i].setOpaque(false);
		}
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
		super.paintComponent(g);
		//bgcomp.setLocation(bgcomp.getXshift(),0);
	}

	public boolean isOpaque(){return true;}
	//public Graphics getItemDrawZoneGraphics(){return this.drawzone.getGraphics();}
	//public Graphics getUIGraphics(){return this.ui.getGraphics();}
	public JFrame getFrame(){return this.frame;}
	public DrawZone getDrawZone(){return this.drawzone;}
	public BGComp[] getBGComps(){return this.bgcomps;}
	public UIShow getUIShow(){return this.ui;}
	//	drawzone.setLocation(drawzone.zoneoff,0);

	/**
	 * Gets the dt for this instance.
	 *
	 * @return The dt.
	 */
	public DrawThread getDT()
	{
		return this.dt;
	}
}
