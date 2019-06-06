package controleur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.*;
import vue.Accueil;

public class ClasseDAO extends DAO<Classe> implements ActionListener
{
	private JFrame frame;
	private JButton btnAdd = new JButton("Save");
	private JTextField textField;
	private JTextField textField_1;
	JLabel lblAnneScolaire = new JLabel("Nom");
	JLabel lblId = new JLabel("ID");
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JButton btnDelete = new JButton("Delete");
	JLabel lblId_1 = new JLabel("ID ");
	JLabel lblModifierUneAnne = new JLabel("Modifier une classe\r\n\r\n");
	JLabel lblIdDeLanne = new JLabel("ID de l'ann\u00E9e \u00E0 modifer");
	JButton btnUpdate = new JButton("Update");
	JLabel lblNewLabel = new JLabel("Ajouter une classe\r\n\r\n");
	JLabel lblSupprimer = new JLabel("Supprimer une classe");
	JLabel lblNouvelleAnne = new JLabel("Nom");
	private final JButton btnRetourMenu = new JButton("Retour menu");
	private final JLabel lblDebutaaaammjj = new JLabel("ID du niveau");
	private final JTextField textField_5 = new JTextField();
	private final JLabel lblFinaaaammjj = new JLabel("ID de l'ann\u00E9e");
	private final JTextField textField_6 = new JTextField();
	private final JLabel lblId_2 = new JLabel("ID");
	private final JLabel lblChangerLeNiveau = new JLabel("ID du niveau");
	private final JTextField textField_8 = new JTextField();
	private final JTextField textField_9 = new JTextField();
	private final JLabel lblIdDeLanne_1 = new JLabel("ID de l'ann\u00E9e scolaire\r\n");
	DAO<Anneescolaire> anneescolaireDao = new AnneescolaireDAO(con);
	DAO<Niveau> niveauDao=new NiveauDAO(con);
	
	
	
	

	public ClasseDAO(Connexion m_con) 
	{
		super(m_con);
		
		anneescolaireDao.visibility(0);
		textField_5.setBounds(144, 100, 63, 26);
		textField_5.setColumns(10);
		// TODO Auto-generated constructor stub
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnRetourMenu.addActionListener(this);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModifierUneAnne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		textField_4 = new JTextField();
		textField_3 = new JTextField();
		textField_2 = new JTextField();
		textField_1 = new JTextField();
		textField = new JTextField();
		
		textField.setColumns(10);
		textField_1.setColumns(10);
		textField_4.setColumns(10);
		textField_3.setColumns(10);
		textField_2.setColumns(10);
		
		lblId.setBounds(19, 74, 69, 20);
		textField.setBounds(19, 100, 69, 26);
		textField_1.setBounds(19, 150, 79, 26);
		lblNewLabel.setBounds(19, 38, 263, 20);
		lblSupprimer.setBounds(19, 260, 286, 20);
		btnAdd.setBounds(25, 192, 115, 29);
		lblId_1.setBounds(15, 307, 31, 20);
		lblAnneScolaire.setBounds(19, 125, 121, 20);
		textField_2.setBounds(49, 304, 63, 26);
		textField_3.setBounds(516, 348, 63, 26);
		textField_4.setBounds(661, 347, 63, 29);
		lblNouvelleAnne.setBounds(594, 351, 69, 20);
		btnUpdate.setBounds(690, 433, 115, 29);
		btnRetourMenu.setBounds(730, 0, 148, 29);
		lblModifierUneAnne.setBounds(506, 323, 286, 20);
		btnDelete.setBounds(15, 343, 115, 29);
		lblIdDeLanne.setBounds(456, 310, 191, 20);
		
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNouvelleAnne);
		frame.getContentPane().add(btnUpdate);
		frame.getContentPane().add(btnRetourMenu);
		frame.getContentPane().add(textField_4);
		frame.getContentPane().add(textField_3);
		frame.getContentPane().add(textField_2);
		frame.getContentPane().add(btnDelete);
		frame.getContentPane().add(lblId_1);
		frame.getContentPane().add(lblAnneScolaire);
		frame.getContentPane().add(lblId);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(lblSupprimer);
		frame.getContentPane().add(lblAnneScolaire);
		frame.getContentPane().add(lblId);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(btnAdd);
		frame.getContentPane().add(lblModifierUneAnne);
		lblDebutaaaammjj.setBounds(144, 74, 157, 20);
		
