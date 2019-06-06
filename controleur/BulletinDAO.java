package controleur;

import java.sql.*;
import java.util.ArrayList;

import model.*;

public class BulletinDAO extends DAO<Bulletin>
{
	TrimestreDAO trimestre;
	InscriptionDAO inscription;
	ArrayList<Bulletin>tabBulletin;

	public BulletinDAO(Connexion m_con) 
	{
		super(m_con);
		trimestre=new TrimestreDAO(con);
		inscription=new InscriptionDAO(con);
		tabBulletin=new ArrayList<Bulletin>();
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
		Bulletin a=new Bulletin();
		DAO<Trimestre> trimestreDao = new TrimestreDAO(con);
		DAO<Inscription>InscriptionDao=new InscriptionDAO(con);
		
		String query="SELECT * FROM bulletin where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int idt=con.rset.getInt("id");
				 int idtr=con.rset.getInt("trimestre_id");
				 int idi=con.rset.getInt("inscription_id");
				 String appreciation=con.rset.getString("appreciation");
				 
				 a=new Bulletin(idt,trimestreDao.find(idtr),InscriptionDao.find(idi),appreciation);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public ArrayList seeAll() 
	{
		Bulletin b=new Bulletin();
		String query="SELECT * FROM bulletin";
		try {
			con.rset1=con.stmt1.executeQuery(query);
			while(con.rset1.next())
			{
				int id=con.rset1.getInt("id");
				int idtrimestre=con.rset1.getInt("trimestre_id");
				int idinscription=con.rset1.getInt("eleve_id");
				String appreciation=con.rset1.getString("appreciation");
				b=new Bulletin(id,trimestre.find(idtrimestre),inscription.find(idinscription),appreciation);
				
				tabBulletin.add(b);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabBulletin;
		
		
		
		
	}

	

	

}