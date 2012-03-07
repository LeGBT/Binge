package fr.legbt.binge.items;

import java.util.ArrayList;

public class ActionsManager extends Manager {

	public ActionsManager(){
		super();
	}

	public void actionThemAll(){
		try{
			for(int i=0;i<itemlist.size();i++){
				Item item = itemlist.get(i);
				item.action();
			}

		}catch(Exception e){
			System.out.println("ActionManager segfault ? " + e);
		}
	}
}
