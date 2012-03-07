package fr.legbt.binge.items;

import java.util.ArrayList;

public class ActionsManager extends Manager {

	public ActionsManager(){
		super();
	}

	public void actionThemAll(){
		try{
			for(int i=0;i<movableitemlist.size();i++){
				MovableItem mitem = movableitemlist.get(i);
				mitem.action();
			}

		}catch(Exception e){
			System.out.println("ActionManager segfault ? " + e);
		}
	}
}
