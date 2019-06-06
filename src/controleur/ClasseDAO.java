package controleur;

import java.sql.*;

import model.*;

public class ClasseDAO extends DAO<Classe>
{

	public ClasseDAO(Connexion m_con) {
		super(m_con);
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
	public void seeAll() 
	{
		// TODO Auto-generated method stub
		
	}
	
}