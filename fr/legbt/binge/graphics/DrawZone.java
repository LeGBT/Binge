package fr.legbt.binge.graphics;

import java.awt.*;
import javax.swing.*;


public class DrawZone extends JComponent{
	private static final long serialVersionUID = 4l;
	private BingePanel bpanel;

	public	DrawZone(BingePanel bpanel,int width, int height){
		this.bpanel = bpanel;
		this.setDoubleBuffered(true);
	}

	void moveZone(){
		//	if (zoneoff > screen.width-800){this.way = -10;} 
		//	if (zoneoff < -200){this.way = 10;} 
		//	this.zoneoff += way;
	}


	protected void paintComponent(Graphics g){
		//System.out.println(this.bounds.getHeight() + " et w : " + bounds.getWidth());
		super.paintComponent(g);
		this.bpanel.getDT().traceItems(g);
	}
}
