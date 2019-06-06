package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Classe 
{
	
	private Set<Prof>listprof=new HashSet<Prof>();
	private Set<Eleve>listeleve=new HashSet<Eleve>();
	
	private String nom;
	private Niveau n;
	private int id;
	private Anneescolaire a;
	
	public Classe(int id,String nom, Niveau n,Anneescolaire a)
	{
		this.id=id;
		this.nom=nom;
		this.n=n;
		this.a=a;
	}
	
	
	
	public Classe() 
	{
		// TODO Auto-generated constructor stub
	}


	public Set getListprof()
	{
		return listprof;
	}
	
	public Set getListeleve()
	{
		return listeleve;
	}
	
	public Niveau getNiveau()
	{
		return n;
	}
	
	
	public Anneescolaire getAnneescolaire()
	{
		return a;
	}
	
	
	public void ajouterProf(Prof p)
	{
		if(!listprof.contains(p))
		{
			listprof.add(p);
		}
		
	}
	
	public void ajouterEleve(Eleve e)
	{
		if(!listeleve.contains(e))
		{
			listeleve.add(e);
		}
		
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void supprimerProf(Prof p)
	{
		this.listprof.remove(p);
	}
	
	public void supprimerEleve(Eleve e)
	{
		this.listeleve.remove(e);
	}
	
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	
	public void setNiveau(Niveau n)
	{
		this.n=n;
	}
	
	public void setAnneescolaire(Anneescolaire a)
	{
		this.a=a;
	}
	
	
	
}
