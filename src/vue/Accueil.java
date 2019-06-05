package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import controleur.*;
import model.*;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Accueil implements ActionListener 
{
	JButton btnTrimestre = new JButton("Trimestre");
	JButton btnNiveau = new JButton("Niveau");
	JButton btnClasse = new JButton("Classe");
	JButton btnAnneScolaire = new JButton("Ann\u00E9e scolaire");
	JButton btnProfesseur = new JButton("Professeur");
	JButton btnDiscipline = new JButton("Discipline");
	JButton btnEleve = new JButton("Eleve");
	JButton btnEnseignement = new JButton("Enseignement");
	JButton btnInscription = new JButton("Inscription");
	JButton btnBulletin = new JButton("Bulletin");
	Connexion con;
	
	
	
	private JFrame frame;
	public Accueil() 
	{
		
		try {
			initialize();
			con= new Connexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 827, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		btnTrimestre.setBounds(0, 125, 115, 29);
		frame.getContentPane().add(btnTrimestre);
		btnTrimestre.addActionListener(this);
		
		
		btnNiveau.setBounds(0, 199, 115, 29);
		frame.getContentPane().add(btnNiveau);
		
		
		btnClasse.setBounds(0, 285, 115, 29);
		frame.getContentPane().add(btnClasse);
		
		
		btnAnneScolaire.setBounds(0, 51, 135, 29);
		frame.getContentPane().add(btnAnneScolaire);
		btnAnneScolaire.addActionListener(this);
		
		
		btnDiscipline.setBounds(0, 363, 115, 29);
		frame.getContentPane().add(btnDiscipline);
		
	
		btnEleve.setBounds(690, 51, 115, 29);
		frame.getContentPane().add(btnEleve);
		
		
		btnProfesseur.setBounds(690, 125, 115, 29);
		frame.getContentPane().add(btnProfesseur);
		
		
		btnEnseignement.setBounds(690, 199, 115, 29);
		frame.getContentPane().add(btnEnseignement);
		
		
		btnInscription.setBounds(690, 285, 115, 29);
		frame.getContentPane().add(btnInscription);
		
		
		btnBulletin.setBounds(690, 363, 115, 29);
		frame.getContentPane().add(btnBulletin);
		this.frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnAnneScolaire)
		{
			this.frame.setVisible(false);
			DAO<Anneescolaire> anneescolaireDao = new AnneescolaireDAO(con);
		}
		if(e.getSource() == btnTrimestre)
		{
			this.frame.setVisible(false);
			DAO<Trimestre> trimestreDao = new TrimestreDAO(con);
		}
		
		
	}

}
