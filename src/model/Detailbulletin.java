package model;

public class Detailbulletin 
{
	private int id;
	private Bulletin b;
	private Enseignement ens;
	private String appreciation;
	
	
	public Detailbulletin(int id,Bulletin b,Enseignement ens,String appreciation)
	{
		this.id=id;
		this.b=b;
		this.ens=ens;
		this.appreciation=appreciation;
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public Bulletin getBulletin()
	{
		return b;
	}
	
	public Enseignement getEnseignement()
	{
		return ens;
	}
	
	
	public String getAppreciation()
	{
		return appreciation;
	}
	
	
	
}
