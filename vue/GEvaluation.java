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
import vue.GInscription.BtMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GEvaluation extends JFrame{
    private EvaluationDAO evaluation;
    private Connexion con;
    private JTable table;
    private JTextField textFieldId;
    private JTextField textFieldAnnee;
	private static int test;
	private JTextField textFieldPrenom;
	private JTextField textFieldAppreciation;
	private JTable table_1;
    
    
    
	public GEvaluation(Connexion con) {
		super("Gestion Evaluation");
		getContentPane().setForeground(new Color(176, 224, 230));
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
		
		JLabel lblDetailbulletin = new JLabel("ID Detail Bulletin ");
		lblDetailbulletin.setBounds(21, 155, 130, 26);
		getContentPane().add(lblDetailbulletin);
		
		textFieldAnnee = new JTextField();
		textFieldAnnee.setBounds(166, 154, 74, 29);
		getContentPane().add(textFieldAnnee);
		textFieldAnnee.setColumns(10);
		
		JLabel lblInfos = new JLabel("INFOS");
		lblInfos.setBounds(109, 55, 92, 26);
		getContentPane().add(lblInfos);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ButtonAddListener());
		btnAdd.setBounds(18, 304, 133, 35);
		getContentPane().add(btnAdd);
		
		JButton btnModif = new JButton("Modifier");
		btnModif.setBounds(154, 304, 123, 35);
		btnModif.addActionListener(new BModifListenerAnnee());
		getContentPane().add(btnModif);
		
		JButton btnSupp = new JButton("Supprimer");
		btnSupp.setBounds(84, 355, 141, 35);
		btnSupp.addActionListener(new BSuppIdListener());
		getContentPane().add(btnSupp);
		
		JLabel lblFond = new JLabel("");
		lblFond.setForeground(new Color(176, 224, 230));
		lblFond.setBounds(0, 0, 834, 600);
		getContentPane().add(lblFond);
		
		JLabel lblPrenom = new JLabel("Note");
		lblPrenom.setBounds(18, 209, 92, 26);
		getContentPane().add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(131, 203, 146, 32);
		getContentPane().add(textFieldPrenom);
		
		textFieldAppreciation = new JTextField();
		textFieldAppreciation.setColumns(10);
		textFieldAppreciation.setBounds(131, 245, 146, 32);
		getContentPane().add(textFieldAppreciation);
		
		JLabel lblAppreciation = new JLabel("Appreciation\r\n");
		lblAppreciation.setBounds(18, 251, 92, 26);
		getContentPane().add(lblAppreciation);
		this.con=con;
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(421, 0, 115, 29);
		btnMenu.addActionListener(new BtMenu());
		panel.add(btnMenu);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(472, 328, 245, 152);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(176, 224, 230));
		lblNewLabel_1.setBounds(0, 0, 834, 611);
		getContentPane().add(lblNewLabel_1);
		
		
		
		evaluation= new EvaluationDAO(con);
		setResizable(false);
		
		
		
		this.setVisible(true);
	}
	
	//deplacer text dans case
	public void Deplace() {
		try {
			//on recupere la ligne selectionne
			int row =table.getSelectedRow();
			this.test=(int) (table.getModel().getValueAt(row, 0));
			Evaluation a=evaluation.find(test);
			
			textFieldId.setText(String.valueOf(a.getId()));
			textFieldAnnee.setText(String.valueOf(a.getDetailbulletin().getId()));
			textFieldPrenom.setText(String.valueOf(a.getNote()));
			textFieldAppreciation.setText(String.valueOf(a.getAppreciation()));
			
					
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
					String iddetail=textFieldAnnee.getText();
					Integer detail=Integer.valueOf(iddetail);
					String note=textFieldPrenom.getText();
					Integer noteeval=Integer.valueOf(note);
					String appreciation=textFieldAppreciation.getText();
					DetailbulletinDAO d=new DetailbulletinDAO(con);
					Detailbulletin de=d.find(detail);
					
					Evaluation a=new Evaluation(s,de,noteeval,appreciation);
					evaluation.create(a);
					
					// System.out.println(d.moyenneDiscipline(detail));
					
					}
				
			}
	
	
	//class pour repondre au boutton afficher
	class BtAfficherListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ResultSet rs =evaluation.Ro();
			System.out.println("ok");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			DetailbulletinDAO annee1 = new DetailbulletinDAO(con);
			ResultSet rs1 =annee1.Ro();
			table_1.setModel(DbUtils.resultSetToTableModel(rs1));
			
		}
		
	}
	
	
	//class pour modifier
	class BModifListenerAnnee implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			String id = textFieldId.getText();
			Integer s=Integer.valueOf(id);
			String iddetail=textFieldAnnee.getText();
			Integer detail=Integer.valueOf(iddetail);
			String note=textFieldPrenom.getText();
			Integer noteeval=Integer.valueOf(note);
			String appreciation=textFieldAppreciation.getText();
			DetailbulletinDAO d=new DetailbulletinDAO(con);
			
			
			Evaluation a=evaluation.find(s);
			a.setNote(noteeval);
			a.setAppreciation(appreciation);
			evaluation.update(a);
		}
	}
	
	class BSuppIdListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String id = textFieldId.getText();
			Integer s=Integer.valueOf(id);
			
			
			Evaluation a=evaluation.find(s);
			evaluation.delete(a);
			
		}
		
	}
	
	class BtMenu implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Acceuil a=new Acceuil();
			GEvaluation.this.setVisible(false);
		}
	}
}