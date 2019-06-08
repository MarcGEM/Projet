package controleur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import model.*;

public class TrimestreDAO extends DAO<Trimestre> 
{
	ArrayList<Trimestre>tabTrimestre;
	AnneescolaireDAO annee;
	
	public TrimestreDAO(Connexion m_con) 
	{
		super(m_con);	
		annee = new AnneescolaireDAO(con);
		tabTrimestre=new ArrayList<Trimestre>();
	}
		
	@Override
	public void create(Trimestre obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO trimestre (id,numero,debut,fin,anneescolaire_id) VALUES ('"+obj.getId()+"','"+obj.getNumero()+"','"+obj.getDebut()+"','"+obj.getFin()+"','"+obj.getAnneescolaire().getId()+"')");
			System.out.println("Trimestre create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Trimestre obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM Trimestre Where id="+obj.getId());
			System.out.println("Trimestre delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Trimestre obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE Trimestre SET numero='"+obj.getNumero()+"', debut='"+obj.getDebut()+"', fin='"+obj.getFin()+"', anneescolaire_id='"+obj.getAnneescolaire().getId()+"' WHERE id="+obj.getId()+"");
			System.out.println("Trimestre update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Trimestre find(int id) 
	{
		Anneescolaire a=new Anneescolaire();
		Trimestre t=new Trimestre();
		String query="SELECT * FROM trimestre where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int idt=con.rset.getInt("id");
				 int numero=con.rset.getInt("numero");
				 String debut=con.rset.getString("debut");
				 String fin=con.rset.getString("fin");
				 int ida=con.rset.getInt("anneescolaire_id");
				 query="SELECT * FROM anneescolaire where id="+ida;
				 con.rset=con.stmt.executeQuery(query);
				 if(con.rset.first())
				 {
					 a=new Anneescolaire(con.rset.getInt("id"),con.rset.getString("annee"));
					 t=new Trimestre(idt,numero,debut,fin,a);
				 }
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		
	}

	@Override
	public ArrayList seeAll() 
	{
		Trimestre t=new Trimestre();
		String query="SELECT * FROM trimestre";
		try {
			con.rset1=con.stmt1.executeQuery(query);
			while(con.rset.next())
			{
				int id=con.rset1.getInt("id");
				int numero=con.rset1.getInt("numero");
				String debut=con.rset1.getString("debut");
				String fin=con.rset1.getString("fin");
				int idanneescolaire=con.rset1.getInt("anneescolaire_id");
				
				t=new Trimestre(id,numero,debut,fin,annee.find(idanneescolaire));
				
				tabTrimestre.add(t);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabTrimestre;
		
	}
	
	public ResultSet Ro() 
	{
		
		Anneescolaire a=new Anneescolaire();
		String query="SELECT * FROM trimestre";
		
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
