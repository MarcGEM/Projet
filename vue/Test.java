package vue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import controleur.*;

public class Test {

	public static void main(String[] args) 
	{
		Connexion con;
		try {
			
			con=new Connexion();
			
			
			
			

			//con = new Connexion();
			//AnneescolaireDAO bullDao= new AnneescolaireDAO(con);
			//AnneescolaireDAO classeDao=new AnneescolaireDAO(con);
			//ArrayList<Anneescolaire> c=bullDao.seeAll();
			
			//System.out.println(c.get(0).getId());
			

			//GTrimestre g = new GTrimestre(con);
			//GClasse g= new GClasse(con);
			GEnseignement g = new GEnseignement(con);
			//GProf g= new GProf(con);
			//GDiscipline g = new GDiscipline(con);
			//GEvaluation g=new GEvaluation(con);
			//GInscription g=new GInscription(con);

			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
		
			//GestionAnnee GA = new GestionAnnee();

		//ConnexionA A = new ConnexionA();
		
	     //Acceuil b = new Acceuil() ;

	  
	      

	    }


		
		

		
	   
		
}
		

	   
	     

	
		
	

	

	
	





