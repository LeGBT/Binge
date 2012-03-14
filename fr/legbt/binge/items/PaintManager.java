package fr.legbt.binge.items;

import java.util.ArrayList;
import fr.legbt.binge.Binge;
import fr.legbt.binge.ui.*;

public class PaintManager extends Manager {
	private Binge game;

	public PaintManager(Binge agame){
		super();
		game = agame;
	}

	public void traceThemAll(){
		try{
			for(int i=0;i<movableitemlist.size();i++){
				MovableItem mitem = movableitemlist.get(i);
				mitem.traceMe(game);
			}
			for(int i=0;i<fixeditemlist.size();i++){
				FixedItem item = fixeditemlist.get(i);
				item.traceMe(game);
			}
			for(int i=0;i<staticinfolist.size();i++){
				StaticInfo sti = staticinfolist.get(i);
				sti.traceMe(game);
			}
		}catch(Exception e){
			System.out.println("paintmanager segfault ? " + e);
			e.printStackTrace();
		}
	}
}
