package controleur;

import java.sql.*;

import model.*;

public class ClasseDAO extends DAO<Classe>
{

	public ClasseDAO(Connexion m_con) {
		super(m_con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Classe obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO classe (id,nom,niveau_id,anneescolaire_id) VALUES ('"+obj.getId()+"','"+obj.getNom()+"','"+obj.getNiveau().getId()+"','"+obj.getAnneescolaire().getId()+"')");
			System.out.println("Classe create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Classe obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM classe Where id="+obj.getId());
			System.out.println("Classe delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Classe obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE classe SET nom='"+obj.getNom()+"', niveau_id='"+obj.getNiveau().getId()+"', anneescolaire_id='"+obj.getAnneescolaire().getId()+"' WHERE id="+obj.getId()+"");
			System.out.println("classe update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Classe find(int id) 
	{
		
		return null;
	}

	@Override
	public void seeAll() 
	{
		// TODO Auto-generated method stub
		
	}
	
}