package vue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controleur.*;
import model.Anneescolaire;
import model.Connexion;


public class GestionAnnee extends JFrame {

	private Fenetre GAnnee;
	private JTextField JTextId;
	private JTextField JTextAnnee;
	
	private Connexion con;
	
	
	
	
	
	
	public GestionAnnee() {
		
		
		super("Gestion Annee");
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(900,600);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		try {
			 con = new Connexion();
			}catch(Exception d) {
				d.getMessage();
			}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 894, 40);
		getContentPane().add(menuBar);
		
		JMenu MenuAjouter = new JMenu("Ajouter");
		menuBar.add(MenuAjouter);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		MenuAjouter.add(mntmNewMenuItem);
		
		JMenuItem MItemAnnnee = new JMenuItem("Annee");
		MenuAjouter.add(MItemAnnnee);
		
		JMenu MeuModifie = new JMenu("Modifier");
		menuBar.add(MeuModifie);
		
		JMenu MenuSupprimer = new JMenu("Supprimer");
		menuBar.add(MenuSupprimer);
		
		JMenu MenuAide = new JMenu("Aide");
		menuBar.add(MenuAide);
		
		
		JPanel JAjout = new JPanel();
		JAjout.setBounds(21, 68, 293, 216);
		getContentPane().add(JAjout);
		JAjout.setLayout(null);
		
		JLabel lblAjouterUneAnnee = new JLabel("Ajouter une annee");
		lblAjouterUneAnnee.setBounds(59, 5, 174, 26);
		JAjout.add(lblAjouterUneAnnee);
		
		JTextId = new JTextField();
		JTextId.setBounds(98, 52, 186, 32);
		JAjout.add(JTextId);
		JTextId.setColumns(10);
		
		JLabel JId = new JLabel("ID ");
		JId.setBounds(31, 52, 29, 26);
		JAjout.add(JId);
		
		JLabel LAnnee = new JLabel("Annee");
		LAnnee.setBounds(21, 114, 59, 26);
		JAjout.add(LAnnee);
		
		JButton JBAdd = new JButton("ADD");
		JBAdd.setBounds(98, 160, 73, 35);
		JBAdd.addActionListener(new ButtonAddListener());
		JAjout.add(JBAdd);
		
		JTextAnnee = new JTextField();
		JTextAnnee.setBounds(98, 111, 186, 32);
		JAjout.add(JTextAnnee);
		JTextAnnee.setColumns(10);
		
		JLabel Fond = new JLabel("");
		Fond.setIcon(new ImageIcon("C:\\Users\\compaore\\eclipse-workspace\\Projet\\images\\Fond2.png"));
		Fond.setBounds(0, 0, 894, 549);
		getContentPane().add(Fond);
		
		this.setVisible(true);
		
		
	}
	
	//methode qui ecoutera le button add
		class ButtonAddListener implements ActionListener{
			
			
		

			public void actionPerformed(ActionEvent e) {
				String id = JTextId.getText();
				Integer s=Integer.valueOf(id);
				String Annee=JTextAnnee.getText();
				AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
				Anneescolaire a=new Anneescolaire(s,Annee);
				annee1.create(a);
				
				try {
					Connexion con = new Connexion();
					
					}catch(Exception d) {
						d.getMessage();
					}
				
				
				
				
			}
			
		}
}
