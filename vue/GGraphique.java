package vue;


import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import controleur.*;
import javafx.scene.chart.Chart;
import model.*;
import net.proteanit.sql.DbUtils;
import vue.*;
import vue.GBulletin.BSuppIdListener;
import vue.GClasse.BtMenu;

public class GGraphique extends JFrame implements ActionListener {
	    
	    
	    private JButton btn;
	    private Connexion con;
	    
		public GGraphique(Connexion con)  {
			super("Gestion Annee");
			
				
			setTitle("Gestion Bulletin");
			getContentPane().setForeground(Color.BLACK);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(840,651);
			//position au centre
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			
			 btn = new JButton("Supprimer");
			btn.setBounds(96, 421, 141, 35);
			btn.addActionListener(this);
			getContentPane().add(btn);
			
			this.setVisible(true);
		
			
			
	
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btn)
			{
				try {
					con=new Connexion();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BulletinDAO b=new BulletinDAO(con);
				DetailbulletinDAO d=new DetailbulletinDAO(con);
				DetailbulletinDAO dao=new DetailbulletinDAO(con);
				
				
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				
				System.out.println(b.detailAll(1).size());
				
				int lol=b.detailAll(1).size();
				/*
				for(int i=1;i<=lol;i++)
				{
					tabd.get(i).setMoyenne(dao.moyenneDiscipline(i));
					
					dcd.setValue(tabd.get(i).getMoyenne(),"",tabd.get(i).getEnseignement().getDiscipline().getNom());
					d=new DetailbulletinDAO(con);
				}
					*/
					
				
				
				JFreeChart j=ChartFactory.createBarChart("", "Discipline","Note", dcd);
				CategoryPlot plot=j.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.black);
				
				ChartFrame c=new ChartFrame("Note global",j,true);
				c.setSize(500,400);
				c.setVisible(true);
			}
		}

	
		
		
		
	
}
