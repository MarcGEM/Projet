package vue;

import java.awt.Color;

import javax.swing.*;

public class GAnnee extends JFrame{

	
	public GAnnee() {
		super("Gestion Annee");
		getContentPane().setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(840,600);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		
		
	}
	
	
}
