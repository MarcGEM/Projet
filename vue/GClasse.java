package vue;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import controleur.AnneescolaireDAO;
import controleur.ClasseDAO;
import controleur.NiveauDAO;
import controleur.TrimestreDAO;
import model.Anneescolaire;
import model.Classe;
import model.Connexion;
import model.Niveau;
import model.Trimestre;
import net.proteanit.sql.DbUtils;
import vue.GTrimestre.BModifListenerAnnee;
import vue.GTrimestre.BSuppIdListener;
import vue.GTrimestre.BtAfficherListener;
import vue.GTrimestre.ButtonAddListener;
import vue.GTrimestre.MouseAdapter;

public class GClasse extends JFrame {
	 private AnneescolaireDAO Annee;
	    private Connexion con;
	    private JTable table;
	    private JTextField textFieldId;
	    private JTextField textFieldNom;
		private static int test;
	    private TrimestreDAO trimestre;
	    private JTable table_1;
	    private JOptionPane ta=new JOptionPane();
	    private JTextField textFieldIdNiveau;
	    private JTextField textFieldIdAnnee;
	    private JTable table_2;
	    
	    
	    
		public GClasse(Connexion con)  {
			super("Gestion Annee");
			setTitle("Gestion Classe");
			getContentPane().setForeground(Color.BLACK);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(840,651);
			//position au centre
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			
			trimestre = new TrimestreDAO(con);
			
			JPanel panel = new JPanel();
			panel.setBounds(298, 0, 536, 263);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 62, 484, 138);
			panel.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() );
			scrollPane.setViewportView(table);
			
			JButton btnAfficher = new JButton("Afficher");
			btnAfficher.setBounds(198, 21, 141, 35);
			btnAfficher.addActionListener(new BtAfficherListener());
			panel.add(btnAfficher);
			
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(18, 102, 92, 26);
			getContentPane().add(lblNewLabel);
			
			textFieldId = new JTextField();
			textFieldId.setBounds(131, 99, 146, 32);
			getContentPane().add(textFieldId);
			textFieldId.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nom");
			lblNewLabel_1.setBounds(21, 155, 92, 26);
			getContentPane().add(lblNewLabel_1);
			
			textFieldNom = new JTextField();
			textFieldNom.setBounds(131, 152, 146, 32);
			getContentPane().add(textFieldNom);
			textFieldNom.setColumns(10);
			
			JLabel lblInfos = new JLabel("INFOS");
			lblInfos.setBounds(109, 55, 92, 26);
			getContentPane().add(lblInfos);
			
			JButton btnAdd = new JButton("Ajouter");

			btnAdd.addActionListener(new ButtonAddListener());
			btnAdd.setBounds(18, 365, 133, 35);
			getContentPane().add(btnAdd);
			
			JButton btnModif = new JButton("Modifier");
			btnModif.setBounds(172, 365, 123, 35);
			btnModif.addActionListener(new BModifListenerClasse());
			getContentPane().add(btnModif);
			
			JButton btnSupp = new JButton("Supprimer");
			btnSupp.setBounds(96, 421, 141, 35);
			btnSupp.addActionListener(new BSuppIdListener());
			getContentPane().add(btnSupp);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(333, 328, 222, 152);
			getContentPane().add(scrollPane_1);
			
			table_1 = new JTable();
			scrollPane_1.setViewportView(table_1);
			
			Label label_1 = new Label("Annee");
			label_1.setBounds(396, 290, 104, 33);
			getContentPane().add(label_1);
			
			JLabel lblNewLabel_2 = new JLabel("ID Niveau");
			lblNewLabel_2.setBounds(18, 205, 92, 26);
			getContentPane().add(lblNewLabel_2);
			
			textFieldIdNiveau = new JTextField();
			textFieldIdNiveau.setColumns(10);
			textFieldIdNiveau.setBounds(131, 205, 146, 32);
			getContentPane().add(textFieldIdNiveau);
			
			JLabel lblNewLabel_3 = new JLabel("ID Annee");
			lblNewLabel_3.setBounds(18, 263, 92, 26);
			getContentPane().add(lblNewLabel_3);
			
			textFieldIdAnnee = new JTextField();
			textFieldIdAnnee.setBounds(131, 258, 146, 32);
			getContentPane().add(textFieldIdAnnee);
			textFieldIdAnnee.setColumns(10);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(578, 328, 235, 152);
			getContentPane().add(scrollPane_2);
			
			table_2 = new JTable();
			scrollPane_2.setViewportView(table_2);
			
			JLabel lblNewLabel_4 = new JLabel("Niveau");
			lblNewLabel_4.setBounds(644, 290, 92, 26);
			getContentPane().add(lblNewLabel_4);
			this.con=con;
			
			Annee= new AnneescolaireDAO(con);
			ArrayList<Anneescolaire> c=Annee.seeAll();
			String title[]= {"Id","Annee"};
			setResizable(false);
			//oupsi
			
			
			this.setVisible(true);
	
		}
	
		//deplacer text dans case
				public void Deplace() {
					try {
						//on recupere la ligne selectionne
						int row =table.getSelectedRow();
						this.test=(int) (table.getModel().getValueAt(row, 0));
						ClasseDAO ClasseDAO= new ClasseDAO(con);
						Classe c = ClasseDAO.find(test);
						
						
						textFieldId.setText(String.valueOf(c.getId()));
						textFieldNom.setText(String.valueOf(c.getNom()));
						textFieldIdNiveau.setText(String.valueOf(c.getNiveau().getId()));
						textFieldIdAnnee.setText(String.valueOf(c.getAnneescolaire().getId()));
				
								
					}catch(Exception e) {
						e.getMessage();
					}
					
				}
				
				//class pour repondre au clic de la souris
				class MouseAdapter implements MouseListener{

					@Override
					public void mouseClicked(MouseEvent e) {
						Deplace();
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				}
				
				class BtAfficherListener implements ActionListener {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ClasseDAO classe = new ClasseDAO(con);
						
						ResultSet rs =classe.Ro();
						table.setModel(DbUtils.resultSetToTableModel(rs));	
						AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
						ResultSet rs1 =annee1.Ro();
						table_1.setModel(DbUtils.resultSetToTableModel(rs1));
						NiveauDAO niveau = new NiveauDAO(con);
						ResultSet rs2 = niveau.Ro();
						table_2.setModel(DbUtils.resultSetToTableModel(rs2));
						
						
					}
					
				}
		
				//methode qui ecoutera le button add
				class ButtonAddListener implements ActionListener{
							
						public void actionPerformed(ActionEvent e) {
							//recuperatio des donnes
							try {
							
							Anneescolaire a=new Anneescolaire();
							Niveau n= new Niveau();
							
							String id = textFieldId.getText();
							Integer s=Integer.valueOf(id);
							String Nom=textFieldNom.getText();
							String idNiveau=textFieldIdNiveau.getText();
							String idAnnee=textFieldIdAnnee.getText();
							
								
								AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
								NiveauDAO niveau1= new NiveauDAO(con);
								//recherche l'annee coresspondante
								try {
								 a=annee1.find(Integer.valueOf(idAnnee));
								 n=niveau1.find(Integer.valueOf(idNiveau));
								 }catch(Exception u) {
									ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une annee existane","Erreur",ta.WARNING_MESSAGE);	
								 }
							
								ClasseDAO classeDAO = new ClasseDAO(con);
								Classe classe = new Classe(s,Nom,n,a);
								classeDAO.create(classe);
							
							 
								
								
							}catch(Exception to) {

										ta.showMessageDialog(ta, "Erreur veuillez ressayer ou remplir tous les champs","Erreur",ta.WARNING_MESSAGE);
									}
								
								
								
								}
							
						}
				
				//class pour modifier
		class BModifListenerClasse implements ActionListener {

					
					public void actionPerformed(ActionEvent e) {
						
					
						Anneescolaire a=new Anneescolaire();
						Niveau n= new Niveau();
						String id = textFieldId.getText();
						Integer s=Integer.valueOf(id);
						String Nom=textFieldNom.getText();
						//Integer v=Integer.valueOf(idAnnee);
						String idNiveau=textFieldIdNiveau.getText();
						String idAnnee=textFieldIdAnnee.getText();
						
						
						

						AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
						NiveauDAO niveau1= new NiveauDAO(con);
						//recherche l'annee coresspondante
						try {
						 a=annee1.find(Integer.valueOf(idAnnee));
						 n=niveau1.find(Integer.valueOf(idNiveau));
						 }catch(Exception u) {
							ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une annee existane","Erreur",ta.WARNING_MESSAGE);	
						 }
					
						ClasseDAO classeDAO = new ClasseDAO(con);
						Classe classe = new Classe(s,Nom,n,a);
						classeDAO.update(classe);
					
						
					}
				}
		
		class BSuppIdListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				String id = textFieldId.getText();
				Integer s=Integer.valueOf(id);
				ClasseDAO classeDAO= new ClasseDAO(con);
				Classe classe = classeDAO.find(s);
				
				classeDAO.delete(classe);
				

			}
			
		}
		
}
