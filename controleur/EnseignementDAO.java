package controleur;

import java.sql.*;
import java.util.ArrayList;

import model.*;

public class EnseignementDAO extends DAO<Enseignement>
{
	ClasseDAO classe;
	DisciplineDAO discipline;
	ProfDAO prof;
	ArrayList<Enseignement> tabEnseignement;

	public EnseignementDAO(Connexion m_con) 
	{
		super(m_con);
		classe=new ClasseDAO(con);
		discipline=new DisciplineDAO(con);
		prof=new ProfDAO(con);
		
		
		
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
	public Enseignement find(int id) 
	{
		Enseignement a=new Enseignement();
		DAO<Classe>classeDao=new ClasseDAO(con);
		DAO<Discipline>disciplineDao=new DisciplineDAO(con);
		DAO<Prof>ProfDao=new ProfDAO(con);
		
		String query="SELECT * FROM enseignement where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int ide=con.rset.getInt("id");
				 int idc=con.rset.getInt("classe_id");
				 int idd=con.rset.getInt("discipline_id");
				 int idp=con.rset.getInt("prof_id");
				 
				 a=new Enseignement(ide,classeDao.find(idc),ProfDao.find(idp),disciplineDao.find(idd));
				
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
		Enseignement ens=new Enseignement();
		String query="SELECT * FROM enseignement";
		try {
			con.rset1=con.stmt1.executeQuery(query);
			while(con.rset1.next())
			{
				int id=con.rset1.getInt("id");
				int idclasse=con.rset1.getInt("classe_id");
				int iddiscipline=con.rset1.getInt("discipline_id");
				int idprof=con.rset1.getInt("prof_id");
				
				ens=new Enseignement(id,classe.find(idclasse),prof.find(idprof),discipline.find(iddiscipline));
				
				tabEnseignement.add(ens);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabEnseignement;
		
	}

	public ResultSet Ro() 
	{
		
		Anneescolaire a=new Anneescolaire();
		String query="SELECT * FROM enseignement";
		
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

	

	


