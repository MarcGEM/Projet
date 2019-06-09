package vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;


import controleur.*;
import model.Bulletin;
import model.Connexion;

public class GAffichageBulletin extends JFrame
{

	ArrayList<JLabel>tab;
	BulletinDAO b;
	
	
	public  GAffichageBulletin(Connexion con,int nbr)  {
		super("Bulletin");
		getContentPane().setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(840,651);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		tab=new ArrayList<JLabel>();
		
		b=new BulletinDAO(con);
	    Bulletin c=new Bulletin();
		
		
		
			
			
			
			
			
			
			
			
			
			this.setVisible(true);	
	}
		
	
	
	
}
