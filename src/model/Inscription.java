package model;

public class Inscription 
{
	private int id;
	private Classe c;
	private Eleve e;
	
	
	public Inscription(int id,Classe c,Eleve e)
	{
		this.id=id;
		this.c=c;
		this.e=e;
		c.ajouterEleve(e);
	}
	
	public Inscription() {
		// TODO Auto-generated constructor stub
	}

	public int getId()
	{
		return id;
	}
	
	public Classe getClasse()
	{
		return c;
	}
	
	
	
	public Eleve getEleve()
	{
		return e;
	}
	
	
	public void changerEleve(Eleve e)
	{
		c.supprimerEleve(this.e);
		c.ajouterEleve(e);
		this.e=e;
		
	}
	
	public void changerClasse(Classe c) 
	{
		this.c=c;
	}
	
	
}
