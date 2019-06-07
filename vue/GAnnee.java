package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;

import controleur.AnneescolaireDAO;
import model.Anneescolaire;
import model.Connexion;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GAnnee extends JFrame{
    private AnneescolaireDAO Annee;
    private Connexion con;
    private JTable table;
    private JTextField textFieldId;
    private JTextField textFieldAnnee;
	private static int test;
    
    
    
	public GAnnee(Connexion con) {
		super("Gestion Annee");
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
		
		JLabel lblNewLabel_1 = new JLabel("Annee");
		lblNewLabel_1.setBounds(21, 155, 92, 26);
		getContentPane().add(lblNewLabel_1);
		
		textFieldAnnee = new JTextField();
		textFieldAnnee.setBounds(131, 152, 146, 32);
		getContentPane().add(textFieldAnnee);
		textFieldAnnee.setColumns(10);
		
		JLabel lblInfos = new JLabel("INFOS");
		lblInfos.setBounds(109, 55, 92, 26);
		getContentPane().add(lblInfos);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ButtonAddListener());
		btnAdd.setBounds(10, 228, 133, 35);
		getContentPane().add(btnAdd);
		
		JButton btnModif = new JButton("Modifier");
		btnModif.setBounds(164, 228, 123, 35);
		btnModif.addActionListener(new BModifListenerAnnee());
		getContentPane().add(btnModif);
		
		JButton btnSupp = new JButton("Supprimer");
		btnSupp.setBounds(83, 284, 141, 35);
		btnSupp.addActionListener(new BSuppIdListener());
		getContentPane().add(btnSupp);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 834, 600);
		getContentPane().add(lblFond);
		this.con=con;
		
		Annee= new AnneescolaireDAO(con);
		ArrayList<Anneescolaire> c=Annee.seeAll();
		String title[]= {"Id","Annee"};
		setResizable(false);
		
		
		
		this.setVisible(true);
	}
	
	//deplacer text dans case
	public void Deplace() {
		try {
			//on recupere la ligne selectionne
			int row =table.getSelectedRow();
			this.test=(int) (table.getModel().getValueAt(row, 0));
			AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
			Anneescolaire a=annee1.find(test);
			
			textFieldId.setText(String.valueOf(a.getId()));
			textFieldAnnee.setText(String.valueOf(a.getAnnee()));
					
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
					String Annee=textFieldAnnee.getText();
					AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
					Anneescolaire a=new Anneescolaire(s,Annee);
					annee1.create(a);
					
					
					}
				
			}
	
	
	//class pour repondre au boutton afficher
	class BtAfficherListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
			ResultSet rs =annee1.Ro();
			System.out.println("ok");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		
	}
	
	
	//class pour modifier
	class BModifListenerAnnee implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			String id = textFieldId.getText();
			Integer s=Integer.valueOf(id);
			String Annee=textFieldAnnee.getText();
			AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
			
			Anneescolaire a=annee1.find(s);
			a.setAnnee(Annee);
			annee1.update(a);
		}
	}
	
	class BSuppIdListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String id = textFieldId.getText();
			Integer s=Integer.valueOf(id);
			AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
			
			Anneescolaire a=annee1.find(s);
			annee1.delete(a);
			
		}
		
	}
	
	
	
}
