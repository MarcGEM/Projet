package model;

public class Anneescolaire 
{
	
	private int id;
	private String annee;
	
	public Anneescolaire(int id,String annee)
	{
		this.id=id;
		this.annee=annee;
	}
	
	
	


	public Anneescolaire() {
		// TODO Auto-generated constructor stub
	}


	public int getId()
	{
		return id;
	}
	
	public String getAnnee()
	{
		return annee;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setAnnee(String annee)
	{
		this.annee=annee;
	}
	
}
