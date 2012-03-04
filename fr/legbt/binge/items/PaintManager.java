package fr.legbt.binge.items;

import java.util.ArrayList;
import fr.legbt.binge.Binge;

public class PaintManager {
	private ArrayList<Item> itemlist;
	private ArrayList<FixedItem> fixeditemlist;
	private Binge game;

	public PaintManager(Binge agame){
		itemlist = new ArrayList<Item>();
		fixeditemlist = new ArrayList<FixedItem>();
		game = agame;
	}

	public void traceThemAll(){
		try{
			for(int i=0;i<itemlist.size();i++){
				Item item = itemlist.get(i);
				item.traceMe(game.getGraphics());
			}

		}catch(Exception e){
			System.out.println("paintmanager segfault ? " + e);
		}
	}

	public void register(Item item){
		this.itemlist.add(item);
	}
	public void register(FixedItem fixeditem){
		this.fixeditemlist.add(fixeditem);
	}
	public void clearMe(){
		itemlist.clear();
		fixeditemlist.clear();
	}
}
