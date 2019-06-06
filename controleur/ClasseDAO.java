package controleur;

import java.sql.*;
import java.util.ArrayList;

import model.*;

public class ClasseDAO extends DAO<Classe>
{
	ArrayList<Classe>tabClasse;
	AnneescolaireDAO annee;
	NiveauDAO niveau;

	public ClasseDAO(Connexion m_con) {
		super(m_con);
		tabClasse=new ArrayList<Classe>();
		annee=new AnneescolaireDAO(con);
		niveau=new NiveauDAO(con);
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Classe obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO classe (id,nom,niveau_id,anneescolaire_id) VALUES ('"+obj.getId()+"','"+obj.getNom()+"','"+obj.getNiveau().getId()+"','"+obj.getAnneescolaire().getId()+"')");
			System.out.println("Classe create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Classe obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM classe Where id="+obj.getId());
			System.out.println("Classe delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Classe obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE classe SET nom='"+obj.getNom()+"', niveau_id='"+obj.getNiveau().getId()+"', anneescolaire_id='"+obj.getAnneescolaire().getId()+"' WHERE id="+obj.getId()+"");
			System.out.println("classe update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Classe find(int id) 
	{
		Anneescolaire a=new Anneescolaire();
		Niveau n=new Niveau();
		Classe c=new Classe();
		String query="SELECT * FROM classe where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int idt=con.rset.getInt("id");
				 String nom=con.rset.getString("nom");
				 int idn=con.rset.getInt("niveau_id");
				 int ida=con.rset.getInt("anneescolaire_id");
				 query="SELECT * FROM anneescolaire where id="+ida;
				 con.rset=con.stmt.executeQuery(query);
				 if(con.rset.first())
				 {
					 a=new Anneescolaire(con.rset.getInt("id"),con.rset.getString("annee"));
					 query="SELECT * FROM niveau where id="+idn;
					 con.rset=con.stmt.executeQuery(query);
					 if(con.rset.first())
					 {
						 n=new Niveau(con.rset.getInt("id"),con.rset.getString("nom"));
						 c=new Classe(idt,nom,n,a);
					 }
					 
				 }
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}

	@Override
	public ArrayList seeAll() 
	{
		Classe c=new Classe();
		String query="SELECT * FROM classe";
		try {
			con.rset1=con.stmt1.executeQuery(query);
			while(con.rset1.next())
			{
				int id=con.rset1.getInt("id");
				String nom=con.rset1.getString("nom");
				int idniveau=con.rset1.getInt("niveau_id");
				int idanneescolaire=con.rset1.getInt("anneescolaire_id");
				
				c=new Classe(id,nom,niveau.find(idniveau),annee.find(idanneescolaire));
				
				tabClasse.add(c);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabClasse;
		
	}
	
}