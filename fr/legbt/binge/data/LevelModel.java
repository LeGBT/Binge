package fr.legbt.binge.data;

public interface LevelModel {
	public int[] getLine(int aline);
	public void setLine(int aline,int[] line);
	public int getTile(int aline,int acolumn);
	public void setTile(int aline,int acolumn,int tile);
	public int getW();
	public int getH();
}
