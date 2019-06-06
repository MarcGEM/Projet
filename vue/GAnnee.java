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

public class GAnnee extends JFrame{
    private AnneescolaireDAO Annee;
    private Connexion con;
    private JTable table;
	
	public GAnnee(Connexion con) {
		super("Gestion Annee");
		getContentPane().setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(840,651);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 480, 322);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(140, 68, 225, 48);
		panel.add(table);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.setBounds(198, 21, 141, 35);
		btnAfficher.addActionListener(new BtAfficherListener());
		panel.add(btnAfficher);
		this.con=con;
		
		Annee= new AnneescolaireDAO(con);
		ArrayList<Anneescolaire> c=Annee.seeAll();
		String title[]= {"Id","Annee"};
		setResizable(false);
		
		
		
		this.setVisible(true);
	}
	
	class BtAfficherListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			AnneescolaireDAO annee1 = new AnneescolaireDAO(con);
			ResultSet rs =annee1.Ro();
			System.out.println("ok");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
	}
	
	
}
