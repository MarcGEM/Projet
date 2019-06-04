package controleur;

import java.sql.*;

import model.*;

public class AnneescolaireDAO extends DAO<Anneescolaire>
{

	public AnneescolaireDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Anneescolaire obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO anneescolaire (id,annee) VALUES ('"+obj.getId()+"','"+obj.getAnnee()+"')");
			System.out.println("Annee scolaire create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Anneescolaire obj) 
	{
		try {
			con.stmt.executeUpdate( "DELETE FROM anneescolaire Where id="+obj.getId());
			System.out.println("Annee scolaire delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Anneescolaire obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE anneescolaire SET annee='"+obj.getAnnee()+"' WHERE id="+obj.getId()+"");
			System.out.println("Annee scolaire update");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Anneescolaire find(int id) 
	{
		Anneescolaire a=new Anneescolaire();
		String query="SELECT * FROM anneescolaire where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 a=new Anneescolaire(con.rset.getInt("id"),con.rset.getString("annee"));
				
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
