package controleur;

import java.sql.*;

import model.*;

public class DetailbulletinDAO extends DAO<Detailbulletin>
{

	public DetailbulletinDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void create(Detailbulletin obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO detailbulletin (id,bulletin_id,enseignement_id,appreciation) VALUES ('"+obj.getId()+"','"+obj.getBulletin().getId()+"','"+obj.getEnseignement().getId()+"','"+obj.getAppreciation()+"')");
			System.out.println("Detailbulletin create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Detailbulletin obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM detailbulletin Where id="+obj.getId());
			System.out.println("Detailbulletin delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Detailbulletin obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE detailbulletin SET bulletin_id='"+obj.getBulletin().getId()+"', enseignement_id='"+obj.getEnseignement().getId()+"', appreciation='"+obj.getAppreciation()+"' WHERE id="+obj.getId()+"");
			System.out.println("Detailbulletin update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Detailbulletin find(int id) 
	{
		Detailbulletin a=new Detailbulletin();
		DAO<Bulletin>BulletinDao=new BulletinDAO(con);
		DAO<Enseignement>EnseignementDao=new EnseignementDAO(con);
		
		String query="SELECT * FROM detailbulletin where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int idt=con.rset.getInt("id");
				 int idtr=con.rset.getInt("bulletin_id");
				 int idi=con.rset.getInt("enseignement_id");
				 String appreciation=con.rset.getString("appreciation");
				 
				 a=new Detailbulletin(idt,BulletinDao.find(idtr),EnseignementDao.find(idi),appreciation);
				
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