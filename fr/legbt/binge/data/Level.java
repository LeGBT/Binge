package fr.legbt.binge.data;

import fr.legbt.binge.items.*;

public class Level implements LevelModel{
	private int lwidth;
	private int lheight;
	private int[][] lvl;
	private Item[] items;

	public Level(int lw, int lh){
		this.lwidth = lw;
		this.lheight = lh;
		this.lvl = new int[lw][lh]; 
		this.items = null;
	}

	public int[] getLine(int aline){
		if (aline>this.lheight){
			return null;
		}
		return lvl[aline];
	}

	public void setLine(int aline,int[] line){
		lvl[aline] = line;
	}

	public int getTile(int aline, int acolumn){
		return 0;	
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
