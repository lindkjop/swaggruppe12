package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Calandar extends JFrame {

	private JPanel contentPane;
	private static int JFRAME_WIDTH = 1260;
	private static int JFRAME_HEIGHT = 780;
	private JTextField txtTittel;
	private JTextField txtDato;
	private JTextField txtFra;
	private JTextField txtTil;
	private JTextField txtNavn;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calandar frame = new Calandar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**	
	 * Create the frame.
	 */
	public Calandar() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, JFRAME_WIDTH, JFRAME_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 21, 320, 256);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAvsel = new JLabel("Varsler");
		lblAvsel.setBounds(10, 11, 46, 14);
		panel.add(lblAvsel);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 36, 300, 209);
		panel.add(tabbedPane_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("sendt", (Icon) null, panel_4, null);
		tabbedPane_1.setBackgroundAt(0, Color.WHITE);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("mottatt", null, panel_5, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(10, 288, 1224, 443);
		contentPane.add(panel_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(340, 21, 894, 256);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 894, 256);
		panel_6.add(tabbedPane);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setToolTipText("lol");
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Avtale", null, panel_1, null);
		tabbedPane.setEnabledAt(0, true);
		panel_1.setLayout(null);
		
		JLabel lblAvtaletittel = new JLabel("AvtaleTittel");
		lblAvtaletittel.setBounds(10, 11, 63, 14);
		panel_1.add(lblAvtaletittel);
		
		txtTittel = new JTextField();
		txtTittel.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				if(txtTittel.getText().equals("tittel"))
					txtTittel.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTittel.getText().equals(""))
					txtTittel.setText("tittel");
			}
		});
		txtTittel.setText("tittel");
		txtTittel.setBounds(126, 8, 132, 20);
		panel_1.add(txtTittel);
		txtTittel.setColumns(10);
		
		JLabel lblDato = new JLabel("Dato");
		lblDato.setBounds(10, 38, 63, 14);
		panel_1.add(lblDato);
		
		txtDato = new JTextField();
		txtDato.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtDato.getText().equals("dato"))
					txtDato.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtDato.getText().equals(""))
					txtDato.setText("dato");
			}
		});
		txtDato.setText("dato");
		txtDato.setColumns(10);
		txtDato.setBounds(126, 39, 132, 20);
		panel_1.add(txtDato);
		
		JLabel lblTidspunkt = new JLabel("Tidspunkt");
		lblTidspunkt.setBounds(10, 74, 63, 14);
		panel_1.add(lblTidspunkt);
		
		txtFra = new JTextField();
		txtFra.setText("fra");
		txtFra.setColumns(10);
		txtFra.setBounds(126, 70, 56, 20);
		panel_1.add(txtFra);
		
		txtTil = new JTextField();
		txtTil.setText("til");
		txtTil.setColumns(10);
		txtTil.setBounds(202, 71, 56, 20);
		panel_1.add(txtTil);
		
		JLabel lblInvitertePersoner = new JLabel("Inviterte personer");
		lblInvitertePersoner.setBounds(10, 99, 97, 14);
		panel_1.add(lblInvitertePersoner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 101, 132, 81);
		panel_1.add(scrollPane);
		
		JLabel lblLeggTilAnsatt = new JLabel("Legg til ansatt");
		lblLeggTilAnsatt.setBounds(10, 201, 97, 14);
		panel_1.add(lblLeggTilAnsatt);
		
		txtNavn = new JTextField();
		txtNavn.setText("navn");
		txtNavn.setBounds(96, 198, 86, 20);
		panel_1.add(txtNavn);
		txtNavn.setColumns(10);
		
		JButton btnLeggTil = new JButton("Legg til");
		btnLeggTil.setBounds(192, 197, 73, 23);
		panel_1.add(btnLeggTil);
		
		JLabel lblLeggTilEkstern = new JLabel("Legg til ekstern");
		lblLeggTilEkstern.setBounds(283, 201, 97, 14);
		panel_1.add(lblLeggTilEkstern);
		
		textField = new JTextField();
		textField.setText("navn");
		textField.setColumns(10);
		textField.setBounds(373, 198, 86, 20);
		panel_1.add(textField);
		
		JButton button = new JButton("Legg til");
		button.setBounds(360, 127, 73, 23);
		panel_1.add(button);
		
		JLabel lblLedigeRom = new JLabel("Ledige rom");
		lblLedigeRom.setBounds(289, 11, 63, 14);
		panel_1.add(lblLedigeRom);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(360, 11, 132, 81);
		panel_1.add(scrollPane_1);
		
		JLabel lblLeggTilRom = new JLabel("Legg til rom");
		lblLeggTilRom.setBounds(283, 99, 63, 14);
		panel_1.add(lblLeggTilRom);
		
		textField_1 = new JTextField();
		textField_1.setText("navn");
		textField_1.setColumns(10);
		textField_1.setBounds(360, 96, 132, 20);
		panel_1.add(textField_1);
		
		JButton button_1 = new JButton("Legg til");
		button_1.setBounds(474, 197, 73, 23);
		panel_1.add(button_1);
		
		JLabel lblBeskrivelse = new JLabel("Beskrivelse");
		lblBeskrivelse.setBounds(512, 11, 63, 14);
		panel_1.add(lblBeskrivelse);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(585, 11, 292, 171);
		panel_1.add(scrollPane_2);
		
		JTextPane txtpnTekst = new JTextPane();
		txtpnTekst.setText("tekst");
		scrollPane_2.setViewportView(txtpnTekst);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Alarm", null, panel_3, null);
		
		JButton btnLol = new JButton("LOL");
		panel_3.add(btnLol);
		
		
		
		
	}
}
