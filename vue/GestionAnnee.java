package vue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controleur.*;
import model.Anneescolaire;
import model.Connexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GestionAnnee extends JFrame {

	private Fenetre GAnnee;
	private JTextField JTextId;
	private JTextField JTextAnnee;
	private JPanel JAjout;
	private Connexion con;
	private JTextField TId;
	private JTextField TAnnee;
	private JPanel JModif;
	private JTextField TIdSupp;
	private JPanel JSupp;
	
	
	
	
	
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
		
		JMenuItem MItemAnnnee = new JMenuItem("Annee");
		MItemAnnnee.addActionListener(new MItemAnneeListener());
		MenuAjouter.add(MItemAnnnee);
		
		JMenuItem MItemTrimestre = new JMenuItem("Trimestre");
		MenuAjouter.add(MItemTrimestre);
		
		JMenuItem MItemBulletin = new JMenuItem("Bulletin");
		MenuAjouter.add(MItemBulletin);
		
		JMenuItem MItemNiveau = new JMenuItem("Niveau");
		MenuAjouter.add(MItemNiveau);
		
		JMenuItem MItemDiscipline = new JMenuItem("Discipline");
		MenuAjouter.add(MItemDiscipline);
		
		JMenuItem MItemEleve = new JMenuItem("Eleve");
		MenuAjouter.add(MItemEleve);
		
		JMenuItem MItemProf = new JMenuItem("Prof");
		MenuAjouter.add(MItemProf);
		
		JMenuItem MItemInscription = new JMenuItem("Inscription");
		MenuAjouter.add(MItemInscription);
		
		JMenuItem MDetailBulletin = new JMenuItem("Detail Bulletin");
		MenuAjouter.add(MDetailBulletin);
		
		JMenuItem MItemEvaluation = new JMenuItem("Evaluation");
		MenuAjouter.add(MItemEvaluation);
		
		JMenu MenuModifier = new JMenu("Modifier");
		menuBar.add(MenuModifier);
		
		JMenuItem MModifAnnee = new JMenuItem("Annee");
		MModifAnnee.addActionListener(new MModifierAnneListener());
		MenuModifier.add(MModifAnnee);
		
		JMenu MenuSupprimer = new JMenu("Supprimer");
		menuBar.add(MenuSupprimer);
		
		JMenuItem MSuppAnnee = new JMenuItem("Annee");
		MenuSupprimer.add(MSuppAnnee);
		MSuppAnnee.addActionListener(new MSuppAnneeListener());
		JMenu MenuAide = new JMenu("Aide");
		menuBar.add(MenuAide);
		
		
		JAjout = new JPanel();
		JAjout.setBounds(207, 93, 293, 216);
		
		JAjout.setLayout(null);
		getContentPane().add(JAjout);
		
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
		
		JButton JBAdd = new JButton("ADD");
		JBAdd.setBounds(98, 160, 73, 35);
		JBAdd.addActionListener(new ButtonAddListener());
		JAjout.add(JBAdd);
		
		JTextAnnee = new JTextField();
		JTextAnnee.setBounds(98, 111, 186, 32);
		JAjout.add(JTextAnnee);
		JTextAnnee.setColumns(10);
		
		JLabel LAnnee = new JLabel("Annee");
		LAnnee.setBounds(21, 117, 59, 26);
		JAjout.add(LAnnee);
		JAjout.setVisible(false);
		
		JSupp = new JPanel();
		JSupp.setBounds(0, 0, 308, 228);
		getContentPane().add(JSupp);
		
		
		JButton BSupp = new JButton("SUPPRIMER");
		BSupp.setBounds(79, 172, 178, 35);
		BSupp.addActionListener(new BMSuppIdListener());
		JSupp.setLayout(null);
		JSupp.add(BSupp);
		
		JLabel lbId = new JLabel("ID");
		lbId.setBounds(112, 45, 92, 26);
		JSupp.add(lbId);
		
		TIdSupp = new JTextField();
		TIdSupp.setBounds(71, 96, 186, 32);
		JSupp.add(TIdSupp);
		TIdSupp.setColumns(10);
		JSupp.setVisible(false);
		
		JModif = new JPanel();
		JModif.setBounds(190, 68, 359, 253);
		getContentPane().add(JModif);
		JModif.setLayout(null);
		
		JLabel lblModifier = new JLabel("MODIFIER");
		lblModifier.setBounds(99, 10, 151, 26);
		JModif.add(lblModifier);
		
		JLabel LId = new JLabel("ID");
		LId.setBounds(36, 71, 92, 26);
		JModif.add(LId);
		
		TId = new JTextField();
		TId.setBounds(138, 68, 186, 32);
		JModif.add(TId);
		TId.setColumns(10);
		
		JLabel LbelAnnee = new JLabel("Annee");
		LbelAnnee.setBounds(36, 153, 92, 26);
		JModif.add(LbelAnnee);
		
		TAnnee = new JTextField();
		TAnnee.setBounds(138, 150, 186, 32);
		JModif.add(TAnnee);
		TAnnee.setColumns(10);
		
		JButton BModifierId = new JButton("Modifier");
		BModifierId.setBounds(99, 200, 141, 35);
		BModifierId.addActionListener(new BModifListenerID());
		JModif.add(BModifierId);
		JModif.setVisible(false);
		
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
		class BModifListenerID implements ActionListener {

			
			public void actionPerformed(ActionEvent e) {
				String id = TId.getText();
				Integer s=Integer.valueOf(id);
				String Annee=TAnnee.getText();
				AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
				
				Anneescolaire a=annee1.find(s);
				a.setAnnee(Annee);
				annee1.update(a);
			}
		}
		class BMSuppIdListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				String id = TIdSupp.getText();
				Integer s=Integer.valueOf(id);
				AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
				
				Anneescolaire a=annee1.find(s);
				annee1.delete(a);
				
			}
			
		}
		
			
			
		class MItemAnneeListener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				JModif.setVisible(false);
				JAjout.setVisible(true);
			}
			
		}
		class MModifierAnneListener implements ActionListener{
		
			public void actionPerformed(ActionEvent e) {
			JAjout.setVisible(false);
			JSupp.setVisible(false);
			JModif.setVisible(true);
	
		}
		
		}
		class MSuppAnneeListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JAjout.setVisible(false);
			
			JModif.setVisible(false);
			JSupp.setVisible(true);
			
		}
	}
}
		


