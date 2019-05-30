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
	
	
	public  int getId()
	{
		return id;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	
	
}
