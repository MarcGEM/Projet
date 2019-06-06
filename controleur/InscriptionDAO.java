package controleur;

import java.sql.*;
import java.util.ArrayList;

import model.*;

public class InscriptionDAO extends DAO<Inscription>
{
	ClasseDAO classe;
	EleveDAO eleve;
	ArrayList<Inscription> tabInscription;
	

	public InscriptionDAO(Connexion m_con) 
	{
		super(m_con);
		
		classe=new ClasseDAO(con);
		eleve=new EleveDAO(con);
		tabInscription=new ArrayList<Inscription>();
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
	public Inscription find(int id) 
	{
		Inscription a=new Inscription();
		DAO<Classe>classeDao=new ClasseDAO(con);
		DAO<Eleve>EleveDao=new EleveDAO(con);
		
		String query="SELECT * FROM inscription where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int idt=con.rset.getInt("id");
				 int idc=con.rset.getInt("classe_id");
				 int ide=con.rset.getInt("eleve_id");
				 
				 a=new Inscription(idt,classeDao.find(idc),EleveDao.find(ide));
				
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
		Inscription i=new Inscription();
		String query="SELECT * FROM inscription";
		try {
			con.rset1=con.stmt1.executeQuery(query);
			while(con.rset1.next())
			{
				int id=con.rset1.getInt("id");
				int idclasse=con.rset1.getInt("classe_id");
				int ideleve=con.rset1.getInt("eleve_id");
				
				i=new Inscription(id,classe.find(idclasse),eleve.find(ideleve));
				
				tabInscription.add(i);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabInscription;
		
		
	}

	

	

}
