package fr.legbt.binge.data;

import java.io.Serializable;
import fr.legbt.binge.items.*;
import java.util.ArrayList;

public class Level implements LevelModel, Serializable{
	private int lwidth;
	private int lheight;
	private int[][] lvl;
	private ArrayList<Item> itemlist;

	protected void setLvl(int[][] lvl){
		this.lvl = lvl;
	}

	public ArrayList<Item> getItemList(){
		return itemlist;
	}

	public void addItem(Item item){
		itemlist.add(item);
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

	public int getW(){
		return this.lwidth;
	}

	public int getH(){
		return this.lheight;
	}


}
