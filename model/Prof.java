package model;

public class Prof 
{
	private int id;
	private String nom;
	private String prenom;
	
	
	public Prof(int id,String nom,String prenom)
	{
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
	}
	
	
	
	public Prof() {
		// TODO Auto-generated constructor stub
	}



	public int getId()
	{
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
		// TODO Auto-generated method stub
		this.nom=nom;
		
	}
	
	
	public void setPrenom(String prenom)
	{
		this.prenom=prenom;
	}
	

}