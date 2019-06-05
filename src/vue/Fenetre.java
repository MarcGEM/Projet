package vue;

import java.awt.FlowLayout;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	
	//content pane
	
	
	public Fenetre() {
		super("Page d'acceuil");
		//affichage
		//this.setVisible(true);
		//fermeture fenetre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//taille
		this.setSize(600,400);
		//position au centre
		this.setLocationRelativeTo(null);
		//initialisation content pane
		JPanel ContentPane =(JPanel) this.getContentPane();
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		 //ContentPane.add(new JButton("ok"));
	}

	
	
}
