package controleur;

import java.sql.*;

import model.*;

public class ProfDAO extends DAO<Prof>
{

	public ProfDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Prof obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO prof (id,nom,prenom) VALUES ('"+obj.getId()+"','"+obj.getNom()+",'"+obj.getPrenom()+"')");
			System.out.println("Prof create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Prof obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM prof Where id="+obj.getId());
			System.out.println("Prof delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Prof obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE prof SET nom='"+obj.getNom()+"', prenom='"+obj.getPrenom()+"' WHERE id="+obj.getId()+"");
			System.out.println("Prof update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Prof find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seeAll() {
		// TODO Auto-generated method stub
		
	}
	
	
	

	

		
}