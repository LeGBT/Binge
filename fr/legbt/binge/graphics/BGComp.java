package fr.legbt.binge.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

import fr.legbt.binge.Binge;


public class BGComp extends JComponent{
	private static final long serialVersionUID = 0l;
	private BingePanel bpanel;
	private BufferedImage image;
	private int xshift;

	public BGComp(BingePanel bpanel, int width, int height, String imagename){
		this.bpanel = bpanel;
		this.xshift = 0;
		if(!imagename.equals("null")){
			image = Binge.getTexture(imagename);
		}else {image = null;}
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);	
		Graphics2D g2 = (Graphics2D) g;
		if(image != null){
			Rectangle2D tr = new Rectangle2D.Double(0, 0, image.getWidth(), image.getHeight());
			Rectangle2D r = new Rectangle2D.Double(0, 0, 5120, 720);
			TexturePaint tp = new TexturePaint(image, tr);
			g2.setPaint(tp);
			g2.fill(r);
		}
		this.xshift -=1;
	}

	public int getXShift(){
		return this.xshift;
	}


}
