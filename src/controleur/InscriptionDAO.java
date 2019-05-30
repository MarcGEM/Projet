package controleur;

import java.sql.*;

import model.*;

public class InscriptionDAO extends DAO<Inscription>
{

	public InscriptionDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void create(Inscription obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO inscription (id,classe_id,eleve_id) VALUES ('"+obj.getId()+"','"+obj.getClasse().getId()+"','"+obj.getEleve().getId()+"')");
			System.out.println("Inscription create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Inscription obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM inscription Where id="+obj.getId());
			System.out.println("Inscription delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Inscription obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE inscription SET classe_id='"+obj.getClasse().getId()+"', prof_id='"+obj.getEleve().getId()+"' WHERE id="+obj.getId()+"");
			System.out.println("Inscription update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Inscription find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seeAll() {
		// TODO Auto-generated method stub
		
	}

	

	

}
