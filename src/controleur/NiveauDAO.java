package controleur;

import java.sql.*;

import model.*;

public class NiveauDAO extends DAO<Niveau>
{

	public NiveauDAO(Connexion m_con) {
		super(m_con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Niveau obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO niveau (id,nom) VALUES ('"+obj.getId()+"','"+obj.getNom()+"')");
			System.out.println("Niveau create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Niveau obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM niveau Where id="+obj.getId());
			System.out.println("Niveau delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Niveau obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE niveau SET nom='"+obj.getNom()+"' WHERE id="+obj.getId()+"");
			System.out.println("Niveau update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Niveau find(int id) 
	{
		
		Niveau a=new Niveau();
		String query="SELECT * FROM niveau where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 a=new Niveau(con.rset.getInt("id"),con.rset.getString("nom"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void seeAll() 
	{
		// TODO Auto-generated method stub
		
	}

	

	

	

}
