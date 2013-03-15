package gui;

import gui.actions.LoggOn;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Person;

import controller.Client;
import controller.Controller;


public class LoginGUI extends JFrame {
	private JTextField passwordField;
	private JTextField usernameField;
	private JTextField statusField;
	private Person user;
	private Client client;
	
	
	public LoginGUI(final Person user, Client c) {
		this.client = c;
		this.user = user;

		this.setSize(500, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(mkIcon("swagLogo.png"));
		lblNewLabel.setBounds(10, 11, 464, 126);
		getContentPane().add(lblNewLabel);
		
		passwordField = new JTextField();
		passwordField.setBounds(265, 196, 209, 20);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(265, 165, 209, 20);
		getContentPane().add(usernameField);
		
		JButton LoggOnButton = new JButton("Logg p\u00E5");
		LoggOnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoggOn lg = new LoggOn(usernameField.getText(),passwordField.getText(),user,client);
				if(lg.getSucsess()){
					System.out.println("DU HAR LOGGET INN, I DONT CARE");
					client.setWorkFrame();
					dispose();
				}
			}
		});
		LoggOnButton.setBounds(385, 227, 89, 23);
		getContentPane().add(LoggOnButton);
		
		JLabel lblBrukernav = new JLabel("Passord");
		lblBrukernav.setBounds(158, 199, 97, 14);
		getContentPane().add(lblBrukernav);
		
		JLabel lblBrukernavn = new JLabel("Brukernavn");
		lblBrukernavn.setBounds(158, 168, 97, 14);
		getContentPane().add(lblBrukernavn);
		
		JLabel lblNewLabel_1 = new JLabel("CALENDAR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 137, 464, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setBounds(10, 231, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		statusField = new JTextField();
		statusField.setEditable(false);
		statusField.setBounds(45, 228, 209, 20);
		getContentPane().add(statusField);
		statusField.setColumns(10);
	}
	
	protected ImageIcon mkIcon (String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Noe gikk galt ved lasting av bildet");
			return null;
		}
	}
	
	public void setStatus(String status){
		statusField.setText(status);
	}

}

