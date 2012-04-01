package fr.legbt.binge.thread;

import fr.legbt.binge.*;
import fr.legbt.binge.graphics.*;
import javax.swing.*;

import java.awt.Graphics;
import java.util.List;


public class DrawThread extends SwingWorker<Void,Integer> {
	private BingePanel bpanel; 
	private int framerate;
	private Binge game;

	public DrawThread(Binge game,String name, int width, int height, int framerate, BackgroundsStruct bg){
		this.bpanel = new BingePanel(this,name,width,height,bg);
		this.framerate = framerate;
		this.game = game;
	}

	public Void doInBackground(){
		//	int framenb=0;
		while(true){
			try{
				//			System.out.println(framenb);
				//			framenb++;
				game.actionThemAll();
				game.testCollisions();
				//			publish(framenb);
				Thread.currentThread();
				this.bpanel.getDrawZone().repaint();
				this.bpanel.getUIShow().repaint(this.bpanel.getUIShow().getRect());
				// !!!!!!!!!!!!  tests !!!!!!!!!!!!!!
				//				this.bpanel.getBGComp().setXshift(this.bpanel.getBGComp().getXshift()-10);
				Thread.sleep(framerate);
			}catch(Exception e){
				System.out.println("interruption !");
				e.printStackTrace();
			}
		}
	}


	protected void process(List<Integer> ints){
		//		System.out.println("repaint ?");
		//game.traceThemAll();
		//	System.out.println(ints);
		//	this.bpanel.getFrame().repaint();
		//	this.bpanel.getFrame().validate();
	}

	//public void run(){  
	//	this.bpanel.getFrame().repaint();
	//	try{
	//		Thread.sleep(20);
	//	}catch(Exception e){
	//		e.printStackTrace();
	//	}
	//}

	public BingePanel getPanel(){return this.bpanel;}
	public void traceItems(Graphics g){game.traceItems(g);}
	public void traceUI(Graphics g){game.traceUI(g);}

}
