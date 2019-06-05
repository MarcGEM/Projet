package model;

public class Evaluation 
{
	private int id;
	private Detailbulletin d;
	private int note;
	private String appreciation;
	
	
	public Evaluation(int id,Detailbulletin d,int note, String appreciation)
	{
		this.id=id;
		this.d=d;
		this.note=note;
		this.appreciation=appreciation;
		d.AjouterEvaluation(this);
	}
	
	
	public Evaluation() {
		// TODO Auto-generated constructor stub
	}


	public int getId()
	{
		return id;
	}
	
	public Detailbulletin getDetailbulletin()
	{
		return d;
	}
	
	
	
	public int getNote()
	{
		return note;
	}
	
	public String getAppreciation()
	{
		return appreciation;
	}
	
	public void setAppreciation(String appreciation)
	{
		this.appreciation=appreciation;
	}
	

}
