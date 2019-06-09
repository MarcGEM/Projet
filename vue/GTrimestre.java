package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;

import controleur.AnneescolaireDAO;
import controleur.TrimestreDAO;
import model.Anneescolaire;
import model.Connexion;
import model.Trimestre;
import net.proteanit.sql.DbUtils;
import vue.GAnnee.BtMenu;

import com.toedter.calendar.JDateChooser;
import java.util.*;

public class GTrimestre extends JFrame {

	  private AnneescolaireDAO Annee;
	    private Connexion con;
	    private JTable table;
	    private JTextField textFieldId;
	    private JTextField textFieldAnnee;
		private static int test;
		private JTextField textFieldNumero;
	    private TrimestreDAO trimestre;
	    private JDateChooser dateChooserFin;
	    private JDateChooser dateChooserDebut;
	    private JTable table_1;
	    private JOptionPane ta=new JOptionPane();
	    
	    
	    
		public GTrimestre(Connexion con)  {
			super("Gestion Annee");
			getContentPane().setBackground(new Color(245, 222, 179));
			setTitle("Gestion Trimestre");
			getContentPane().setForeground(Color.BLACK);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(840,651);
			//position au centre
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			
			trimestre = new TrimestreDAO(con);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(245, 222, 179));
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
			
			JButton btnMenu = new JButton("Menu");
			btnMenu.setBounds(421, 0, 115, 29);
			btnMenu.addActionListener(new BtMenu());
			panel.add(btnMenu);
			
			
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(18, 102, 92, 26);
			getContentPane().add(lblNewLabel);
			
			textFieldId = new JTextField();
			textFieldId.setBackground(new Color(253, 245, 230));
			textFieldId.setBounds(131, 99, 146, 32);
			getContentPane().add(textFieldId);
			textFieldId.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Id Annee");
			lblNewLabel_1.setBounds(21, 155, 92, 26);
			getContentPane().add(lblNewLabel_1);
			
			textFieldAnnee = new JTextField();
			textFieldAnnee.setBackground(new Color(253, 245, 230));
			textFieldAnnee.setBounds(131, 152, 146, 32);
			getContentPane().add(textFieldAnnee);
			textFieldAnnee.setColumns(10);
			
			JLabel lblInfos = new JLabel("INFOS");
			lblInfos.setBounds(109, 55, 92, 26);
			getContentPane().add(lblInfos);
			
			JButton btnAdd = new JButton("Ajouter");

			btnAdd.addActionListener(new ButtonAddListener());
			btnAdd.setBounds(18, 417, 133, 35);
			getContentPane().add(btnAdd);
			
			JButton btnModif = new JButton("Modifier");
			btnModif.setBounds(179, 417, 123, 35);
			btnModif.addActionListener(new BModifListenerAnnee());
			getContentPane().add(btnModif);
			
			JButton btnSupp = new JButton("Supprimer");
			btnSupp.setBounds(97, 492, 141, 35);
			btnSupp.addActionListener(new BSuppIdListener());
			getContentPane().add(btnSupp);
			
			JLabel lblNewLabel_2 = new JLabel("Debut");
			lblNewLabel_2.setBounds(18, 213, 92, 26);
			getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Fin");
			lblNewLabel_3.setBounds(18, 271, 92, 26);
			getContentPane().add(lblNewLabel_3);
			
			dateChooserDebut = new JDateChooser();
			dateChooserDebut.setBackground(new Color(253, 245, 230));
			dateChooserDebut.setDateFormatString(" yyyy-MM-dd");
			dateChooserDebut.setBounds(130, 207, 155, 32);
	
			getContentPane().add(dateChooserDebut);
			
			 dateChooserFin = new JDateChooser();
			dateChooserFin.setDateFormatString(" yyyy-MM-dd");
			dateChooserFin.setBounds(131, 265, 155, 32);
			getContentPane().add(dateChooserFin);
			
			Label label = new Label("Numero");
			label.setBounds(18, 328, 104, 33);
			getContentPane().add(label);
			
			textFieldNumero = new JTextField();
			textFieldNumero.setBackground(new Color(253, 245, 230));
			textFieldNumero.setBounds(128, 328, 157, 32);
			getContentPane().add(textFieldNumero);
			textFieldNumero.setColumns(10);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(472, 328, 245, 152);
			getContentPane().add(scrollPane_1);
			
