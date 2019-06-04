package controleur;

import java.sql.*;

import model.*;

public class DisciplineDAO extends DAO<Discipline>
{

	public DisciplineDAO(Connexion m_con) {
		super(m_con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Discipline obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO discipline (id,nom) VALUES ('"+obj.getId()+"','"+obj.getNom()+"')");
			System.out.println("Discipline create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Discipline obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM discipline Where id="+obj.getId());
			System.out.println("Discipline delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Discipline obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE discipline SET nom='"+obj.getNom()+"' WHERE id="+obj.getId()+"");
			System.out.println("Discipline update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Discipline find(int id) 
	{
		
		Discipline a=new Discipline();
		String query="SELECT * FROM discipline where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 a=new Discipline(con.rset.getInt("id"),con.rset.getString("nom"));
				
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