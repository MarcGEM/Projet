package model;

public class Eleve 
{
	private int id;
	private String nom;
	private String prenom;
	
	
	public Eleve(int id,String nom,String prenom)
	{
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
	}


	public int getId() 
	{
		// TODO Auto-generated method stub
		return id;
	}
	
	
	public String getNom()
	{
		return nom;
	}
	
	public String getPrenom()
	{
		return prenom;
	}

}
