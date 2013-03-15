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
import javax.swing.JList;
import javax.swing.JComboBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ClientGUI extends JFrame {

	private JPanel contentPane;
	private static int JFRAME_WIDTH = 1440;
	private static int JFRAME_HEIGHT = 900;
	private JTextField txtTittel;
	private JTextField txtDato;
	private JTextField txtFra;
	private JTextField txtTil;
	private JTextField txtNavn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtTittel_1;
	private JTextField txtDato_1;
	private JTextField textField_2;
	private JTextField txtNavn_1;


	public ClientGUI() {
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
		panel.setBounds(10, 11, 320, 320);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAvsel = new JLabel("Varsler");
		lblAvsel.setBounds(10, 11, 46, 14);
		panel.add(lblAvsel);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 36, 300, 272);
		panel.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("mottatt", null, panel_5, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("sendt", (Icon) null, panel_4, null);
		tabbedPane_1.setBackgroundAt(1, Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(10, 341, 1404, 510);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 11, 300, 488);
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblLeggTilPersoner = new JLabel("Legg til personer i kalenderen");
		lblLeggTilPersoner.setBounds(10, 11, 195, 14);
		panel_8.add(lblLeggTilPersoner);
		
		JButton btnNewButton = new JButton("Legg til");
		btnNewButton.setBounds(180, 50, 89, 23);
		panel_8.add(btnNewButton);
		
		txtNavn_1 = new JTextField();
		txtNavn_1.setText("navn");
		txtNavn_1.setBounds(10, 51, 145, 20);
		panel_8.add(txtNavn_1);
		txtNavn_1.setColumns(10);
		
		JLabel lblPersonerIKalenderen = new JLabel("Personer i kalenderen");
		lblPersonerIKalenderen.setBounds(10, 119, 259, 14);
		panel_8.add(lblPersonerIKalenderen);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 144, 280, 300);
		panel_8.add(scrollPane_4);
		
		JButton btnFjernPerson = new JButton("Fjern person");
		btnFjernPerson.setBounds(10, 455, 108, 23);
		panel_8.add(btnFjernPerson);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(322, 11, 1074, 488);
		panel_2.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblMandag = new JLabel("Mandag");
		lblMandag.setBounds(50, 6, 61, 16);
		panel_9.add(lblMandag);
		
		JLabel lblTirsdag = new JLabel("Tirsdag");
		lblTirsdag.setBounds(170, 6, 61, 16);
		panel_9.add(lblTirsdag);
		
		JLabel lblOnsdag = new JLabel("Onsdag");
		lblOnsdag.setBounds(300, 6, 61, 16);
		panel_9.add(lblOnsdag);
		
		JLabel lblTorsdag = new JLabel("Torsdag");
		lblTorsdag.setBounds(430, 6, 61, 16);
		panel_9.add(lblTorsdag);
		
		JLabel lblFredag = new JLabel("Fredag");
		lblFredag.setBounds(560, 6, 61, 16);
		panel_9.add(lblFredag);
		
		JLabel lblLrdag = new JLabel("L\u00F8rdag");
		lblLrdag.setBounds(690, 6, 61, 16);
		panel_9.add(lblLrdag);
		
		JLabel lblSndag = new JLabel("S\u00F8ndag");
		lblSndag.setBounds(820, 6, 61, 16);
		panel_9.add(lblSndag);
		
		JScrollPane scrollMandag = new JScrollPane();
		scrollMandag.setBounds(10, 50, 130, 400);
		panel_9.add(scrollMandag);
		
		JList jLMandag = new JList();
		scrollMandag.setViewportView(jLMandag);
		
		JScrollPane scrollTirsdag = new JScrollPane();
		scrollTirsdag.setBounds(140, 50, 130, 400);
		panel_9.add(scrollTirsdag);
		
		JList jLTirsdag = new JList();
		scrollTirsdag.setViewportView(jLTirsdag);
		
		JScrollPane scrollOnsdag = new JScrollPane();
		scrollOnsdag.setBounds(270, 50, 130, 400);
		panel_9.add(scrollOnsdag);
		
		JList jLOnsdag = new JList();
		scrollOnsdag.setViewportView(jLOnsdag);
		
		JScrollPane scrollTorsdag = new JScrollPane();
		scrollTorsdag.setBounds(400, 50, 130, 400);
		panel_9.add(scrollTorsdag);
		
		JList jLTorsdag = new JList();
		scrollTorsdag.setViewportView(jLTorsdag);
		
		JScrollPane scrollFredag = new JScrollPane();
		scrollFredag.setBounds(530, 50, 130, 400);
		panel_9.add(scrollFredag);
		
		JList jLFredag = new JList();
		scrollFredag.setViewportView(jLFredag);
		
		JScrollPane scrollLordag = new JScrollPane();
		scrollLordag.setBounds(660, 50, 130, 400);
		panel_9.add(scrollLordag);
		
		JList jLLordag = new JList();
		scrollLordag.setViewportView(jLLordag);
		
		JScrollPane scrollSondag = new JScrollPane();
		scrollSondag.setBounds(790, 50, 130, 400);
		panel_9.add(scrollSondag);
		
		JList jLSondag = new JList();
		scrollSondag.setViewportView(jLSondag);
		
		JLabel lblVelgUke = new JLabel("Velg Uke:");
		lblVelgUke.setBounds(932, 52, 61, 16);
		panel_9.add(lblVelgUke);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				
			}
		});
		comboBox.setToolTipText("Velg ukenummer");
		comboBox.setBounds(993, 48, 75, 27);
		panel_9.add(comboBox);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.setBounds(334, 11, 1080, 320);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1080, 320);
		panel_6.add(tabbedPane);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setToolTipText("");
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
		txtTittel.setBounds(126, 8, 147, 20);
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
		txtDato.setBounds(126, 39, 147, 20);
		panel_1.add(txtDato);

		JLabel lblTidspunkt = new JLabel("Tidspunkt");
		lblTidspunkt.setBounds(10, 74, 63, 14);
		panel_1.add(lblTidspunkt);

		txtFra = new JTextField();
		txtFra.setText("fra");
		txtFra.setColumns(10);
		txtFra.setBounds(126, 70, 64, 20);
		panel_1.add(txtFra);
		
		txtTil = new JTextField();
		txtTil.setText("til");
		txtTil.setColumns(10);
		txtTil.setBounds(210, 71, 63, 20);
		panel_1.add(txtTil);
		
		JLabel lblInvitertePersoner = new JLabel("Inviterte personer");
		lblInvitertePersoner.setBounds(10, 99, 106, 14);
		panel_1.add(lblInvitertePersoner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 105, 147, 95);
		panel_1.add(scrollPane);
		
		JLabel lblLeggTilAnsatt = new JLabel("Legg til ansatt");
		lblLeggTilAnsatt.setBounds(10, 216, 97, 14);
		panel_1.add(lblLeggTilAnsatt);
		
		txtNavn = new JTextField();
		txtNavn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNavn.getText().equals("navn"))
					txtNavn.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNavn.getText().equals(""))
					txtNavn.setText("navn");
			}
		});
		txtNavn.setText("navn");
		txtNavn.setBounds(106, 211, 94, 20);
		panel_1.add(txtNavn);
		txtNavn.setColumns(10);
		
		JButton btnLeggTil = new JButton("Legg til");
		btnLeggTil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLeggTil.setBounds(200, 211, 73, 23);
		panel_1.add(btnLeggTil);
		
		JLabel lblLeggTilEkstern = new JLabel("Legg til ekstern");
		lblLeggTilEkstern.setBounds(10, 241, 94, 14);
		panel_1.add(lblLeggTilEkstern);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("navn"))
					textField.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals(""))
					textField.setText("navn");
			}
		});
		textField.setText("navn");
		textField.setColumns(10);
		textField.setBounds(106, 238, 94, 20);
		panel_1.add(textField);
		
		JButton button = new JButton("Legg til");
		button.setBounds(442, 200, 73, 23);
		panel_1.add(button);
		
		JLabel lblLedigeRom = new JLabel("Ledige rom");
		lblLedigeRom.setBounds(313, 11, 76, 14);
		panel_1.add(lblLedigeRom);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(313, 38, 202, 95);
		panel_1.add(scrollPane_1);
		
		JLabel lblLeggTilRom = new JLabel("Legg til rom");
		lblLeggTilRom.setBounds(313, 183, 63, 14);
		panel_1.add(lblLeggTilRom);
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_1.getText().equals("navn"))
					textField_1.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().equals(""))
					textField_1.setText("navn");
			}
		});
		textField_1.setText("navn");
		textField_1.setColumns(10);
		textField_1.setBounds(383, 180, 132, 20);
		panel_1.add(textField_1);
		
		JButton button_1 = new JButton("Legg til");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(200, 237, 73, 23);
		panel_1.add(button_1);
		
		JLabel lblBeskrivelse = new JLabel("Beskrivelse");
		lblBeskrivelse.setBounds(565, 11, 74, 14);
		panel_1.add(lblBeskrivelse);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(649, 11, 402, 214);
		panel_1.add(scrollPane_2);
		
		JTextPane txtpnTekst = new JTextPane();
		txtpnTekst.addFocusListener(new FocusAdapter() {
		});
		scrollPane_2.setViewportView(txtpnTekst);
		txtpnTekst.setText("tekst");
		
		JButton btnEndre = new JButton("Endre avtale");
		btnEndre.setBounds(777, 250, 130, 23);
		panel_1.add(btnEndre);
		
		JButton btnLalala = new JButton("Ny Avtale");
		btnLalala.setBounds(931, 250, 130, 23);
		panel_1.add(btnLalala);
		
		JButton btnVelgRom = new JButton("Velg rom");
		btnVelgRom.setBounds(442, 132, 73, 23);
		panel_1.add(btnVelgRom);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Alarm", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblAlarmer = new JLabel("Alarmer");
		lblAlarmer.setBounds(32, 37, 46, 14);
		panel_3.add(lblAlarmer);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(32, 62, 123, 217);
		panel_3.add(scrollPane_3);
		
		JLabel lblTittel = new JLabel("Tittel");
		lblTittel.setBounds(185, 37, 46, 14);
		panel_3.add(lblTittel);
		
		txtTittel_1 = new JTextField();
		txtTittel_1.setText("tittel");
		txtTittel_1.setBounds(257, 34, 86, 20);
		panel_3.add(txtTittel_1);
		txtTittel_1.setColumns(10);
		
		JLabel lblDato_1 = new JLabel("Dato");
		lblDato_1.setBounds(185, 70, 46, 14);
		panel_3.add(lblDato_1);
		
		txtDato_1 = new JTextField();
		txtDato_1.setText("dato");
		txtDato_1.setColumns(10);
		txtDato_1.setBounds(257, 67, 86, 20);
		panel_3.add(txtDato_1);
		
		JLabel lblTidspunkt_1 = new JLabel("Tidspunkt");
		lblTidspunkt_1.setBounds(185, 107, 62, 14);
		panel_3.add(lblTidspunkt_1);
		
		textField_2 = new JTextField();
		textField_2.setText("12:00");
		textField_2.setColumns(10);
		textField_2.setBounds(257, 104, 86, 20);
		panel_3.add(textField_2);
		
		JLabel lblBeskrivelse_1 = new JLabel("Beskrivelse");
		lblBeskrivelse_1.setBounds(185, 132, 62, 14);
		panel_3.add(lblBeskrivelse_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(257, 135, 203, 94);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JTextPane txtpnTekst_1 = new JTextPane();
		txtpnTekst_1.setBounds(6, 16, 191, 71);
		panel_7.add(txtpnTekst_1);
		txtpnTekst_1.setText("tekst");
		
		JButton btnEndreAlarm = new JButton("Endre Alarm");
		btnEndreAlarm.setBounds(257, 240, 106, 23);
		panel_3.add(btnEndreAlarm);
		
		JButton btnNyAlarm = new JButton("Ny Alarm");
		btnNyAlarm.setBounds(373, 240, 89, 23);
		panel_3.add(btnNyAlarm);
		
		
		
		
	}
}
