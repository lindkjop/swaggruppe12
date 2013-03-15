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
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\cygwin\\home\\Tibor\\Git\\swaggruppe12\\SwagCal\\src\\gui\\swagLogo.png"));
		lblNewLabel.setBounds(10, 11, 414, 126);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(215, 196, 209, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(215, 165, 209, 20);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Logg p\u00E5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(338, 227, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblBrukernav = new JLabel("Passord");
		lblBrukernav.setBounds(108, 199, 97, 14);
		getContentPane().add(lblBrukernav);
		
		JLabel lblBrukernavn = new JLabel("Brukernavn");
		lblBrukernavn.setBounds(108, 168, 97, 14);
		getContentPane().add(lblBrukernavn);
		
		JLabel lblNewLabel_1 = new JLabel("CALENDAR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 137, 414, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setBounds(10, 231, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(45, 228, 62, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}

	}
}
