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
import vue.GProf.BtMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GEleve extends JFrame{
    private EleveDAO eleve;
    private Connexion con;
    private JTable table;
    private JTextField textFieldId;
    private JTextField textFieldAnnee;
	private static int test;
	private JTextField textFieldPrenom;
    
    
    
	public GEleve(Connexion con) {
		super("Gestion Eleve");
		getContentPane().setForeground(new Color(245, 222, 179));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(840,651);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
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
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(18, 102, 92, 26);
		getContentPane().add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setBackground(new Color(253, 245, 230));
		textFieldId.setBounds(131, 99, 146, 32);
		getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
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
		btnAdd.setBounds(12, 257, 133, 35);
		getContentPane().add(btnAdd);
		
		JButton btnModif = new JButton("Modifier");
		btnModif.setBounds(160, 257, 123, 35);
		btnModif.addActionListener(new BModifListenerAnnee());
		getContentPane().add(btnModif);
		
		JButton btnSupp = new JButton("Supprimer");
		btnSupp.setBounds(83, 308, 141, 35);
		btnSupp.addActionListener(new BSuppIdListener());
		getContentPane().add(btnSupp);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(421, 0, 115, 29);
		btnMenu.addActionListener(new BtMenu());
		panel.add(btnMenu);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(18, 209, 92, 26);
		getContentPane().add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBackground(new Color(253, 245, 230));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(131, 203, 146, 32);
		getContentPane().add(textFieldPrenom);
		this.con=con;
		
		eleve= new EleveDAO(con);
		//ArrayList<Anneescolaire> c=niveau.seeAll();
		String title[]= {"Id","Nom"};
		setResizable(false);
		
		
		
		this.setVisible(true);
	}
	
	//deplacer text dans case
	public void Deplace() {
		try {
			//on recupere la ligne selectionne
			int row =table.getSelectedRow();
			this.test=(int) (table.getModel().getValueAt(row, 0));
			Eleve a=eleve.find(test);
			
			textFieldId.setText(String.valueOf(a.getId()));
			textFieldAnnee.setText(String.valueOf(a.getNom()));
			textFieldPrenom.setText(String.valueOf(a.getPrenom()));
			
					
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
					String nom=textFieldAnnee.getText();
					String prenom=textFieldPrenom.getText();
					Eleve a=new Eleve(s,nom,prenom);
					eleve.create(a);
					
					
					}
				
			}
	
	
	//class pour repondre au boutton afficher
	class BtAfficherListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ResultSet rs =eleve.Ro();
			System.out.println("ok");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		
	}
	
	
	//class pour modifier
	class BModifListenerAnnee implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			String id = textFieldId.getText();
			Integer s=Integer.valueOf(id);
			String nom=textFieldAnnee.getText();
			String prenom=textFieldPrenom.getText();
			
			
			Eleve a=eleve.find(s);
			a.setNom(nom);
			a.setPrenom(prenom);
			eleve.update(a);
		}
	}
	
	class BSuppIdListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String id = textFieldId.getText();
			Integer s=Integer.valueOf(id);
			
			
			Eleve a=eleve.find(s);
			eleve.delete(a);
			
		}
		
	}
	
	class BtMenu implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Acceuil a=new Acceuil();
			GEleve.this.setVisible(false);
		}
	}
	
	
}