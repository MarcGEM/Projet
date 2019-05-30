package model;

public class Trimestre 
{
	private Anneescolaire a;
	private int id;
	private int numero;
	private String debut;
	private String fin;
	
	public Trimestre(int id,int numero,String debut,String fin,Anneescolaire a)
	{
		this.id=id;
		this.numero=numero;
		this.debut=debut;
		this.fin=fin;
		this.a=a;
	}
	
	
	public Anneescolaire getAnneescolaire()
	{
		return a;
	}
	
	
	
	public int getId()
	{
		return id;
	}
	
	public String getDebut()
	{
		return debut;
	}
	
	public String getFin()
	{
		return fin;
	}
	
	
	public int getNumero()
	{
		return numero;
	}

}
