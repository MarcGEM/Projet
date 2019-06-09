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
			
			//ConnexionA ad=new ConnexionA();
			//DetailbulletinDAO d=new DetailbulletinDAO(con);
			
			//System.out.println(d.moyenneDiscipline(1));
			
			//BulletinDAO b=new BulletinDAO(con);
			
			//System.out.print(b.moyenneDetail(1));

			
			//ConnexionA g = new ConnexionA();
			//Acceuil a= new Acceuil();
			//GTrimestre g = new GTrimestre(con);
			//GClasse g= new GClasse(con);
			//GEnseignement g = new GEnseignement(con);
			
			GBulletin g= new GBulletin(con);
			
			//GAffichageBulletin a = new GAffichageBulletin(con,2);
			//GProf g= new GProf(con);
			//GDiscipline g = new GDiscipline(con);
			//GEvaluation g=new GEvaluation(con);
			//GInscription g=new GInscription(con);
			//GEleve g = new GEleve(con);

			//GGraphique g=new GGraphique(con);

			//GDetail g = new GDetail(con);

			
			//GAffichageBulletin v=new GAffichageBulletin(con,1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
		
			//GestionAnnee GA = new GestionAnnee();

		//ConnexionA A = new ConnexionA();
		
	     //Acceuil b = new Acceuil() ;

	  
	      

	    

		
		
	}
		
	   
		
}
		

	   
	     

	
		
	

	

	
	





