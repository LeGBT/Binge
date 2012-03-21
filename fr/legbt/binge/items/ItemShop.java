package fr.legbt.binge.items;

import fr.legbt.binge.Binge;


public class ItemShop {


	public Item createItem(Binge game,DataItem data, int line, int column){
		try{
			ItemFactory factory = game.getFactory();
			java.lang.reflect.Method meth =	factory.getClass().getMethod("create"+data.getNameType(),Binge.class,DataItem.class,int.class,int.class);
			Item item = (Item) meth.invoke(factory,game,data,line,column);
			item.setGame(game);
			return item;
		}catch(Exception e){
			//System.out.println(e);
			e.printStackTrace();
		}
	//	System.out.println("oups ! ");
		return null;
	}





}
