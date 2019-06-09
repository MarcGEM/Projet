package vue;

import java.awt.Color;

import javax.swing.*;

import model.Connexion;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Acceuil extends JFrame implements ActionListener {

	private Connexion con;
	JButton anneescolaire;
	JButton trimestre;
	JButton niveau;
	JButton classe;
	JButton discipline;
	JButton prof;
	JButton eleve;
	JButton enseignement;
	JButton inscription;
	JButton bulletin;
	JButton detailbulletin;
	JButton evaluation;
	
	
	
	
	public  Acceuil() {
		super("Acceuil");
		getContentPane().setBackground(Color.CYAN);
		getContentPane().setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(735,580);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		 anneescolaire= new JButton("");
		 anneescolaire.setIcon(new ImageIcon(Acceuil.class.getResource("/images/Annee scolaire.png")));
		anneescolaire.setBounds(21, 57, 148, 135);
		getContentPane().add(anneescolaire);
		anneescolaire.addActionListener(this);
		
		 trimestre  = new JButton("");
		 trimestre.setIcon(new ImageIcon(Acceuil.class.getResource("/images/trimestre.png")));
		trimestre.setBounds(184, 57, 141, 135);
		getContentPane().add(trimestre);
		trimestre.addActionListener(this);
		
		 niveau = new JButton("");
		 niveau.setIcon(new ImageIcon(Acceuil.class.getResource("/images/Niveau.png")));
		niveau.setBounds(351, 57, 141, 135);
		getContentPane().add(niveau);
		niveau.addActionListener(this);
		
		 classe = new JButton("");
		 classe.setIcon(new ImageIcon(Acceuil.class.getResource("/images/Classe.png")));
		classe.setBounds(513, 57, 141, 135);
		getContentPane().add(classe);
		classe.addActionListener(this);
		
		discipline = new JButton("");
		discipline.setIcon(new ImageIcon(Acceuil.class.getResource("/images/discipline.png")));
		discipline.setBounds(28, 216, 141, 135);
		getContentPane().add(discipline);
		discipline.addActionListener(this);
		
		 prof = new JButton("");
		 prof.setIcon(new ImageIcon(Acceuil.class.getResource("/images/teacher.png")));
		prof.setBounds(189, 216, 141, 135);
		getContentPane().add(prof);
		prof.addActionListener(this);
		
		 eleve = new JButton("");
		 eleve.setIcon(new ImageIcon(Acceuil.class.getResource("/images/Eleve.png")));
		eleve.setBounds(351, 213, 141, 135);
		getContentPane().add(eleve);
		eleve.addActionListener(this);
		
		 enseignement = new JButton("");
		 enseignement.setIcon(new ImageIcon(Acceuil.class.getResource("/images/Enseignement.png")));
		enseignement.setBounds(513, 216, 141, 135);
		getContentPane().add(enseignement);
		enseignement.addActionListener(this);
		
		 inscription = new JButton("");
		 inscription.setIcon(new ImageIcon(Acceuil.class.getResource("/images/Inscription.png")));
		inscription.setBounds(28, 372, 141, 135);
		getContentPane().add(inscription);
		inscription.addActionListener(this);
		
		 bulletin = new JButton("");
		 bulletin.setIcon(new ImageIcon(Acceuil.class.getResource("/images/Bulletin.png")));
		bulletin.setBounds(189, 372, 141, 135);
		getContentPane().add(bulletin);
		bulletin.addActionListener(this);
		
		 detailbulletin = new JButton("");
		 detailbulletin.setIcon(new ImageIcon(Acceuil.class.getResource("/images/Detail.png")));
		detailbulletin.setBounds(351, 372, 141, 135);
		getContentPane().add(detailbulletin);
		detailbulletin.addActionListener(this);
		
		 evaluation = new JButton("");
		 evaluation.setIcon(new ImageIcon(Acceuil.class.getResource("/images/exam.png")));
		evaluation.setBounds(513, 372, 141, 135);
		getContentPane().add(evaluation);
		evaluation.addActionListener(this);
		
		setResizable(false);
		
		try {
			con=new Connexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(true);	
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==anneescolaire)
		{
			GAnnee g=new GAnnee(con);
			this.setVisible(false);
		}
		
		if(e.getSource()==trimestre)
		{
			GTrimestre g=new GTrimestre(con);
			this.setVisible(false);
		}
		
		if(e.getSource()==niveau)
		{
			GNiveau g=new GNiveau(con);
			this.setVisible(false);
		}
		
		
		if(e.getSource()==classe)
		{
			GClasse g=new GClasse(con);
			this.setVisible(false);
		}
		if(e.getSource()==discipline)
		{
			GDiscipline g=new GDiscipline(con);
			this.setVisible(false);
		}
		
		if(e.getSource()==prof)
		{
			GProf g=new GProf(con);
			this.setVisible(false);
		}
		if(e.getSource()==eleve)
		{
			GEleve g=new GEleve(con);
			this.setVisible(false);
		}
		
		if(e.getSource()==enseignement)
		{
			GEnseignement g=new GEnseignement(con);
			this.setVisible(false);
		}
		
		if(e.getSource()==inscription)
		{
			GInscription g=new GInscription(con);
			this.setVisible(false);
		}
		
		if(e.getSource()==bulletin)
		{
			//en attente
		}
		
		if(e.getSource()==detailbulletin)
		{
			//en attente
		}
		
		if(e.getSource()==evaluation)
		{
			GEvaluation g=new GEvaluation(con);
			this.setVisible(false);
		}
		
		
		
	}
}
