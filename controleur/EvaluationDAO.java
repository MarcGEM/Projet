package controleur;

import java.sql.*;
import java.util.ArrayList;

import model.*;

public class EvaluationDAO extends DAO<Evaluation>
{
	DetailbulletinDAO detailbulletin;
	ArrayList<Evaluation>TabEvaluation;

	public EvaluationDAO(Connexion m_con) 
	{
		super(m_con);
		detailbulletin=new DetailbulletinDAO(con);
		TabEvaluation=new ArrayList<Evaluation>();
	}
	
	@Override
	public void create(Evaluation obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO evaluation (id,detailbulletin_id,note,appreciation) VALUES ('"+obj.getId()+"','"+obj.getDetailbulletin().getId()+"','"+obj.getNote()+"','"+obj.getAppreciation()+"')");
			System.out.println("Evaluation create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Evaluation obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM evaluation Where id="+obj.getId());
			System.out.println("Evaluation delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Evaluation obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE evaluation SET detailbulletin_id='"+obj.getDetailbulletin().getId()+"', note='"+obj.getNote()+"', appreciation='"+obj.getAppreciation()+"' WHERE id="+obj.getId()+"");
			System.out.println("Evaluation update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Evaluation find(int id) 
	{
		Evaluation a=new Evaluation();
		
		DAO<Detailbulletin>DetailDao=new DetailbulletinDAO(con);
		
		String query="SELECT * FROM evaluation where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int idt=con.rset.getInt("id");
				 int idtr=con.rset.getInt("detailbulletin_id");
				 int note=con.rset.getInt("note");
				 String appreciation=con.rset.getString("appreciation");
				 
				 a=new Evaluation(idt,DetailDao.find(idtr),note,appreciation);
				
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
		Evaluation b=new Evaluation();
		String query="SELECT * FROM evaluation";
		try {
			con.rset1=con.stmt1.executeQuery(query);
			while(con.rset1.next())
			{
				int id=con.rset1.getInt("id");
				int iddetail=con.rset1.getInt("detailbulletin_id");
				int note=con.rset1.getInt("note");
				String appreciation=con.rset1.getString("appreciation");
				b=new Evaluation(id,detailbulletin.find(iddetail),note,appreciation);
				
				TabEvaluation.add(b);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TabEvaluation;
	}
	
	public ResultSet Ro() 
	{
		
		String query="SELECT * FROM  evaluation";
		
		try {
			con.rset=con.stmt.executeQuery(query);
			ResultSet rs=con.rset;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  con.rset ;
		
		
	}

	

	

}