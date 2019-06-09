package controleur;

import java.sql.*;
import java.util.ArrayList;

import model.*;

public class BulletinDAO extends DAO<Bulletin>
{
	TrimestreDAO trimestre;
	InscriptionDAO inscription;
	ArrayList<Bulletin>tabBulletin;
	ArrayList<Detailbulletin>tabdetail;
	BulletinDAO bulletin;
	EnseignementDAO enseignement;

	public BulletinDAO(Connexion m_con) 
	{
		super(m_con);
		trimestre=new TrimestreDAO(con);
		inscription=new InscriptionDAO(con);
		tabBulletin=new ArrayList<Bulletin>();
		tabdetail=new ArrayList<Detailbulletin>();
		enseignement=new EnseignementDAO(con);
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
			 con.stmt.executeUpdate( "DELETE FROM bulletin Where id="+obj.getId());
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
			con.stmt.executeUpdate( "UPDATE bulletin SET trimestre_id='"+obj.getTrimestre().getId()+"', inscription_id='"+obj.getInscription().getId()+"', appreciation='"+obj.getAppreciation()+"' WHERE id="+obj.getId()+"");
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
	
	public ArrayList detailAll(int idr) 
	{
		Detailbulletin b=new Detailbulletin();
		String query="SELECT * FROM detailbulletin WHERE bulletin_id="+idr;
		try {
			con.rset1=con.stmt1.executeQuery(query);
			while(con.rset1.next())
			{
				int id=con.rset1.getInt("id");
				int idbulletin=con.rset1.getInt("bulletin_id");
				int idenseignement=con.rset1.getInt("enseignement_id");
				String appreciation=con.rset1.getString("appreciation");
				b=new Detailbulletin(id,find(idbulletin),enseignement.find(idenseignement),appreciation);
				
				tabdetail.add(b);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabdetail;
		
	}
	
	public double moyenneDetail(int id)
	{
		double somme=0;
		double moyenne=0;
		
		ArrayList<Detailbulletin> tab=detailAll(id);
		DetailbulletinDAO d=new DetailbulletinDAO(con);
		
		for(int i=0;i<tab.size();i++)
		{
			tab.get(i).setMoyenne(d.moyenneDiscipline(tab.get(i).getId()));
			somme=tab.get(i).getMoyenne()+somme;
		}
		moyenne=somme/tab.size();
		return moyenne;
	}

	public ResultSet Ro() 
	{
		
		Anneescolaire a=new Anneescolaire();
		String query="SELECT * FROM bulletin";
		
		try {
			con.rset=con.stmt.executeQuery(query);
			ResultSet rs=con.rset;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con.rset ;
	}
	

	

	

}