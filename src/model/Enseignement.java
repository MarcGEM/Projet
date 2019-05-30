package model;

public class Enseignement 
{
	private int id;
	private Classe c;
	private Prof p;
	private Discipline d;
	
	
	public Enseignement(int id,Classe c,Prof p,Discipline d)
	{
		this.id=id;
		this.c=c;
		this.p=p;
		this.d=d;
		c.ajouterProf(p);
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public Classe getClasse()
	{
		return c;
	}
	
	public Prof getProf()
	{
		return p;
	}
	
	public Discipline getDiscipline()
	{
		return d;
	}
	
	
	public void changerProf(Prof p)
	{
		c.supprimerProf(this.p);
		c.ajouterProf(p);
		this.p=p;
		
	}
	
	public void changerClasse(Classe c) 
	{
		this.c=c;
	}
	public void changerDiscipline(Discipline d)
	{
		this.d=d;
	}
	
}
