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


	public Eleve() {
		// TODO Auto-generated constructor stub
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


	public void setNom(String nom) 
	{
		this.nom=nom;
		
	}
	
	public void setPrenom(String prenom)
	{
		this.prenom=prenom;
	}
	
	

}
