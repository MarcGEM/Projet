package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;

import controleur.*;
import model.*;
import net.proteanit.sql.DbUtils;
import vue.GEleve.BtMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GInscription extends JFrame{
    private InscriptionDAO inscription;
    private Connexion con;
    private JTable table;
    private JTextField textFieldId;
    private JTextField textFieldAnnee;
	private static int test;
	private JTextField textFieldPrenom;
    
    
    
	public GInscription(Connexion con) {
		super("Gestion Inscription");
		getContentPane().setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(840,651);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
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
		
		JLabel lblDetailbulletin = new JLabel("ID Classe");
		lblDetailbulletin.setBounds(21, 155, 130, 26);
		getContentPane().add(lblDetailbulletin);
		
		textFieldAnnee = new JTextField();
		textFieldAnnee.setBounds(131, 154, 146, 29);
		getContentPane().add(textFieldAnnee);
		textFieldAnnee.setColumns(10);
		
		JLabel lblInfos = new JLabel("INFOS");
		lblInfos.setBounds(109, 55, 92, 26);
		getContentPane().add(lblInfos);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ButtonAddListener());
		btnAdd.setBounds(18, 266, 133, 35);
		getContentPane().add(btnAdd);
		
		JButton btnModif = new JButton("Modifier");
		btnModif.setBounds(154, 266, 123, 35);
		btnModif.addActionListener(new BModifListenerAnnee());
		getContentPane().add(btnModif);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(421, 0, 115, 29);
		btnMenu.addActionListener(new BtMenu());
		panel.add(btnMenu);
		
		
		JButton btnSupp = new JButton("Supprimer");
		btnSupp.setBounds(81, 315, 141, 35);
		btnSupp.addActionListener(new BSuppIdListener());
		getContentPane().add(btnSupp);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 834, 600);
		getContentPane().add(lblFond);
		
		JLabel lblPrenom = new JLabel("ID Eleve");
		lblPrenom.setBounds(18, 209, 92, 26);
		getContentPane().add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(131, 203, 146, 32);
		getContentPane().add(textFieldPrenom);
		this.con=con;
		
		inscription= new InscriptionDAO(con);
		setResizable(false);
		
		
		
		this.setVisible(true);
	}
	
	//deplacer text dans case
	public void Deplace() {
		try {
			//on recupere la ligne selectionne
			int row =table.getSelectedRow();
			this.test=(int) (table.getModel().getValueAt(row, 0));
			Inscription a=inscription.find(test);
			
			textFieldId.setText(String.valueOf(a.getId()));
			textFieldAnnee.setText(String.valueOf(a.getClasse().getId()));
			textFieldPrenom.setText(String.valueOf(a.getEleve().getId()));

					
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
					String id = textFieldId.getText();
					Integer s=Integer.valueOf(id);
					String idclasse=textFieldAnnee.getText();
					Integer classe=Integer.valueOf(idclasse);
					String ideleve=textFieldPrenom.getText();
					Integer eleve=Integer.valueOf(ideleve);
					ClasseDAO c=new ClasseDAO(con);
					EleveDAO ele=new EleveDAO(con);
					
					Inscription a=new Inscription(s,c.find(classe),ele.find(eleve));
					inscription.create(a);
					
					
					}
				
			}
	
	
	//class pour repondre au boutton afficher
	class BtAfficherListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ResultSet rs =inscription.Ro();
			System.out.println("ok");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		
	}
	
	
	//class pour modifier
	class BModifListenerAnnee implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			String id = textFieldId.getText();
			Integer s=Integer.valueOf(id);
			String idclasse=textFieldAnnee.getText();
			Integer classe=Integer.valueOf(idclasse);
			String ideleve=textFieldPrenom.getText();
			Integer eleve=Integer.valueOf(ideleve);
			ClasseDAO c=new ClasseDAO(con);
			EleveDAO ele=new EleveDAO(con);
			
			Classe c1=c.find(classe);
			Eleve e1=ele.find(eleve);
			
			Inscription a=inscription.find(s);
			a.setClasse(c1);
			a.setEleve(e1);
			inscription.update(a);
			
			
		}
	}
	
	class BSuppIdListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String id = textFieldId.getText();
			Integer s=Integer.valueOf(id);
			Inscription a=inscription.find(s);
			inscription.delete(a);
			
		}
		
	}
	
	class BtMenu implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Acceuil a=new Acceuil();
			GInscription.this.setVisible(false);
		}
	}
	
	
}