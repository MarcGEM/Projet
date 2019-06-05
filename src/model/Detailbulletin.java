package model;

import java.util.ArrayList;

public class Detailbulletin 
{
	private int id;
	private Bulletin b;
	private Enseignement ens;
	private String appreciation;
	private ArrayList<Evaluation>tabEval;
	
	
	public Detailbulletin(int id,Bulletin b,Enseignement ens,String appreciation)
	{
		this.id=id;
		this.b=b;
		this.ens=ens;
		this.appreciation=appreciation;
		tabEval=new ArrayList<Evaluation>();
		b.AjouterDetail(this);
		
	}
	
	
	public Detailbulletin() {
		// TODO Auto-generated constructor stub
	}


	public int getId()
	{
		return id;
	}
	
	public Bulletin getBulletin()
	{
		return b;
	}
	
	public Enseignement getEnseignement()
	{
		return ens;
	}
	
	
	public String getAppreciation()
	{
		return appreciation;
	}
	
	public void AjouterEvaluation(Evaluation e)
	{
		tabEval.add(e);
	}
	
	
	public double moyenneDiscipline()
	{
		double somme=0;
		double moyenne=0;
		
		for(int i=0;i<tabEval.size();i++)
		{
			somme=tabEval.get(i).getNote()+somme;
		}
		moyenne=somme/tabEval.size();
		return moyenne;
	}
	
	
	public ArrayList getTabEval()
	{
		return tabEval;
	}
	
	
	
}
