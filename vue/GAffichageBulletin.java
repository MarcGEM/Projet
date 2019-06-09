package vue;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import org.jfree.chart.*;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.sun.xml.internal.ws.api.pipe.Fiber;
import com.sun.xml.internal.ws.api.pipe.Fiber.Listener;

import controleur.*;
import model.Anneescolaire;
import model.Bulletin;
import model.Connexion;
import model.Detailbulletin;
import model.Eleve;
import model.Inscription;
import model.Trimestre;
import vue.GAnnee.BModifListenerAnnee;
import vue.GAnnee.BSuppIdListener;
import vue.GAnnee.BtAfficherListener;
import vue.GAnnee.BtMenu;
import vue.GAnnee.ButtonAddListener;
import vue.GAnnee.MouseAdapter;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GAffichageBulletin extends JFrame
{

	ArrayList<JLabel>tab;
	ArrayList<Bulletin>totB;
	ArrayList<Inscription>totI;
	ArrayList<Detailbulletin>totD;
	ArrayList<Integer>listidDetailBulletin;
	
	BulletinDAO b;
	InscriptionDAO i;
	DetailbulletinDAO d;
	
	JLabel l;
	private int idEleve;
	private int idInscription;
	private int idBulletin;
	private int idTrimestre;
	private JLabel lblNom;
	private JLabel lblClasse;
	private Connexion con;
	private JLabel lblNiveau;
	private JLabel lblDateDebut;
	private JLabel lblNumero;
	private JLabel lblFin ;
	private JPanel panel;
	
	public  GAffichageBulletin(Connexion con,int idEleve)  
	{
		
		setBackground(new Color(245, 245, 245));
		setTitle("BULLETIN");
		setResizable(false);
		this.idEleve=idEleve;
		this.con=con;
		b=new BulletinDAO(con);
		i=new InscriptionDAO(con);
		d=new DetailbulletinDAO(con);
		listidDetailBulletin= new ArrayList<Integer>();
		
		
		getContentPane().setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(641,695);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(88, 21, 478, 602);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(363, 0, 115, 29);
		btnMenu.addActionListener(new BtMenu());
		panel.add(btnMenu);
		
		JLabel lblNewLabel = new JLabel("BULLETIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(189, 29, 220, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(229, 76, 92, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Classe");
		lblNewLabel_2.setBounds(229, 115, 92, 26);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(GAffichageBulletin.class.getResource("/images/icons8-\u00E9crivain-100.png")));
		lblNewLabel_3.setBounds(36, 70, 132, 111);
		panel.add(lblNewLabel_3);
		
		 lblNom = new JLabel("j");
		lblNom.setBounds(325, 76, 92, 26);
		panel.add(lblNom);
		
		 lblClasse = new JLabel("New label");
		lblClasse.setBounds(402, 115, 55, 26);
		panel.add(lblClasse);
		
		 lblNiveau = new JLabel("New label");
		lblNiveau.setBounds(325, 115, 61, 26);
		panel.add(lblNiveau);
		
		JLabel lblTrimestre = new JLabel("TRIMESTRE");
		lblTrimestre.setBounds(65, 202, 115, 26);
		panel.add(lblTrimestre);
		
		JLabel lblNewLabel_4 = new JLabel("du");
		lblNewLabel_4.setBounds(210, 202, 40, 26);
		panel.add(lblNewLabel_4);
		
		lblDateDebut = new JLabel("New label");
		lblDateDebut.setBounds(241, 202, 92, 26);
		panel.add(lblDateDebut);
		
		JLabel lblNewLabel_5 = new JLabel("au");
		lblNewLabel_5.setBounds(337, 202, 30, 26);
		panel.add(lblNewLabel_5);
		
		lblFin = new JLabel("New label");
		lblFin.setBounds(365, 202, 92, 26);
		panel.add(lblFin);
		
		lblNumero = new JLabel("New label");
		lblNumero.setBounds(189, 202, 31, 26);
		panel.add(lblNumero);
		
		JLabel lblNewLabel_6 = new JLabel("Matiere");
		lblNewLabel_6.setBounds(51, 261, 92, 26);
		panel.add(lblNewLabel_6);
		
		JLabel lblMoyenne = new JLabel("Moyenne");
		lblMoyenne.setBounds(199, 261, 92, 26);
		panel.add(lblMoyenne);
		
		JLabel lblNewLabel_7 = new JLabel("Appreciation");
		lblNewLabel_7.setBounds(325, 261, 132, 26);
		panel.add(lblNewLabel_7);
		
		
		
		
		Affichage();
		
			
			
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(33, 250, 424, 172);
			panel.add(scrollPane_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(248, 248, 255));
			scrollPane_1.setViewportView(panel_1);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(210, 63, 247, 121);
			panel.add(scrollPane_2);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(248, 248, 255));
			scrollPane_2.setViewportView(panel_2);
			
			JScrollPane scrollPane = new JScrollPane();
			panel_2.add(scrollPane);
			
			JLabel lblMoyenneGenerale = new JLabel("Moyenne Generale");
			lblMoyenneGenerale.setBounds(46, 475, 174, 26);
			panel.add(lblMoyenneGenerale);
			
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(46, 202, 411, 43);
			panel.add(scrollPane_3);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(248, 248, 255));
			scrollPane_3.setViewportView(panel_3);
			
			JButton btnGraphe = new JButton("GRAPHE");
			btnGraphe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					Bulletin bulletin= b.find(idBulletin);
					
					for(int i=0;i<listidDetailBulletin.size();i++) {
						
						
					DetailbulletinDAO db = new DetailbulletinDAO(con);
					Detailbulletin detailbulletin = db.find(listidDetailBulletin.get(i));
					
					if(detailbulletin.getBulletin().getId()==idBulletin) {
					System.out.println(listidDetailBulletin.get(i));
						
					double moyenne=db.moyenneDiscipline(listidDetailBulletin.get(i));
				
					System.out.println(moyenne);
					
					dataset.setValue(moyenne,"Note",detailbulletin.getEnseignement().getDiscipline().getNom() );
					
					int x=i*40;
					//affichage nom matiere
					JLabel lblNewLabel_8 = new JLabel("New label");
					lblNewLabel_8.setBounds(51, 306+x, 92, 26);
					lblNewLabel_8.setText(detailbulletin.getEnseignement().getDiscipline().getNom());
					panel.add(lblNewLabel_8);
					
					
					}
					
					//oupsi
					
				}
					JFreeChart chart =ChartFactory.createBarChart("Bulletin", "Matiere","Note",dataset,PlotOrientation.VERTICAL,false,true, false);
					CategoryPlot p= chart.getCategoryPlot();
					p.setRangeGridlinePaint(Color.black);
					ChartFrame frame = new ChartFrame("frame",chart);
					frame.setVisible(true);
					frame.setSize(450,350);
					
					
				}
			});
			btnGraphe.setBounds(180, 546, 141, 35);
			panel.add(btnGraphe);
			
		
			
			
			
		this.setVisible(true);
			
	}
	
	public void Affichage()  {
		
		rechercher();
		
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
		EleveDAO eleveDAO = new EleveDAO(con);
		Eleve e= eleveDAO.find(idEleve);
		
		
		Bulletin bulletin= b.find(idBulletin);
		
		
		
		 lblNom.setText(e.getNom());
		 lblClasse.setText(bulletin.getInscription().getClasse().getNom());
		 lblNiveau.setText(bulletin.getInscription().getClasse().getNiveau().getNom());
		 lblNumero.setText(String.valueOf(bulletin.getTrimestre().getNumero()));
		 
		String dateDebut=bulletin.getTrimestre().getDebut();
		String dateFin=bulletin.getTrimestre().getFin();
		lblFin.setText(dateFin);
		lblDateDebut.setText(dateDebut);
		
		
		for(int i=0;i<listidDetailBulletin.size();i++) {
			
			
		DetailbulletinDAO db = new DetailbulletinDAO(con);
		Detailbulletin detailbulletin = db.find(listidDetailBulletin.get(i));
		
		if(detailbulletin.getBulletin().getId()==idBulletin) {
		System.out.println(listidDetailBulletin.get(i));
			
		double moyenne=db.moyenneDiscipline(listidDetailBulletin.get(i));
	
		System.out.println(moyenne);
		int x=i*40;
		//affichage nom matiere
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(51, 306+x, 92, 26);
		lblNewLabel_8.setText(detailbulletin.getEnseignement().getDiscipline().getNom());
		panel.add(lblNewLabel_8);
		
		//affichage moyenne
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(199, 306+x, 92, 26);
		lblNewLabel_9.setText(String.valueOf(moyenne));
		panel.add(lblNewLabel_9);
		
		
		//affichage appreciation
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(325, 306+x, 92, 26);
		lblNewLabel_10.setText(detailbulletin.getAppreciation());
		panel.add(lblNewLabel_10);
		
		
		//affichage moyenne generale
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(266, 475, 92, 26);
		System.out.println("id bull " +idBulletin);
		double mg=b.moyenneDetail(idBulletin);
		lblNewLabel_11.setText(String.valueOf(mg));
		panel.add(lblNewLabel_11);
		
		//affichage appreciation
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(337, 475, 92, 26);
		lblNewLabel_12.setText(bulletin.getAppreciation());
		panel.add(lblNewLabel_12);
		}
		
		}
		
		//oupsi
		
	}
	
	
	//onn va rechercher tous les id en rapport avec l'eleve
	public void rechercher() {

		//ensemble bulletin
		totB=b.seeAll();
		//ensemble inscriptionn
		totI=i.seeAll();
		//ensemble detail
		totD=d.seeAll();
		
		//on parcour l'array liste a la recherche de l'id inscription 
		for(int i=0;i<totI.size();i++) {
			
			if(totI.get(i).getEleve().getId()==idEleve) {
				idInscription=totI.get(i).getId();
				
			}
			
		}
		System.out.println("c");
		
		
		//on parcour l'arraylist a la recherche de l'id Bulletin
		
		for(int i=0;i<totB.size();i++) {
			
			if(totB.get(i).getInscription().getId()==idInscription) {
				idBulletin=totB.get(i).getId();
				idTrimestre=totB.get(i).getTrimestre().getId();
				
			}
			
		}
		//on recherche l'id de tous les details qui ont l'id du bulletin et
		//onn les stocks danns un araylist
		
		for(int i=0;i<totD.size();i++) {
			if(totD.get(i).getBulletin().getId()==idBulletin)
			{
				
				listidDetailBulletin.add(totD.get(i).getId());
				
				
			}
			
			
		}
		
		
		
		
		
	}

	
	class BtMenu implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Acceuil a=new Acceuil();
			GAffichageBulletin.this.setVisible(false);
		}
	}
	
}


