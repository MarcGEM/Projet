package model;

import java.util.ArrayList;

public class Detailbulletin 
{
	private int id;
	private Bulletin b;
	private Enseignement ens;
	private String appreciation;
	private ArrayList<Evaluation>tabEval;
	private double moyenne;
	
	
	public Detailbulletin(int id,Bulletin b,Enseignement ens,String appreciation)
	{
		this.id=id;
		this.b=b;
		this.ens=ens;
		this.appreciation=appreciation;
		
		
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

	
	public ArrayList getTabEval()
	{
		return tabEval;
	}
	
	public double getMoyenne()
	{
		return moyenne;
	}
	
	public void setMoyenne(double moyenne)
	{
		this.moyenne=moyenne;
	}


	public void setAppreciation(String appreciation2) 
	{
		this.appreciation=appreciation2;
		
	}
	
	
}
