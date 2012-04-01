package fr.legbt.binge.graphics;

public class BackgroundsStruct {
	private int[] tilenbs;
	private int[] bgyoff;

	public BackgroundsStruct(int[] tilenbs,int[] bgyoff){
		this.tilenbs = tilenbs;
		this.bgyoff = new int[tilenbs.length];
		this.bgyoff = bgyoff;
	}

	public BackgroundsStruct(int[] tilenbs){
		this.tilenbs = tilenbs;
		this.bgyoff = new int[tilenbs.length];
	}

	public BackgroundsStruct(){
		this.tilenbs = null;
	}

	/**
	 * Gets the tilenbs for this instance.
	 *
	 * @return The tilenbs.
	 */
	public int[] getTilenbs()
	{
		return this.tilenbs;
	}

	/**
	 * Gets the number of tiles for background index for this instance.
	 *
	 * @param index The index to get.
	 * @return The tilenbs.
	 */
	public int getTilenbs(int index)
	{
		return this.tilenbs[index];
	}


	/**
	 * Gets the bgyoff for this instance.
	 *
	 * @return The bgyoff.
	 */
	public int[] getBgyoff()
	{
		return this.bgyoff;
	}

	/**
	 * Gets the bgyoff for this instance.
	 *
	 * @param index The index to get.
	 * @return The bgyoff.
	 */
	public int getBgyoff(int index)
	{
		return this.bgyoff[index];
	}

	/**
	 * Gets the number of backgrounds for this instance.
	 *
	 * @param index The index to get.
	 * @return The number of backgrounds.
	 */
	public int getBGLvl()
	{
		return this.tilenbs.length;
	}

}
