package fr.legbt.binge.graphics;

import java.awt.*;
import javax.swing.*;

public class UI extends JComponent{
	private static final long serialVersionUID = 0l; 
		private BingePanel bpanel;
	//	private Rectangle screen; //bounds;


	public UI(BingePanel bpanel, int width, int height){
				this.bpanel = bpanel;
		//		this.screen = new Rectangle(0,0,width,height);
		this.setDoubleBuffered(true);
	}

	public void paintComponent(Graphics g){
				this.bpanel.getDT().traceUI(g);
	}
}
