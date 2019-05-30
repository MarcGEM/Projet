package controleur;

import java.sql.*;

import model.*;

public class EvaluationDAO extends DAO<Evaluation>
{

	public EvaluationDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
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
	public Evaluation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seeAll() {
		// TODO Auto-generated method stub
		
	}

	

	

}