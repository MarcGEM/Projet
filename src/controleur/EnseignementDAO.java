package controleur;

import java.sql.*;

import model.*;

public class EnseignementDAO extends DAO<Enseignement>
{

	public EnseignementDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void create(Enseignement obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO enseignement (id,classe_id,discipline_id,prof_id) VALUES ('"+obj.getId()+"','"+obj.getClasse().getId()+"','"+obj.getDiscipline().getId()+"','"+obj.getProf().getId()+"')");
			System.out.println("Enseignement create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Enseignement obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM enseignement Where id="+obj.getId());
			System.out.println("Enseignement delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Enseignement obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE enseignement SET classe_id='"+obj.getClasse().getId()+"', discipline_id='"+obj.getDiscipline().getId()+"', prof_id='"+obj.getProf().getId()+"' WHERE id="+obj.getId()+"");
			System.out.println("Enseignement update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Enseignement find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seeAll() {
		// TODO Auto-generated method stub
		
	}

	

	

}
