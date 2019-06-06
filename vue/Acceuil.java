package vue;

import java.awt.Color;

import javax.swing.*;

import model.Connexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acceuil extends JFrame {

	private Connexion con;
	
	
	public  Acceuil() {
		super("Acceuil");
		getContentPane().setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(735,580);
		//position au centre
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton button = new JButton("New button");
		button.setBounds(28, 57, 141, 135);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(189, 60, 141, 135);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(351, 57, 141, 135);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(513, 57, 141, 135);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(28, 216, 141, 135);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(189, 216, 141, 135);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(351, 213, 141, 135);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(513, 216, 141, 135);
		getContentPane().add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(28, 372, 141, 135);
		getContentPane().add(button_8);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(189, 372, 141, 135);
		getContentPane().add(button_9);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(351, 372, 141, 135);
		getContentPane().add(button_10);
		
		JButton button_11 = new JButton("New button");
		button_11.setBounds(513, 372, 141, 135);
		getContentPane().add(button_11);
		setResizable(false);
		
		this.setVisible(true);	
		
	}
}
