package controleur;

import java.sql.*;

import model.*;

public class BulletinDAO extends DAO<Bulletin>
{

	public BulletinDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void create(Bulletin obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO bulletin (id,trimestre_id,inscription_id,appreciation) VALUES ('"+obj.getId()+"','"+obj.getTrimestre().getId()+"','"+obj.getInscription().getId()+"','"+obj.getAppreciation()+"')");
			System.out.println("Bulletin create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Bulletin obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM Bulletin Where id="+obj.getId());
			System.out.println("Bulletin delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Bulletin obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE Bulletin SET trimestre_id='"+obj.getTrimestre().getId()+"', discipline_id='"+obj.getInscription().getId()+"', appreciation='"+obj.getAppreciation()+"' WHERE id="+obj.getId()+"");
			System.out.println("Bulletin update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Bulletin find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seeAll() {
		// TODO Auto-generated method stub
		
	}

	

	

}