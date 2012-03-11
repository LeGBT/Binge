package fr.legbt.binge.data;

import java.io.Serializable;
import fr.legbt.binge.items.*;
import fr.legbt.binge.*;
import java.util.ArrayList;

public class Level implements LevelModel, Serializable{
	private int lwidth;
	private int lheight;
	private int[][] lvl;
	public ArrayList<Item> itemlist;

	protected void setLvl(int[][] lvl){
		this.lvl = lvl;
	}

	public ArrayList<Item> getItemList(){return itemlist;}
	public void addItem(Item item){itemlist.add(item);}

	public void printItemListNFO(){
		for(int i=0; i<itemlist.size() ;i++){
			itemlist.get(i).printNFO();
		}
	}

	public Level(int lw, int lh){
		this.lwidth = lw;
		this.lheight = lh;
		this.lvl = new int[lw][lh]; 
		this.itemlist = new ArrayList<Item>();
	}

	public int[] getLine(int aline){
		if (aline>this.lheight){
			System.out.println("arg trop gros");
			return null;
		}
		int[] theline = new int[this.lwidth];
		for (int i=0; i<this.lwidth; i++){
			theline[i] = lvl[i][aline];
		}
		return theline;
	}

	public void setLine(int aline,int[] line){
		for (int j=0; j<this.lwidth; j++){
			lvl[j][aline] = line[j];
		}
	}

	public int getTile(int acolumn, int aline){
		return this.getLine(aline)[acolumn];	
	}

	public void setTile(int aline,int acolumn, int tile){
		this.lvl[lwidth][lheight] = tile;
	}

	public int getW(){return this.lwidth;}
	public int getH(){return this.lheight;}

	public static Level loadLvl(String lvlfile,Binge game){
		Level alvl = null;
		try{
			alvl =  IOManager.readLevel(lvlfile);
		} catch(Exception e){
			System.out.println(" binge segfault :" + e);
			e.printStackTrace();
		}
		for(int i=0; i<alvl.itemlist.size(); i++){
			alvl.itemlist.get(i).setGame(game);
			alvl.itemlist.get(i).setID(i);
			alvl.itemlist.get(i).onLoaded(game);
		}
		return alvl;
	}
}
