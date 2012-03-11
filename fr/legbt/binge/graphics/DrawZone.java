package fr.legbt.binge.graphics;

import java.awt.*;
import javax.swing.*;

public class DrawZone extends JComponent{
	private static final long serialVersionUID = 3l; //serialisation warnings
	private BingePanel bpanel;
	private Rectangle screen, bounds;
	//	public int zoneoff;
	//	public int way;

	public DrawZone(BingePanel bpanel,int width, int height){
		//	this.zoneoff = 0;
		//	this.way = 10;
		this.bpanel = bpanel;
		this.screen = new Rectangle(0,0,width,height);
		//this.bounds = new Rectangle(0,0,width,height);
	}

	public void moveZone(){
		//	if (zoneoff > screen.width-800){this.way = -10;} 
		//	if (zoneoff < -200){this.way = 10;} 
		//	this.zoneoff += way;
	}

	public void paintComponent(Graphics g){
	//	this.bounds = g.getClipBounds();
		g.clearRect(screen.x,screen.y,screen.width,screen.height);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		this.bpanel.game.paintmanager.traceThemAll();
	}
}
