package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class LoginGUI extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	
	public LoginGUI() {
		this.setSize(500, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(mkIcon("swagLogo.png"));
		lblNewLabel.setBounds(10, 11, 464, 126);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(265, 196, 209, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(265, 165, 209, 20);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Logg p\u00E5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(385, 227, 89, 23);
		getContentPane().add(btnNewButton);
		
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
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(45, 228, 209, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
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
		textField_2.setText(status);
	}

}

