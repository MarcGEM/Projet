package vue;
import java.sql.SQLException;
import java.util.Scanner;

import model.*;
import controleur.*;

public class Test {

	public static void main(String[] args) 
	{

		/*
		try {

		
		/*try {
			/*

			//Connexion con = new Connexion();
			
			//DAO<Trimestre> trimestreDao = new TrimestreDAO(con);
			//DAO<Anneescolaire> anneescolaireDao = new AnneescolaireDAO(con);
			DAO<Niveau> niveauDao=new NiveauDAO(con);
			DAO<Classe>classeDao=new ClasseDAO(con);
			DAO<Discipline>disciplineDao=new DisciplineDAO(con);
			DAO<Enseignement>EnseignementDao=new EnseignementDAO(con);
			DAO<Prof>ProfDao=new ProfDAO(con);
			DAO<Inscription>InscriptionDao=new InscriptionDAO(con);
			DAO<Eleve>EleveDao=new EleveDAO(con);
			DAO<Bulletin>BulletinDao=new BulletinDAO(con);
			DAO<Detailbulletin>DetailDao=new DetailbulletinDAO(con);
			DAO<Evaluation>EvaluationDao=new EvaluationDAO(con);
			
			
			Anneescolaire a=new Anneescolaire(1,"2019");
			Trimestre t=new Trimestre(1,1,"2019-05-30","2019-06-01",a);
			Niveau n=new Niveau(1,"CE1");
			Classe c=new Classe(1,"A",n,a);
			Eleve e=new Eleve(1,"GEMAYEL","Marc");
			Inscription i1=new Inscription(1,c,e);
			Discipline d=new Discipline(1,"Physique");
			Discipline d2=new Discipline(2,"Mathématique");
			Prof luc=new Prof(2,"Skywalker","Luc");
			Prof jac=new Prof(3,"Landers","Jacques");
			Inscription ins=new Inscription(1,c,e);
	
			Enseignement ens=new Enseignement(1,c,luc,d);
			Enseignement ens1=new Enseignement(2,c,jac,d2);
			
			
			
			Bulletin b1=new Bulletin(1,t,i1,"Bonne élève");
			Detailbulletin d1=new Detailbulletin(1,b1,ens,"Bonne");
			Detailbulletin de2=new Detailbulletin(2,b1,ens1,"Manque de travail");
			Evaluation e1=new Evaluation(1,d1,15,"Très bon boulot");
			Evaluation e2=new Evaluation(2,d1,16,"Encore");
			
			Evaluation e3=new Evaluation(3,de2,8,"Manque de travail");
			
			System.out.println("Bulletin de: "+b1.getInscription().getEleve().getPrenom()+" "+b1.getInscription().getEleve().getNom()+" du "+b1.getTrimestre().getNumero()+" trimestre");
			System.out.println("moyenne en "+d1.getEnseignement().getDiscipline().getNom()+ " : "+d1.moyenneDiscipline());
			System.out.println("moyenne en "+de2.getEnseignement().getDiscipline().getNom()+ " : "+de2.moyenneDiscipline());
			System.out.println("Moyenne général du trimestre: "+b1.moyenneGeneral());
			
			//Anneescolaire a1=anneescolaireDao.find(1);
			
			
			//System.out.println(a1.getAnnee());
			
			//EvaluationDao.create(e1);
			
			//Evaluation ins1=EvaluationDao.find(1);
			//System.out.println(ins1.getNote());
			//ProfDao.create(luc);
			//Enseignement ensei1=EnseignementDao.find(1);
			
			//System.out.println(ensei1.getClasse().getNom());
			//Trimestre t1=trimestreDao.find(1);
			//Niveau n1=niveauDao.find(1);
			*/
			//System.out.println(n1.getNom());

			

			//Accueil ap=new Accueil();

			
			
			
			
			/*
			Anneescolaire a=new Anneescolaire(1,"2019");
			
			
			
			
			
			
			
			Prof p=new Prof(1,"Gemayel","Marc");
			
			Prof luc=new Prof(2,"Skywalker","Luc");
			
			
		*/
		
			
			

			/*
	      
		} catch (ClassNotFoundException e) {

			
	   
		/*} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	   
	     */ 
		Accueil ap=new Accueil();
	    }
	
		
	

	
		
		
		//Acceuil Pacceuil = new Acceuil();
	   GestionAnnee GA = new GestionAnnee();
	      
	}
	


	}


