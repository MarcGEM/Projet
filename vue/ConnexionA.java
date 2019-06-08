package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Connexion;

public class ConnexionA extends JFrame {
	JLabel LblFond ;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private Connexion con;
	private JOptionPane a=new JOptionPane();
	private JTextField textField_2;
	
	
	public ConnexionA() {
		super("Connexion");
		getContentPane().setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(485,341);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Nom Serveur");
		lblNewLabel.setBounds(58, 57, 133, 26);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(238, 54, 186, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Identification ");
		lblNewLabel_1.setBounds(137, 21, 141, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom BD");
		lblNewLabel_2.setBounds(58, 104, 92, 26);
		getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 101, 186, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("MDP");
		lblNewLabel_3.setBounds(58, 205, 92, 26);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(150, 250, 141, 35);
		btnConnexion.addActionListener(new ButtonCoListener());
		getContentPane().add(btnConnexion);
		
		LblFond = new JLabel("");
		LblFond.setBackground(Color.WHITE);
		LblFond.setBounds(0, 0, 479, 290);
		getContentPane().add(LblFond);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 202, 186, 32);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\compaore\\eclipse-workspace\\Projet\\images\\icons8-user-male-30.png"));
		lblNewLabel_4.setBounds(426, 57, 32, 26);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\compaore\\eclipse-workspace\\Projet\\images\\icons8-secure-30.png"));
		lblNewLabel_5.setBounds(432, 157, 26, 26);
		getContentPane().add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(238, 149, 186, 32);
		getContentPane().add(textField_2);
		
		JLabel lblLogin = new JLabel("Login\r\n");
		lblLogin.setBounds(58, 157, 92, 26);
		getContentPane().add(lblLogin);
		
		this.setVisible(true);
		
		
	}
	
	//methode qui ecoutera le button1
		class ButtonCoListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				String nomServer = textField.getText();
				String nomDB=textField_1.getText();
				String login=textField_2.getText();
				String Mdp = passwordField.getText();
				
				
				try {
				con = new Connexion(nomDB,nomServer,login,Mdp);
				Acceuil A = new Acceuil();
				ConnexionA.this.setVisible(false);
				
				
				}catch(Exception d) {
					d.getMessage();
					System.out.println("non");
					
					a.showMessageDialog(a, "Erreur veuillez ressaisir","Erreur Connexion",a.WARNING_MESSAGE);
				}
				
				
				
				
			}
			
		}
}
