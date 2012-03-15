package fr.legbt.binge.graphics;

import java.awt.*;
import javax.swing.*;

class DrawZone extends JComponent{
	private static final long serialVersionUID = 3l; //serialisation warnings
	private BingePanel bpanel;
	private Rectangle screen, bounds;

	DrawZone(BingePanel bpanel,int width, int height){
		this.bpanel = bpanel;
		this.screen = new Rectangle(0,0,width,height);
	}

	 void moveZone(){
		//	if (zoneoff > screen.width-800){this.way = -10;} 
		//	if (zoneoff < -200){this.way = 10;} 
		//	this.zoneoff += way;
	}

	 protected void paintComponent(Graphics g){
		this.bpanel.game.traceThemAll();
	}
}
