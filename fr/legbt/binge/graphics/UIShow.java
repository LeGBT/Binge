package fr.legbt.binge.graphics;

import java.awt.*;
import javax.swing.*;

public class UIShow extends JComponent{
	private static final long serialVersionUID = 0l; 
	private BingePanel bpanel;
	private Rectangle bounds;


	public UIShow(BingePanel bpanel, int width, int height){
		this.bpanel = bpanel;
		this.bounds = new Rectangle(0,0,0,0);
		this.setDoubleBuffered(true);
	}

	public Rectangle getRect(){
		return bounds;
	}

	public void addRect(Rectangle rect){
		this.bounds = bounds.union(rect);
	}

	public void paintComponent(Graphics g){
		this.bpanel.getDT().traceUI(g);
	}
}
