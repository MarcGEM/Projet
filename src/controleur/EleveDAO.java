package controleur;

import java.sql.*;

import model.*;

public class EleveDAO extends DAO<Eleve>
{

	public EleveDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Eleve obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO eleve (id,nom,prenom) VALUES ('"+obj.getId()+"','"+obj.getNom()+"','"+obj.getPrenom()+"')");
			System.out.println("Eleve create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Eleve obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM eleve Where id="+obj.getId());
			System.out.println("Eleve delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Eleve obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE eleve SET nom='"+obj.getNom()+"', prenom='"+obj.getPrenom()+"' WHERE id="+obj.getId()+"");
			System.out.println("Eleve update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Eleve find(int id) 
	{
		Eleve a=new Eleve();
		String query="SELECT * FROM eleve where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 a=new Eleve(con.rset.getInt("id"),con.rset.getString("nom"),con.rset.getString("prenom"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void seeAll() {
		// TODO Auto-generated method stub
		
	}
	
	
	

	

		
}
