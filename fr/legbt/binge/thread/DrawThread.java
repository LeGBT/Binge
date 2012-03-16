package fr.legbt.binge.thread;

import fr.legbt.binge.*;
import fr.legbt.binge.graphics.*;

public class DrawThread implements Runnable{
	private BingePanel bpanel; 
	private int framerate;
	private Binge game;

	public DrawThread(Binge game,String name, int width, int height, int framerate){
		this.bpanel = new BingePanel(this,name,width,height);
		this.framerate = framerate;
		this.game = game;
	}

	public void run(){  
		this.bpanel.getFrame().repaint();
		try{
		Thread.sleep(20);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public BingePanel getPanel(){return this.bpanel;}
	public void traceThemAll(){game.traceThemAll();}

}
