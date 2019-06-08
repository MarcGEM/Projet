package model;

public class Discipline 
{
	int id;
	String nom;
	
	
	public Discipline(int id,String nom)
	{
		this.id=id;
		this.nom=nom;
	}
	
	
	public Discipline() {
		// TODO Auto-generated constructor stub
	}


	public  int getId()
	{
		return id;
	}
	
	public String getNom()
	{
		return nom;
	}


	public void setNom(String nom) 
	{
		this.nom=nom;
		
	}
	
	
	
}
