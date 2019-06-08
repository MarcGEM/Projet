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

import controleur.*;
import model.*;
import net.proteanit.sql.DbUtils;
import vue.*;

public class GEnseignement extends JFrame {
	 private AnneescolaireDAO Annee;
	    private Connexion con;
	    private JTable table;
	    private JTextField textFieldId;
	    private JTextField textFieldIdClasse;
		private static int test;
	    private TrimestreDAO trimestre;
	    private JTable table_1;
	    private JOptionPane ta=new JOptionPane();
	    private JTextField textFieldIdDiscipline;
	    private JTextField textFieldIdProf;
	    private JTable table_2;
	    private JTable table_3;
	    
	    
	    
		public GEnseignement(Connexion con)  {
			super("Gestion Annee");
			setTitle("Gestion Enseignement");
			getContentPane().setForeground(Color.BLACK);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(840,651);
			//position au centre
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			
			trimestre = new TrimestreDAO(con);
			
			JPanel panel = new JPanel();
			panel.setBounds(298, 0, 536, 217);
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
			textFieldId.setBounds(149, 99, 146, 32);
			getContentPane().add(textFieldId);
			textFieldId.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("ID  Classe");
			lblNewLabel_1.setBounds(21, 155, 109, 26);
			getContentPane().add(lblNewLabel_1);
			
			textFieldIdClasse = new JTextField();
			textFieldIdClasse.setBounds(149, 152, 146, 32);
			getContentPane().add(textFieldIdClasse);
			textFieldIdClasse.setColumns(10);
			
			JLabel lblInfos = new JLabel("INFOS");
			lblInfos.setBounds(109, 55, 92, 26);
			getContentPane().add(lblInfos);
			
			JButton btnAdd = new JButton("Ajouter");

			btnAdd.addActionListener(new ButtonAddListener());
			btnAdd.setBounds(18, 365, 133, 35);
			getContentPane().add(btnAdd);
			
			JButton btnModif = new JButton("Modifier");
			btnModif.setBounds(172, 365, 123, 35);
			btnModif.addActionListener(new BModifListener());
			getContentPane().add(btnModif);
			
			JButton btnSupp = new JButton("Supprimer");
			btnSupp.setBounds(96, 421, 141, 35);
			//btnSupp.addActionListener(new BSuppIdListener());
			getContentPane().add(btnSupp);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(316, 248, 222, 152);
			getContentPane().add(scrollPane_1);
			
			table_1 = new JTable();
			scrollPane_1.setViewportView(table_1);
			
			Label label_1 = new Label("Classe");
			label_1.setBounds(361, 216, 104, 26);
			getContentPane().add(label_1);
			
			JLabel lblNewLabel_2 = new JLabel("ID Discipline");
			lblNewLabel_2.setBounds(18, 205, 123, 26);
			getContentPane().add(lblNewLabel_2);
			
			textFieldIdDiscipline = new JTextField();
			textFieldIdDiscipline.setColumns(10);
			textFieldIdDiscipline.setBounds(149, 205, 146, 32);
			getContentPane().add(textFieldIdDiscipline);
			
			JLabel lblNewLabel_3 = new JLabel("ID Prof");
			lblNewLabel_3.setBounds(18, 263, 92, 26);
			getContentPane().add(lblNewLabel_3);
			
			textFieldIdProf = new JTextField();
			textFieldIdProf.setBounds(149, 258, 146, 32);
			getContentPane().add(textFieldIdProf);
			textFieldIdProf.setColumns(10);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(578, 248, 235, 152);
			getContentPane().add(scrollPane_2);
			
			table_2 = new JTable();
			scrollPane_2.setViewportView(table_2);
			
			JLabel lblNewLabel_4 = new JLabel("Discipline");
			lblNewLabel_4.setBounds(643, 216, 92, 26);
			getContentPane().add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Prof");
			lblNewLabel_5.setBounds(489, 408, 92, 26);
			getContentPane().add(lblNewLabel_5);
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(407, 437, 222, 152);
			getContentPane().add(scrollPane_3);
			
			table_3 = new JTable();
			scrollPane_3.setViewportView(table_3);
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
						EnseignementDAO EnseignementDAO= new EnseignementDAO(con);
						Enseignement e = EnseignementDAO.find(test);
						
						
						textFieldId.setText(String.valueOf(e.getId()));
						textFieldIdClasse.setText(String.valueOf(e.getClasse().getId()));
						textFieldIdDiscipline.setText(String.valueOf(e.getDiscipline().getId()));
						textFieldIdProf.setText(String.valueOf(e.getProf().getId()));
				
								
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
						EnseignementDAO classe = new EnseignementDAO(con);
						
						ResultSet rs =classe.Ro();
						table.setModel(DbUtils.resultSetToTableModel(rs));	
						ClasseDAO classe1 = new ClasseDAO(con);
						ResultSet rs1 =classe1.Ro();
						table_1.setModel(DbUtils.resultSetToTableModel(rs1));
						DisciplineDAO discipline1 = new DisciplineDAO(con);
						ResultSet rs2 = discipline1.Ro();
						table_2.setModel(DbUtils.resultSetToTableModel(rs2));
						ProfDAO prof1=new ProfDAO(con);
						ResultSet rs3 = prof1.Ro();
						table_3.setModel(DbUtils.resultSetToTableModel(rs3));
						
						
					}
					
				}
		
				//methode qui ecoutera le button add
			class ButtonAddListener implements ActionListener{
							
						public void actionPerformed(ActionEvent e) {
							//recuperatio des donnes
							try {
							
							Classe c=new Classe();
							Discipline d = new Discipline();
							Prof p= new Prof();		
							
							String id = textFieldId.getText();
							Integer s=Integer.valueOf(id);
							String idClasse=textFieldIdClasse.getText();
							String idDiscipline=textFieldIdDiscipline.getText();
							String idProf=textFieldIdProf.getText();
							
								
								ClasseDAO classe1 = new ClasseDAO(con);
								DisciplineDAO discipline1= new DisciplineDAO(con);
								ProfDAO prof1= new ProfDAO(con);
								
								//recherche l'annee coresspondante
								try {
								 c=classe1.find(Integer.valueOf(idClasse));
								 d=discipline1.find(Integer.valueOf(idDiscipline));
								 p=prof1.find(Integer.valueOf(idProf));
								 }catch(Exception u) {
									ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une annee existane","Erreur",ta.WARNING_MESSAGE);	
								 }
							
								EnseignementDAO enseignementDAO = new EnseignementDAO(con);
								Enseignement enseignement = new Enseignement(s,c,p,d);
								enseignementDAO.create(enseignement);
							
							 
								
								
							}catch(Exception to) {

										ta.showMessageDialog(ta, "Erreur veuillez ressayer ou remplir tous les champs","Erreur",ta.WARNING_MESSAGE);
									}
								
								
								
								}
							
						}
				
				//class pour modifier
		class BModifListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//recuperatio des donnes
				try {
				
				Classe c=new Classe();
				Discipline d = new Discipline();
				Prof p= new Prof();		
				
				String id = textFieldId.getText();
				Integer s=Integer.valueOf(id);
				String idClasse=textFieldIdClasse.getText();
				String idDiscipline=textFieldIdDiscipline.getText();
				String idProf=textFieldIdProf.getText();
				
					
					ClasseDAO classe1 = new ClasseDAO(con);
					DisciplineDAO discipline1= new DisciplineDAO(con);
					ProfDAO prof1= new ProfDAO(con);
					
					//recherche l'annee coresspondante
					try {
					 c=classe1.find(Integer.valueOf(idClasse));
					 d=discipline1.find(Integer.valueOf(idDiscipline));
					 p=prof1.find(Integer.valueOf(idProf));
					 }catch(Exception u) {
						ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une classe,discipline,prof existant","Erreur",ta.WARNING_MESSAGE);	
					 }
				
					EnseignementDAO enseignementDAO = new EnseignementDAO(con);
					Enseignement enseignement = new Enseignement(s,c,p,d);
					enseignementDAO.update(enseignement);
				
				 
					
					
				}catch(Exception to) {

							ta.showMessageDialog(ta, "Erreur veuillez ressayer ou remplir tous les champs","Erreur",ta.WARNING_MESSAGE);
						}
					
					
					
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
