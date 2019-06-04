package model;

import java.util.ArrayList;

public class Bulletin 
{
	private int id;
	private Trimestre t;
	private Inscription i;
	private String appreciation;
	private ArrayList<Detailbulletin>tabDetail;
	
	
	public Bulletin(int id,Trimestre t,Inscription i,String appreciation)
	{
		this.id=id;
		this.t=t;
		this.i=i;
		this.appreciation=appreciation;
		tabDetail=new ArrayList<Detailbulletin>();
	}
	
	
	public Bulletin() {
		// TODO Auto-generated constructor stub
	}


	public int getId()
	{
		return id;
	}
	
	public Trimestre getTrimestre()
	{
		return t;
	}
	
	public Inscription getInscription()
	{
		return i;
	}
	
	
	public String getAppreciation()
	{
		return appreciation;
	}
	
	public void AjouterDetail(Detailbulletin d)
	{
		tabDetail.add(d);
	}
	
	
	public double moyenneGeneral()
	{
		double somme=0;
		double moyenne=0;
		
		for(int i=0;i<tabDetail.size();i++)
		{
			somme=tabDetail.get(i).moyenneDiscipline()+somme;
		}
		moyenne=somme/tabDetail.size();
		return moyenne;
	}
	
	
}
