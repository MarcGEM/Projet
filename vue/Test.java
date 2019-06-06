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
			
			
			
			
			
			

			con = new Connexion();
			ClasseDAO classeDao=new ClasseDAO(con);
			//AnneescolaireDAO classeDao=new AnneescolaireDAO(con);
			ArrayList<Classe> c=classeDao.seeAll();
			
			System.out.println(c.get(2).getNom());
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
		
			//GestionAnnee GA = new GestionAnnee();
	  
	      
	    }


		
		

		
	   
		
}
		

	   
	     

	
		
	

	

	
	





