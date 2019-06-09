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

public class GBulletin extends JFrame {
	 private AnneescolaireDAO Annee;
	    private Connexion con;
	    private JTable table;
	    private JTextField textFieldId;
	    private JTextField textFieldIdTrimestre;
		private static int test;
	    private TrimestreDAO trimestre;
	    private JTable table_1;
	    private JOptionPane ta=new JOptionPane();
	    private JTextField textFieldIdInscription;
	    private JTextField textFieldAppreciation;
	    private JTable table_2;
	    
	    
	    
		public GBulletin(Connexion con)  {
			super("Gestion Annee");
			setTitle("Gestion Bulletin");
			getContentPane().setForeground(Color.BLACK);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(840,651);
			//position au centre
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			
			trimestre = new TrimestreDAO(con);
			
			JPanel panel = new JPanel();
			panel.setBounds(316, 0, 518, 217);
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
			textFieldId.setBounds(160, 99, 146, 32);
			getContentPane().add(textFieldId);
			textFieldId.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("ID Trimestre");
			lblNewLabel_1.setBounds(21, 155, 130, 26);
			getContentPane().add(lblNewLabel_1);
			
			textFieldIdTrimestre = new JTextField();
			textFieldIdTrimestre.setBounds(160, 152, 146, 32);
			getContentPane().add(textFieldIdTrimestre);
			textFieldIdTrimestre.setColumns(10);
			
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
			scrollPane_1.setBounds(348, 248, 424, 152);
			getContentPane().add(scrollPane_1);
			
			table_1 = new JTable();
			scrollPane_1.setViewportView(table_1);
			
			Label label_1 = new Label("Trimestre");
			label_1.setBounds(481, 216, 104, 26);
			getContentPane().add(label_1);
			
			JLabel lblNewLabel_2 = new JLabel("ID Inscription");
			lblNewLabel_2.setBounds(18, 205, 133, 26);
			getContentPane().add(lblNewLabel_2);
			
			textFieldIdInscription = new JTextField();
			textFieldIdInscription.setColumns(10);
			textFieldIdInscription.setBounds(160, 205, 146, 32);
			getContentPane().add(textFieldIdInscription);
			
			JLabel lblNewLabel_3 = new JLabel("Appreciation");
			lblNewLabel_3.setBounds(18, 263, 121, 26);
			getContentPane().add(lblNewLabel_3);
			
			textFieldAppreciation = new JTextField();
			textFieldAppreciation.setBounds(160, 260, 146, 32);
			getContentPane().add(textFieldAppreciation);
			textFieldAppreciation.setColumns(10);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(346, 430, 394, 152);
			getContentPane().add(scrollPane_2);
			
			table_2 = new JTable();
			scrollPane_2.setViewportView(table_2);
			
			JLabel lblNewLabel_4 = new JLabel("Inscription");
			lblNewLabel_4.setBounds(490, 402, 121, 26);
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
						BulletinDAO bulletinDAO= new BulletinDAO(con);
						Bulletin b = bulletinDAO.find(test);
						
						
						textFieldId.setText(String.valueOf(b.getId()));
						textFieldIdTrimestre.setText(String.valueOf(b.getTrimestre().getId()));
						textFieldIdInscription.setText(String.valueOf(b.getInscription().getId()));
						textFieldAppreciation.setText(b.getAppreciation());
				
								
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
						BulletinDAO bulletin = new BulletinDAO(con);
						
						ResultSet rs =bulletin.Ro();
						table.setModel(DbUtils.resultSetToTableModel(rs));	
						TrimestreDAO trimestre1 = new TrimestreDAO(con);
						ResultSet rs1 =trimestre1.Ro();
						table_1.setModel(DbUtils.resultSetToTableModel(rs1));
						InscriptionDAO inscription1 = new InscriptionDAO(con);
						ResultSet rs2 = inscription1.Ro();
						table_2.setModel(DbUtils.resultSetToTableModel(rs2));
						
						
						
					}
					
				}
		
				//methode qui ecoutera le button add
			class ButtonAddListener implements ActionListener{
							
						public void actionPerformed(ActionEvent e) {
							//recuperatio des donnes
							try {
							
							Trimestre t=new Trimestre();
							Inscription i = new Inscription();
								
							
							String id = textFieldId.getText();
							Integer s=Integer.valueOf(id);
							String idTrimestre=textFieldIdTrimestre.getText();
							String idInscription=textFieldIdInscription.getText();
							String Appreciation=textFieldAppreciation.getText();
							
								
								TrimestreDAO trimestre1 = new TrimestreDAO(con);
								InscriptionDAO inscription1= new InscriptionDAO(con);
								
								
								//recherche l'annee coresspondante
								try {
								 t=trimestre1.find(Integer.valueOf(idTrimestre));
								 i=inscription1.find(Integer.valueOf(idInscription));
								 }catch(Exception u) {
									ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une annee existane","Erreur",ta.WARNING_MESSAGE);	
								 }
							
								BulletinDAO bulletinDAO = new BulletinDAO(con);
								Bulletin bulletin = new Bulletin(s,t,i,Appreciation);
								bulletinDAO.create(bulletin);
							
							 
								
								
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
				
				Trimestre t=new Trimestre();
				Inscription i = new Inscription();
					
				
				String id = textFieldId.getText();
				Integer s=Integer.valueOf(id);
				String idTrimestre=textFieldIdTrimestre.getText();
				String idInscription=textFieldIdInscription.getText();
				String Appreciation=textFieldAppreciation.getText();
				
					
					TrimestreDAO trimestre1 = new TrimestreDAO(con);
					InscriptionDAO inscription1= new InscriptionDAO(con);
					
					
					//recherche l'annee coresspondante
					try {
					 t=trimestre1.find(Integer.valueOf(idTrimestre));
					 i=inscription1.find(Integer.valueOf(idInscription));
					 }catch(Exception u) {
						ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une annee existane","Erreur",ta.WARNING_MESSAGE);	
					 }
				
					BulletinDAO bulletinDAO = new BulletinDAO(con);
					//Bulletin bulletin = bulletinnDAO.find()
					bulletinDAO.update(bulletin);
				
				 
					
					
				}catch(Exception to) {

							ta.showMessageDialog(ta, "Erreur veuillez ressayer ou remplir tous les champs","Erreur",ta.WARNING_MESSAGE);
						}
					
				
					
					}
				
					
					
				}
		
		class BSuppIdListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				String id = textFieldId.getText();
				Integer s=Integer.valueOf(id);
				BulletinDAO bulletinDAO= new BulletinDAO(con);
				Bulletin bulletin = bulletinDAO.find(s);
				
				
				

			}
			
		}
		
}
