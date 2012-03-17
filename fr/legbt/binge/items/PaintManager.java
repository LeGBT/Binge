package fr.legbt.binge.items;

import java.awt.Graphics;

import fr.legbt.binge.Binge;
import fr.legbt.binge.ui.*;


public class PaintManager extends Manager {
	private Binge game;

	public PaintManager(Binge agame){
		super();
		this.game = agame;
	}

	public void traceThemAll(Graphics g){
		try{
			for(int i=0;i<movableitemlist.size();i++){
				MovableItem mitem = movableitemlist.get(i);
				mitem.traceMe(g);
			}
			for(int i=0;i<fixeditemlist.size();i++){
				FixedItem item = fixeditemlist.get(i);
				item.traceMe(g);
			}
			for(int i=0;i<staticinfolist.size();i++){
				StaticInfo sti = staticinfolist.get(i);
				sti.traceMe(g);
			}
		}catch(Exception e){
			System.out.println("paintmanager segfault ? " + e);
			e.printStackTrace();
		}
	}
}
