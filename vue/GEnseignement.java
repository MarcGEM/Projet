package vue;

import java.awt.Color;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controleur.AnneescolaireDAO;
import controleur.TrimestreDAO;
import model.Anneescolaire;
import model.Connexion;
import vue.GTrimestre.BModifListenerAnnee;
import vue.GTrimestre.BSuppIdListener;
import vue.GTrimestre.BtAfficherListener;
import vue.GTrimestre.ButtonAddListener;
import vue.GTrimestre.MouseAdapter;



public class GEnseignement  extends JFrame{

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
	    
	    
	    
		public GEnseignement(Connexion con)  {
			super("Gestion Annee");
			setTitle("Gestion Trimestre");
			getContentPane().setForeground(Color.BLACK);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(840,651);
			//position au centre
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			
			trimestre = new TrimestreDAO(con);
			
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
			//btnAfficher.addActionListener(new BtAfficherListener());
			panel.add(btnAfficher);
			
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(18, 102, 92, 26);
			getContentPane().add(lblNewLabel);
			
			textFieldId = new JTextField();
			textFieldId.setBounds(131, 99, 146, 32);
			getContentPane().add(textFieldId);
			textFieldId.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Id Annee");
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
			
			Annee= new AnneescolaireDAO(con);
			ArrayList<Anneescolaire> c=Annee.seeAll();
			String title[]= {"Id","Annee"};
			setResizable(false);
			//oupsi
			
			
			this.setVisible(true);
	
	
	
}
