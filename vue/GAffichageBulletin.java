package vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;


import controleur.*;
import model.Anneescolaire;
import model.Bulletin;
import model.Connexion;
import vue.GAnnee.BModifListenerAnnee;
import vue.GAnnee.BSuppIdListener;
import vue.GAnnee.BtAfficherListener;
import vue.GAnnee.BtMenu;
import vue.GAnnee.ButtonAddListener;
import vue.GAnnee.MouseAdapter;

public class GAffichageBulletin extends JFrame
{

	ArrayList<JLabel>tab;
	BulletinDAO b;
	JLabel l;
	
	
	public  GAffichageBulletin(Connexion con,int nbr)  
	{
		
		
		getContentPane().setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(840,651);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(298, 0, 536, 263);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		setResizable(false);
		//oupsi
		
		
		this.setVisible(true);
		
		
		
		
		
			
			
			
			
	}
		
	
	
	
}
