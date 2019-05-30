package controleur;

import java.sql.*;

import model.*;

public class TrimestreDAO extends DAO<Trimestre>
{

	public TrimestreDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void create(Trimestre obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO trimestre (id,numero,debut,fin,anneescolaire_id) VALUES ('"+obj.getId()+"','"+obj.getNumero()+"','"+obj.getDebut()+"','"+obj.getFin()+"','"+obj.getAnneescolaire().getId()+"')");
			System.out.println("Trimestre create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Trimestre obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM Trimestre Where id="+obj.getId());
			System.out.println("Trimestre delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Trimestre obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE Trimestre SET numero='"+obj.getNumero()+"', debut='"+obj.getDebut()+"', fin='"+obj.getFin()+"', anneescolaire_id='"+obj.getAnneescolaire().getId()+"' WHERE id="+obj.getId()+"");
			System.out.println("Trimestre update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Trimestre find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seeAll() {
		// TODO Auto-generated method stub
		
	}

	

	

}
