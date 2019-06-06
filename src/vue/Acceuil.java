package vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import model.Connexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;;

public class Acceuil extends JFrame  {
	
	
	private Fenetre Acceuil;
	private Label Label1;
	private Label Label2;
	private Label Label3;
	private JTextField JText1;
	private JTextField JText2;
	private JButton ButtonCo ;
	private JButton ButtonCo1 ;
	private JPasswordField JMdp;
	private JPanel L1;
	private JPanel L2;
	private JPanel L3;
	private JPanel L4;
	private JButton btnNewButton;
	Connexion con;
	

	public Acceuil() {
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		}catch(Exception e){
			e.getMessage();
		}
		
		
		Acceuil = new Fenetre();
		Acceuil.setTitle("Page d'Acceuil");
		Label1= new Label("Nom Serveur");
		Label1.setAlignment(Label.CENTER);
		Label2= new Label("Nom DB");
		L1= new JPanel();
		L2= new JPanel();
		L3= new JPanel();
		L4= new JPanel();
		JText1 = new JTextField("Nom Serveur");
		JText1.setColumns(10);
		JText2 = new JTextField("Nom DB");
		JText2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		JMdp = new JPasswordField("MDP");
		ButtonCo = new JButton("connexion");
		ButtonCo.addActionListener(new ButtonCo1Listener());
		ButtonCo1 = new JButton("co");
		ButtonCo1.addActionListener(new ButtonCo2Listener());
		
		
		
		
		L1.add(Label1);
		L1.add(JText1);
		
		
		L2.add(Label2);
		L2.add(JText2);
		
		
		Label3= new Label("Mdp");
		L3.add(Label3);
		L3.add(JMdp);
		
		
		
		
		//L4.add(L2);
		//L4.add(L3);
		L4.add(ButtonCo);
		//L4.add(new JButton("ok"));
	
		
		/*
		Acceuil.getContentPane().add(Label1);
		Acceuil.getContentPane().add(JText1);
		Acceuil.getContentPane().add(Label2);
		Acceuil.getContentPane().add(JText2);
		Acceuil.getContentPane().add(Label3);
		Acceuil.getContentPane().add(JMdp);
		Acceuil.getContentPane().add(ButtonCo);
		Acceuil.getContentPane().add(ButtonCo1);*/
		Acceuil.getContentPane().add(L1);
		Acceuil.getContentPane().add(L2);
		Acceuil.getContentPane().add(L3);
		Acceuil.getContentPane().add(L4);
		
		
		Acceuil.setVisible(true);

		
	
		//Acceuil.getContentPane().add(new JButton("Connexion"));
	
	}
	//methode qui ecoutera le button1
	class ButtonCo1Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String nomServer = JText1.getText();
			String nomDB=JText2.getText();
			String Mdp = JMdp.getText();
			String UrlDataBase = nomServer+nomDB;
			try {
			con = new Connexion(UrlDataBase,Mdp);
			}catch(Exception d) {
				d.getMessage();
			}
			
			System.out.println(UrlDataBase);
			System.out.println(Mdp);
			
			
		}
		
	}
	
	//methode qui ecoutera le button2
	class ButtonCo2Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			System.out.println("ok2");
			
		}
		
	}
	
	

	
}
