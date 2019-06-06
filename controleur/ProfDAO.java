package controleur;

import java.sql.*;

import model.*;

import java.util.ArrayList;

public class ProfDAO extends DAO<Prof>
{
	private ArrayList<Prof>tabProf;

	public ProfDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Prof obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO prof (id,nom,prenom) VALUES ('"+obj.getId()+"','"+obj.getNom()+"','"+obj.getPrenom()+"')");
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
	public Prof find(int id) 
	{
		Prof a=new Prof();
		String query="SELECT * FROM prof where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 a=new Prof(con.rset.getInt("id"),con.rset.getString("nom"),con.rset.getString("prenom"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public ArrayList seeAll() {
		// TODO Auto-generated method stub
	
		{
			Prof a=new Prof();
			String query="SELECT * FROM prof";
			
			try {
				con.rset=con.stmt.executeQuery(query);
				while(con.rset.next())
				{
					a=new Prof(con.rset.getInt("id"),con.rset.getString("nom"),con.rset.getString("prenom"));
					tabProf.add(a);
				}
				
			}catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tabProf;
			// TODO Auto-generated method stub
			
		}
	}
	}
		
	
	
	
	

	

		
