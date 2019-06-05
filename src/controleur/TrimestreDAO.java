package controleur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.*;
import vue.Accueil;

public class TrimestreDAO extends DAO<Trimestre> implements ActionListener
{
	private JFrame frame;
	private JButton btnAdd = new JButton("Save");
	private JTextField textField;
	private JTextField textField_1;
	JLabel lblAnneScolaire = new JLabel("num\u00E9ro\r\n");
	JLabel lblId = new JLabel("ID");
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JButton btnDelete = new JButton("Delete");
	JLabel lblId_1 = new JLabel("ID ");
	JLabel lblModifierUneAnne = new JLabel("Modifier un trimestre\r\n");
	JLabel lblIdDeLanne = new JLabel("ID de l'ann\u00E9e \u00E0 modifer");
	JButton btnUpdate = new JButton("Update");
	JLabel lblNewLabel = new JLabel("Ajouter un Trimestre\r\n");
	JLabel lblSupprimer = new JLabel("Supprimer un trimestre");
	JLabel lblNouvelleAnne = new JLabel("Num\u00E9ro");
	private final JButton btnRetourMenu = new JButton("Retour menu");
	private final JLabel lblDebutaaaammjj = new JLabel("Debut (aaaa-mm-jj)");
	private final JTextField textField_5 = new JTextField();
	private final JLabel lblFinaaaammjj = new JLabel("Fin (aaaa-mm-jj)");
	private final JTextField textField_6 = new JTextField();
	private final JLabel lblIdDeLanne_1 = new JLabel("Id de l'ann\u00E9e");
	private final JTextField textField_7 = new JTextField();
	private final JLabel lblId_2 = new JLabel("ID");
	private final JLabel label = new JLabel("Debut (aaaa-mm-jj)");
	private final JTextField textField_8 = new JTextField();
	private final JTextField textField_9 = new JTextField();
	private final JLabel label_1 = new JLabel("Fin (aaaa-mm-jj)");
	DAO<Anneescolaire> anneescolaireDao = new AnneescolaireDAO(con);
	
	
	public TrimestreDAO(Connexion m_con) 
	{
		super(m_con);
		anneescolaireDao.visibility(0);
		textField_7.setBounds(19, 215, 63, 26);
		textField_7.setColumns(10);
		textField_5.setBounds(144, 100, 115, 26);
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
		textField_1.setBounds(19, 150, 77, 26);
		lblNewLabel.setBounds(19, 38, 263, 20);
		lblSupprimer.setBounds(15, 279, 286, 20);
		btnAdd.setBounds(19, 245, 115, 29);
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
		lblFinaaaammjj.setBounds(144, 125, 157, 20);
		
		frame.getContentPane().add(lblFinaaaammjj);
		textField_6.setColumns(10);
		textField_6.setBounds(144, 150, 115, 26);
		
		frame.getContentPane().add(textField_6);
		lblIdDeLanne_1.setBounds(19, 192, 157, 20);
		
		frame.getContentPane().add(lblIdDeLanne_1);
		
		frame.getContentPane().add(textField_7);
		lblId_2.setBounds(463, 351, 38, 20);
		
		frame.getContentPane().add(lblId_2);
		label.setBounds(350, 379, 157, 20);
		
		frame.getContentPane().add(label);
		textField_8.setColumns(10);
		textField_8.setBounds(495, 376, 115, 26);
		
		frame.getContentPane().add(textField_8);
		textField_9.setColumns(10);
		textField_9.setBounds(748, 376, 115, 26);
		
		frame.getContentPane().add(textField_9);
		label_1.setBounds(625, 379, 121, 20);
		
		frame.getContentPane().add(label_1);

		lblAnneScolaire.setVisible(true);
		lblId.setVisible(true);
		textField.setVisible(true);
		textField_1.setVisible(true);
		
		this.frame.setVisible(true);
			
	
		
		
	}
		
	@Override
	public void create(Trimestre obj) 
	{
		try {
			con.stmt.executeUpdate( "INSERT INTO trimestre (id,numero,debut,fin,anneescolaire_id) VALUES ('"+obj.getId()+"','"+obj.getNumero()+"','"+obj.getDebut()+"','"+obj.getFin()+"','"+obj.getAnneescolaire().getId()+"')");
			System.out.println("Trimestre create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Trimestre obj) 
	{
		try {
			 con.stmt.executeUpdate( "DELETE FROM Trimestre Where id="+obj.getId());
			System.out.println("Trimestre delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Trimestre obj) 
	{
		try {
			con.stmt.executeUpdate( "UPDATE Trimestre SET numero='"+obj.getNumero()+"', debut='"+obj.getDebut()+"', fin='"+obj.getFin()+"', anneescolaire_id='"+obj.getAnneescolaire().getId()+"' WHERE id="+obj.getId()+"");
			System.out.println("Trimestre update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Trimestre find(int id) 
	{
		Anneescolaire a=new Anneescolaire();
		Trimestre t=new Trimestre();
		String query="SELECT * FROM trimestre where id="+id;
		
		try {
			con.rset=con.stmt.executeQuery(query);
			if(con.rset.first())
			{
				 int idt=con.rset.getInt("id");
				 int numero=con.rset.getInt("numero");
				 String debut=con.rset.getString("debut");
				 String fin=con.rset.getString("fin");
				 int ida=con.rset.getInt("anneescolaire_id");
				 query="SELECT * FROM anneescolaire where id="+ida;
				 con.rset=con.stmt.executeQuery(query);
				 if(con.rset.first())
				 {
					 a=new Anneescolaire(con.rset.getInt("id"),con.rset.getString("annee"));
					 t=new Trimestre(idt,numero,debut,fin,a);
				 }
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		
	}

	@Override
	public void seeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnAdd)
		{
			String o=textField.getText();
			Integer s=Integer.valueOf(o);
			String p=textField_1.getText();
			Integer numero=Integer.valueOf(p);
			String debut=textField_5.getText();
			String fin=textField_6.getText();
			String idString=textField_7.getText();
			Integer idInt=Integer.valueOf(idString);
			
			
			
			Trimestre a=new Trimestre(s,numero,debut,fin,anneescolaireDao.find(idInt));	
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
			Trimestre a=find(s);
			String changement=textField_4.getText();
			Integer numero=Integer.valueOf(changement);
			String debut=textField_8.getText();
			String fin=textField_9.getText();
			
			
			a.setNumero(numero);
			a.setDebut(debut);
			a.setFind(fin);
			
			
			
			update(a);
			
		}
		if(e.getSource()==btnRetourMenu)
		{
			this.frame.setVisible(false);
			Accueil a=new Accueil();
		}
		
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

	

	

}
