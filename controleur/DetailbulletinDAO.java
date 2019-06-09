package controleur;

import java.sql.*;
import java.util.ArrayList;

import model.*;

public class DetailbulletinDAO extends DAO<Detailbulletin>
{
	BulletinDAO bulletin;
	EnseignementDAO enseignement;
	ArrayList<Detailbulletin> tabBulletin;
	ArrayList<Evaluation>tabEvaluation;

	public DetailbulletinDAO(Connexion m_con) 
	{
		super(m_con);
		bulletin=new BulletinDAO(con);
		enseignement=new EnseignementDAO(con);
		tabBulletin=new ArrayList<Detailbulletin>();
		tabEvaluation=new ArrayList<Evaluation>();
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void create(Detailbulletin obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO detailbulletin (id,bulletin_id,enseignement_id,appreciation) VALUES ('"+obj.getId()+"','"+obj.getBulletin().getId()+"','"+obj.getEnseignement().getId()+"','"+obj.getAppreciation()+"')");
			System.out.println("Detailbulletin create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Detailbulletin obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM detailbulletin Where id="+obj.getId());
			System.out.println("Detailbulletin delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Detailbulletin obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE detailbulletin SET bulletin_id='"+obj.getBulletin().getId()+"', enseignement_id='"+obj.getEnseignement().getId()+"', appreciation='"+obj.getAppreciation()+"' WHERE id="+obj.getId()+"");
			System.out.println("Detailbulletin update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Detailbulletin find(int id) 
	{
		Detailbulletin a=new Detailbulletin();
		DAO<Bulletin>BulletinDao=new BulletinDAO(con);
		DAO<Enseignement>EnseignementDao=new EnseignementDAO(con);
		
		String query="SELECT * FROM detailbulletin where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int idt=con.rset.getInt("id");
				 int idtr=con.rset.getInt("bulletin_id");
				 int idi=con.rset.getInt("enseignement_id");
				 String appreciation=con.rset.getString("appreciation");
				 
				 a=new Detailbulletin(idt,BulletinDao.find(idtr),EnseignementDao.find(idi),appreciation);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public ArrayList seeAll() 
	{
		Detailbulletin b=new Detailbulletin();
		String query="SELECT * FROM detailbulletin";
		try {
			con.rset1=con.stmt1.executeQuery(query);
			while(con.rset1.next())
			{
				int id=con.rset1.getInt("id");
				int idbulletin=con.rset1.getInt("bulletin_id");
				int idenseignement=con.rset1.getInt("enseignement_id");
				String appreciation=con.rset1.getString("appreciation");
				b=new Detailbulletin(id,bulletin.find(idbulletin),enseignement.find(idenseignement),appreciation);
				
				tabBulletin.add(b);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabBulletin;
		
	}
	
	public ArrayList evaAll(int id) 
	{
		Evaluation b=new Evaluation();
		String query="SELECT * FROM evaluation WHERE detailbulletin_id="+id;
		try {
			con.rset1=con.stmt1.executeQuery(query);
			while(con.rset1.next())
			{
				int ide=con.rset1.getInt("id");
				int idenseignement=con.rset1.getInt("note");
				String appreciation=con.rset1.getString("appreciation");
				b=new Evaluation(id,find(id),idenseignement,appreciation);
				
				tabEvaluation.add(b);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabEvaluation;
		
	}
	
	public double moyenneDiscipline(int id)
	{
		double somme=0;
		double moyenne=0;
		
		ArrayList<Evaluation> tab=evaAll(id);
		
		
		for(int i=0;i<tab.size();i++)
		{
			somme=tab.get(i).getNote()+somme;
		}
		moyenne=somme/tab.size();
		return moyenne;
	}
	

	

	

}