		frame.getContentPane().add(lblDebutaaaammjj);
		
		frame.getContentPane().add(textField_5);
		lblFinaaaammjj.setBounds(144, 125, 102, 20);
		
		frame.getContentPane().add(lblFinaaaammjj);
		textField_6.setColumns(10);
		textField_6.setBounds(144, 150, 63, 26);
		
		frame.getContentPane().add(textField_6);
		lblId_2.setBounds(463, 351, 38, 20);
		
		frame.getContentPane().add(lblId_2);
		lblChangerLeNiveau.setBounds(331, 379, 102, 20);
		
		frame.getContentPane().add(lblChangerLeNiveau);
		textField_8.setColumns(10);
		textField_8.setBounds(433, 376, 115, 26);
		
		frame.getContentPane().add(textField_8);
		textField_9.setColumns(10);
		textField_9.setBounds(729, 376, 115, 26);
		
		frame.getContentPane().add(textField_9);
		lblIdDeLanne_1.setBounds(563, 379, 151, 20);
		
		frame.getContentPane().add(lblIdDeLanne_1);

		lblAnneScolaire.setVisible(true);
		lblId.setVisible(true);
		textField.setVisible(true);
		textField_1.setVisible(true);
		
		this.frame.setVisible(true);
			
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void create(Classe obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO classe (id,nom,niveau_id,anneescolaire_id) VALUES ('"+obj.getId()+"','"+obj.getNom()+"','"+obj.getNiveau().getId()+"','"+obj.getAnneescolaire().getId()+"')");
			System.out.println("Classe create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Classe obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM classe Where id="+obj.getId());
			System.out.println("Classe delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Classe obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE classe SET nom='"+obj.getNom()+"', niveau_id='"+obj.getNiveau().getId()+"', anneescolaire_id='"+obj.getAnneescolaire().getId()+"' WHERE id="+obj.getId()+"");
			System.out.println("classe update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Classe find(int id) 
	{
		Anneescolaire a=new Anneescolaire();
		Niveau n=new Niveau();
		Classe c=new Classe();
		String query="SELECT * FROM classe where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int idt=con.rset.getInt("id");
				 String nom=con.rset.getString("nom");
				 int idn=con.rset.getInt("niveau_id");
				 int ida=con.rset.getInt("anneescolaire_id");
				 query="SELECT * FROM anneescolaire where id="+ida;
				 con.rset=con.stmt.executeQuery(query);
				 if(con.rset.first())
				 {
					 a=new Anneescolaire(con.rset.getInt("id"),con.rset.getString("annee"));
					 query="SELECT * FROM niveau where id="+idn;
					 con.rset=con.stmt.executeQuery(query);
					 if(con.rset.first())
					 {
						 n=new Niveau(con.rset.getInt("id"),con.rset.getString("nom"));
						 c=new Classe(idt,nom,n,a);
					 }
					 
				 }
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}

	@Override
	public ArrayList seeAll() 
	{
		return null;
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnAdd)
		{
			String o=textField.getText();
			Integer s=Integer.valueOf(o);
			String nom=textField_1.getText();
			String niveau=textField_5.getText();
			Integer idniveau=Integer.valueOf(niveau);
			String anneescolaire=textField_6.getText();
			Integer idannescolaire=Integer.valueOf(anneescolaire);
			
			Classe a=new Classe(s,nom,niveauDao.find(idniveau),anneescolaireDao.find(idannescolaire));	
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
			Classe a=find(s);
			String changementnom=textField_4.getText();
			String niveau=textField_8.getText();
			String anneescolaire=textField_9.getText();
			
			Integer idniveau=Integer.valueOf(niveau);
			Integer idanneescolaire=Integer.valueOf(anneescolaire);
			
			a.setNom(changementnom);
			a.setAnneescolaire(anneescolaireDao.find(idniveau));
			a.setNiveau(niveauDao.find(idniveau));

			
			update(a);
			
		}
		if(e.getSource()==btnRetourMenu)
		{
			this.frame.setVisible(false);
			Accueil a=new Accueil();
		}
		
	}
	
}