package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.*;
import java.awt.Font;
import vue.*;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public class AnneescolaireDAO extends DAO<Anneescolaire> implements ActionListener
{

	public JFrame frame;
	private JButton btnAdd = new JButton("Save");
	private JTextField textField;
	private JTextField textField_1;
	JLabel lblAnneScolaire = new JLabel("Ann\u00E9e Scolaire");
	JLabel lblId = new JLabel("ID");
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JButton btnDelete = new JButton("Delete");
	JLabel lblId_1 = new JLabel("ID ");
	JLabel lblModifierUneAnne = new JLabel("Modifier une ann\u00E9e scolaire");
	JButton btnUpdate = new JButton("Update");
	JLabel lblNewLabel = new JLabel("Ajouter une ann\u00E9e scolaire");
	JLabel lblSupprimer = new JLabel("Supprimer une ann\u00E9e scolaire");
	private final JButton btnRetourMenu = new JButton("Retour menu");
	ArrayList<Anneescolaire>tabAnneescolaire;
	DefaultTableModel model;
	
	
	public AnneescolaireDAO(Connexion m_con) 
	{
		super(m_con);
		// TODO Auto-generated constructor stub
		frame = new JFrame();
		frame.setBounds(100, 100, 827, 491);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabAnneescolaire=new ArrayList<Anneescolaire>();
		
		btnAdd.setBounds(19, 181, 115, 29);
		frame.getContentPane().add(btnAdd);
		
		frame.getContentPane().add(btnRetourMenu);
		
		
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnRetourMenu.addActionListener(this);
		
		lblId.setBounds(19, 74, 69, 20);
		textField = new JTextField();
		textField.setBounds(19, 100, 146, 26);
		
		textField.setColumns(10);
		
		lblAnneScolaire.setBounds(19, 130, 121, 20);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(19, 152, 146, 26);
		
		textField_1.setColumns(10);
		
		
		
		lblAnneScolaire.setVisible(true);
		lblId.setVisible(true);
		textField.setVisible(true);
		textField_1.setVisible(true);
		
		
		
		
		
		frame.getContentPane().add(lblAnneScolaire);
		frame.getContentPane().add(lblId);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(textField_1);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(19, 38, 263, 20);
		frame.getContentPane().add(lblNewLabel);
		
		lblSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSupprimer.setBounds(15, 279, 286, 20);
		frame.getContentPane().add(lblSupprimer);
		
		JLabel lblId_1 = new JLabel("ID ");
		lblId_1.setBounds(15, 307, 31, 20);
		frame.getContentPane().add(lblId_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(49, 304, 63, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		btnDelete.setBounds(15, 343, 115, 29);
		frame.getContentPane().add(btnDelete);
		
	
		lblModifierUneAnne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModifierUneAnne.setBounds(458, 281, 286, 20);
		frame.getContentPane().add(lblModifierUneAnne);
		
		JLabel lblIdDeLanne = new JLabel("ID de l'ann\u00E9e \u00E0 modifer");
		lblIdDeLanne.setBounds(456, 310, 191, 20);
		frame.getContentPane().add(lblIdDeLanne);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(642, 307, 63, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(642, 344, 63, 29);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNouvelleAnne = new JLabel("Nouvelle ann\u00E9e");
		lblNouvelleAnne.setBounds(456, 352, 191, 20);
		frame.getContentPane().add(lblNouvelleAnne);
		
		btnUpdate.setBounds(590, 389, 115, 29);
		frame.getContentPane().add(btnUpdate);
		btnRetourMenu.setBounds(657, 0, 148, 29);
		
		frame.getContentPane().add(btnRetourMenu);
		
		
		//show();
		
		
			
		
		
		this.frame.setVisible(true);
			// TODO Auto-generated catch block
	
		
		
	}

	@Override
	public void create(Anneescolaire obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO anneescolaire (id,annee) VALUES ('"+obj.getId()+"','"+obj.getAnnee()+"')");
			System.out.println("Annee scolaire create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Anneescolaire obj) 
	{
		try {
			con.stmt.executeUpdate( "DELETE FROM anneescolaire Where id="+obj.getId());
			System.out.println("Annee scolaire delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Anneescolaire obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE anneescolaire SET annee='"+obj.getAnnee()+"' WHERE id="+obj.getId()+"");
			System.out.println("Annee scolaire update");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Anneescolaire find(int id) 
	{
		Anneescolaire a=new Anneescolaire();
		String query="SELECT * FROM anneescolaire where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 a=new Anneescolaire(con.rset.getInt("id"),con.rset.getString("annee"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public ArrayList seeAll() 
	{
		Anneescolaire a=new Anneescolaire();
		String query="SELECT * FROM anneescolaire";
		
		try {
			con.rset=con.stmt.executeQuery(query);
			while(con.rset.next())
			{
				 a=new Anneescolaire(con.rset.getInt("id"),con.rset.getString("annee"));
				tabAnneescolaire.add(a);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabAnneescolaire;
		
	}
	
	public void visibility(int e)
	{
		if(e==0)
		{
			this.frame.setVisible(false);
		}
		if(e==1)
		{
			this.frame.setVisible(true);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		
		
		if(e.getSource() == btnAdd)
		{
			
			String o=textField.getText();
			Integer s=Integer.valueOf(o);
			String p=textField_1.getText();
			 Anneescolaire a=new Anneescolaire(s,p);	
			create(a);	
		}
		
		if(e.getSource()==btnDelete)
		{
			String o=textField_2.getText();
			Integer s=Integer.valueOf(o);
			delete(find(s));
		}
		if(e.getSource()==btnUpdate)
		{
			String o=textField_3.getText();
			Integer s=Integer.valueOf(o);
			
			
			Anneescolaire a=find(s);
			String changement=textField_4.getText();
			a.setAnnee(changement);
			update(a);
			
		}
		if(e.getSource()==btnRetourMenu)
		{
			this.frame.setVisible(false);
			Accueil a=new Accueil();
		}
			 
		
	}

}
	

	
	


