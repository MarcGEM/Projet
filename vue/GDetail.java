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
import vue.GClasse.BtMenu;

public class GDetail extends JFrame {
	 private AnneescolaireDAO Annee;
	    private Connexion con;
	    private JTable table;
	    private JTextField textFieldId;
	    private JTextField textFieldIdTrimestre;
		private static int test;
		private BulletinDAO b;
		private EnseignementDAO i;
	    private JTable table_1;
	    private JOptionPane ta=new JOptionPane();
	    private JTextField textFieldIdInscription;
	    private JTextField textFieldAppreciation;
	    private JTable table_2;
	    
	    
	    
		public GDetail(Connexion con)  {
			getContentPane().setBackground(new Color(245, 222, 179));
			setTitle("Gestion Detail");
			getContentPane().setForeground(Color.BLACK);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(840,651);
			//position au centre
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			
			b = new BulletinDAO(con);
			i=new EnseignementDAO(con);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(245, 222, 179));
			panel.setForeground(new Color(176, 224, 230));
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
			textFieldId.setBackground(new Color(253, 245, 230));
			textFieldId.setBounds(160, 99, 146, 32);
			getContentPane().add(textFieldId);
			textFieldId.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("ID Bulletin");
			lblNewLabel_1.setBounds(21, 155, 130, 26);
			getContentPane().add(lblNewLabel_1);
			
			textFieldIdTrimestre = new JTextField();
			textFieldIdTrimestre.setBackground(new Color(253, 245, 230));
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
			btnSupp.addActionListener(new BSuppIdListener());
			getContentPane().add(btnSupp);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(348, 248, 424, 152);
			getContentPane().add(scrollPane_1);
			
			table_1 = new JTable();
			scrollPane_1.setViewportView(table_1);
			
			Label label_1 = new Label("Bulletin");
			label_1.setBounds(481, 216, 104, 26);
			getContentPane().add(label_1);
			
			JLabel lblNewLabel_2 = new JLabel("ID Enseignement");
			lblNewLabel_2.setBounds(18, 205, 133, 26);
			getContentPane().add(lblNewLabel_2);
			
			textFieldIdInscription = new JTextField();
			textFieldIdInscription.setBackground(new Color(253, 245, 230));
			textFieldIdInscription.setColumns(10);
			textFieldIdInscription.setBounds(160, 205, 146, 32);
			getContentPane().add(textFieldIdInscription);
			
			JLabel lblNewLabel_3 = new JLabel("Appreciation");
			lblNewLabel_3.setBounds(18, 263, 121, 26);
			getContentPane().add(lblNewLabel_3);
			
			JButton btnMenu = new JButton("Menu");
			btnMenu.setBounds(421, 0, 115, 29);
			btnMenu.addActionListener(new BtMenu());
			panel.add(btnMenu);
			
			textFieldAppreciation = new JTextField();
			textFieldAppreciation.setBackground(new Color(253, 245, 230));
			textFieldAppreciation.setBounds(160, 260, 146, 32);
			getContentPane().add(textFieldAppreciation);
			textFieldAppreciation.setColumns(10);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(346, 430, 394, 152);
			getContentPane().add(scrollPane_2);
			
			table_2 = new JTable();
			scrollPane_2.setViewportView(table_2);
			
			JLabel lblNewLabel_4 = new JLabel("Enseignement");
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
						DetailbulletinDAO bulletinDAO= new DetailbulletinDAO(con);
						Detailbulletin b = bulletinDAO.find(test);
						
						
						textFieldId.setText(String.valueOf(b.getId()));
						textFieldIdTrimestre.setText(String.valueOf(b.getBulletin().getId()));
						textFieldIdInscription.setText(String.valueOf(b.getEnseignement().getId()));
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
						DetailbulletinDAO bulletin = new DetailbulletinDAO(con);
						
						ResultSet rs =bulletin.Ro();
						table.setModel(DbUtils.resultSetToTableModel(rs));	
						
						ResultSet rs1 =b.Ro();
						table_1.setModel(DbUtils.resultSetToTableModel(rs1));
						
						ResultSet rs2 = i.Ro();
						table_2.setModel(DbUtils.resultSetToTableModel(rs2));
						
						
						
					}
					
				}
		
				//methode qui ecoutera le button add
			class ButtonAddListener implements ActionListener{
							
						public void actionPerformed(ActionEvent e) {
							//recuperatio des donnes
							try {
							
							Bulletin t=new Bulletin();
							Enseignement en=new Enseignement();	
							
							String id = textFieldId.getText();
							Integer s=Integer.valueOf(id);
							String idTrimestre=textFieldIdTrimestre.getText();
							String idInscription=textFieldIdInscription.getText();
							String Appreciation=textFieldAppreciation.getText();
							
								
								
								
								
								//recherche l'annee coresspondante
								try {
								  t=b.find(Integer.valueOf(idTrimestre));
								  en=i.find(Integer.valueOf(idInscription));
								 }catch(Exception u) {
									ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une annee existane","Erreur",ta.WARNING_MESSAGE);	
								 }
							
								DetailbulletinDAO bulletinDAO = new DetailbulletinDAO(con);
								Detailbulletin bulletin = new Detailbulletin(s,t,en,Appreciation);
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
				
					Bulletin t=new Bulletin();
					Enseignement en=new Enseignement();	
					
				
				String id = textFieldId.getText();
				Integer s=Integer.valueOf(id);
				String idTrimestre=textFieldIdTrimestre.getText();
				String idInscription=textFieldIdInscription.getText();
				String Appreciation=textFieldAppreciation.getText();
				
					
					TrimestreDAO trimestre1 = new TrimestreDAO(con);
					InscriptionDAO inscription1= new InscriptionDAO(con);
					
					
					//recherche l'annee coresspondante
					try {
						t=b.find(Integer.valueOf(idTrimestre));
						  en=i.find(Integer.valueOf(idInscription));
					 }catch(Exception u) {
						ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une annee existane","Erreur",ta.WARNING_MESSAGE);	
					 }
				
					DetailbulletinDAO b1=new DetailbulletinDAO(con);
					Detailbulletin bulletin = b1.find(s);
					
					bulletin.setAppreciation(Appreciation);
							
							
							
					b1.update(bulletin);
				
				 
					
					
				}catch(Exception to) {

							ta.showMessageDialog(ta, "Erreur veuillez ressayer ou remplir tous les champs","Erreur",ta.WARNING_MESSAGE);
						}
					
				
					
					}
				
					
					
				}
		
		class BSuppIdListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				String id = textFieldId.getText();
				Integer s=Integer.valueOf(id);
				DetailbulletinDAO bulletinDAO= new DetailbulletinDAO(con);
				Detailbulletin bulletin = bulletinDAO.find(s);
				bulletinDAO.delete(bulletin);
				
				

			}
			
		}
		class BtMenu implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Acceuil a=new Acceuil();
				GDetail.this.setVisible(false);
			}
		}
		
}

