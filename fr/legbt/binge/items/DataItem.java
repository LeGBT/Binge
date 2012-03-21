package fr.legbt.binge.items;


import java.io.Serializable;



public class DataItem implements Serializable {
	private static final long serialVersionUID = 0l;
	private String nametype;
	private int groupid;
	private int lookid;
	private int res;

	protected DataItem(String nametype, int groupid, int lookid, int res){
		this.nametype = nametype;
		this.groupid = groupid;
		this.lookid = lookid;
		this.res = res;
	}
	protected DataItem(String nametype){
		System.out.println(nametype);
		this.nametype = nametype;
		this.groupid = 0;
		this.lookid = 0;
		this.res = 80;
	}
	public DataItem(){
		System.out.println("Warning ! nametype not initialized !");
		this.nametype = "";
		this.groupid = 0;
		this.lookid = 0;
		this.res = 0;
	}


	/**
	 * Gets the nametype for this instance.
	 *
	 * @return The nametype.
	 */
	public String getNameType()
	{
		return this.nametype;
	}

	/**
	 * Gets the groupid for this instance.
	 *
	 * @return The groupid.
	 */
	public int getGroupID()
	{
		return this.groupid;
	}

	/**
	 * Gets the lookid for this instance.
	 *
	 * @return The lookid.
	 */
	public int getLookID()
	{
		return this.lookid;
	}
	/**
	 * Gets the res for this instance.
	 *
	 * @return The res.
	 */
	public int getRes()
	{
		return this.res;
	}
	/**
	 * Sets the res for this instance.
	 *
	 * @param res The res.
	 */
	public void setRes(int res)
	{
		this.res = res;
	}


}
