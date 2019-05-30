package model;

public class Bulletin 
{
	private int id;
	private Trimestre t;
	private Inscription i;
	private String appreciation;
	
	
	public Bulletin(int id,Trimestre t,Inscription i,String appreciation)
	{
		this.id=id;
		this.t=t;
		this.i=i;
		this.appreciation=appreciation;
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public Trimestre getTrimestre()
	{
		return t;
	}
	
	public Inscription getInscription()
	{
		return i;
	}
	
	
	public String getAppreciation()
	{
		return appreciation;
	}
	
}