			table_1 = new JTable();
			scrollPane_1.setViewportView(table_1);
			
			Label label_1 = new Label("Annee");
			label_1.setBounds(533, 289, 104, 33);
			getContentPane().add(label_1);
			this.con=con;
			
			
			
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
				TrimestreDAO trimestreDAO= new TrimestreDAO(con);
				Trimestre t = trimestreDAO.find(test);
				
				
				textFieldId.setText(String.valueOf(t.getId()));
				textFieldAnnee.setText(String.valueOf(t.getAnneescolaire().getId()));
				 
				//conversion des date
				Date dateDebut = new SimpleDateFormat("yyyy-MM-dd").parse(t.getDebut());
				dateChooserDebut.setDate(dateDebut);
				
				Date dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(t.getFin());
				dateChooserFin.setDate(dateFin);
				
				textFieldNumero.setText(String.valueOf(t.getNumero()));
				
				
				
						
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
		
		
		//methode qui ecoutera le button add
		class ButtonAddListener implements ActionListener{
					
				public void actionPerformed(ActionEvent e) {
					//recuperatio des donnes
					try {
					SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
					Anneescolaire a=new Anneescolaire();
					String id = textFieldId.getText();
					Integer s=Integer.valueOf(id);
					String idAnnee=textFieldAnnee.getText();
					Integer v=Integer.valueOf(idAnnee);
						
						Date date = dateChooserDebut.getDate();
						
						String dateDebut=formater.format(date);
						
						Date date1 = dateChooserFin.getDate();
						String dateFin=formater.format(date1);
						
						String numero = textFieldNumero.getText();
						Integer c=Integer.valueOf(numero);
						
						AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
						//recherche l'annee coresspondante
						try {
						 a=annee1.find(v);
						 }catch(Exception u) {
							ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une annee existane","Erreur",ta.WARNING_MESSAGE);	
						 }
					Trimestre trimestre = new Trimestre(s,c,dateDebut,dateFin,a);
					TrimestreDAO trimestreDAO= new TrimestreDAO(con);
					
						
					trimestreDAO.create(trimestre);
					 
						
						
					}catch(Exception to) {

								ta.showMessageDialog(ta, "Erreur veuillez ressayer ou remplir tous les champs","Erreur",ta.WARNING_MESSAGE);
							}
						
						
						
						}
					
				}
		
		
		//class pour repondre au boutton afficher
		class BtAfficherListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs =trimestre.Ro();
				table.setModel(DbUtils.resultSetToTableModel(rs));	
				AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
				ResultSet rs1 =annee1.Ro();
				table_1.setModel(DbUtils.resultSetToTableModel(rs1));
				
			}
			
		}
		
		
		//class pour modifier
		class BModifListenerAnnee implements ActionListener {

			
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
				Anneescolaire a=new Anneescolaire();
				String id = textFieldId.getText();
				Integer s=Integer.valueOf(id);
				String idAnnee=textFieldAnnee.getText();
				Integer v=Integer.valueOf(idAnnee);
				Date date = dateChooserDebut.getDate();
				String dateDebut=formater.format(date);
				
				Date date1 = dateChooserFin.getDate();
				String dateFin=formater.format(date1);
				
				String numero = textFieldNumero.getText();
				Integer c=Integer.valueOf(numero);

				AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
				//recherche l'annee coresspondante
				try {
				 a=annee1.find(v);
				 }catch(Exception u) {
					ta.showMessageDialog(ta, "Erreur veuillez creer ou utiliser une annee existane","Erreur",ta.WARNING_MESSAGE);	
				 }
				
				Trimestre trimestre = new Trimestre(s,c,dateDebut,dateFin,a);
				TrimestreDAO trimestreDAO= new TrimestreDAO(con);
				trimestreDAO.update(trimestre);
				
		
			}
		}
		
		class BSuppIdListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				String id = textFieldId.getText();
				Integer s=Integer.valueOf(id);
				TrimestreDAO trimestreDAO= new TrimestreDAO(con);
				Trimestre trimestre = trimestreDAO.find(s);
				
				trimestreDAO.delete(trimestre);
				

			}
			
		}
		
		class BtMenu implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Acceuil a=new Acceuil();
				GTrimestre.this.setVisible(false);
			}
		}
}
