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

import model.Person;

import controller.Client;
import controller.Controller;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;

import tools.dateTime;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ClientGUI extends JFrame {

	private JPanel contentPane;
	private static int JFRAME_WIDTH = 1440;
	private static int JFRAME_HEIGHT = 900;
	private JTextField txtEventTittel;
	private JTextField txtEventDato;
	private JTextField txtFraTid;
	private JTextField txtTilTid;
	private JTextField txtNavn;
	private JTextField txtRomNavn_1;
	private JTextField txtRomNavn;
	private JTextField txtTittel_1;
	private JTextField txtDato_1;
	private JTextField textField_2;
	private JTextField txtNavn_1;
	private Person user;
	private JTextField txtGruppeNavn;


	public ClientGUI(Person user, Client client) {
		this.user = user;
		
		
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
		btnNewButton.setBounds(178, 36, 89, 23);
		panel_8.add(btnNewButton);
		
		txtNavn_1 = new JTextField();
		txtNavn_1.setText("Person navn");
		txtNavn_1.setBounds(10, 36, 145, 20);
		panel_8.add(txtNavn_1);
		txtNavn_1.setColumns(10);
		
		JLabel lblPersonerIKalenderen = new JLabel("Personer i kalenderen");
		lblPersonerIKalenderen.setBounds(10, 234, 259, 14);
		panel_8.add(lblPersonerIKalenderen);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 259, 280, 185);
		panel_8.add(scrollPane_4);
		
		JButton btnFjernPerson = new JButton("Fjern person");
		btnFjernPerson.setBounds(10, 455, 108, 23);
		panel_8.add(btnFjernPerson);
		
		JLabel label = new JLabel("Legg til en gruppe");
		label.setBounds(10, 70, 195, 14);
		panel_8.add(label);
		
		txtGruppeNavn = new JTextField();
		txtGruppeNavn.setText("Gruppe navn");
		txtGruppeNavn.setColumns(10);
		txtGruppeNavn.setBounds(10, 95, 145, 20);
		panel_8.add(txtGruppeNavn);
		
		JButton button_2 = new JButton("Legg til");
		button_2.setBounds(178, 95, 89, 23);
		panel_8.add(button_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(322, 11, 1074, 488);
		panel_2.add(panel_9);
		
		JLabel lblMandag = new JLabel("Mandag");
		
		JLabel lblTirsdag = new JLabel("Tirsdag");
		
		JLabel lblOnsdag = new JLabel("Onsdag");
		
		JLabel lblTorsdag = new JLabel("Torsdag");
		
		JLabel lblFredag = new JLabel("Fredag");
		
		JLabel lblLrdag = new JLabel("L\u00F8rdag");
		
		JLabel lblSndag = new JLabel("S\u00F8ndag");
		
		JScrollPane scrollMandag = new JScrollPane();
		
		JList jLMandag = new JList();
		scrollMandag.setViewportView(jLMandag);
		
		JScrollPane scrollTirsdag = new JScrollPane();
		
		JList jLTirsdag = new JList();
		scrollTirsdag.setViewportView(jLTirsdag);
		
		JScrollPane scrollOnsdag = new JScrollPane();
		
		JList jLOnsdag = new JList();
		scrollOnsdag.setViewportView(jLOnsdag);
		
		JScrollPane scrollTorsdag = new JScrollPane();
		
		JList jLTorsdag = new JList();
		scrollTorsdag.setViewportView(jLTorsdag);
		
		JScrollPane scrollFredag = new JScrollPane();
		
		JList jLFredag = new JList();
		scrollFredag.setViewportView(jLFredag);
		
		JScrollPane scrollLordag = new JScrollPane();
		
		JList jLLordag = new JList();
		scrollLordag.setViewportView(jLLordag);
		
		JScrollPane scrollSondag = new JScrollPane();
		
		JList jLSondag = new JList();
		scrollSondag.setViewportView(jLSondag);
		
		JLabel lblVelgUke = new JLabel("Velg Uke:");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52"}));
		comboBox.setSelectedItem(String.valueOf(dateTime.now().getCalendarObj().get(Calendar.WEEK_OF_YEAR)));
		comboBox.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				
			}
		});
		comboBox.setToolTipText("Velg ukenummer");
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(50)
					.addComponent(lblMandag, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(lblTirsdag, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(lblOnsdag, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(lblTorsdag, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(lblFredag, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(lblLrdag, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(lblSndag, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollMandag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addComponent(scrollTirsdag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addComponent(scrollOnsdag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addComponent(scrollTorsdag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addComponent(scrollFredag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addComponent(scrollLordag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addComponent(scrollSondag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblVelgUke, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMandag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTirsdag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOnsdag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTorsdag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFredag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLrdag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSndag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollMandag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollTirsdag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollOnsdag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollTorsdag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollFredag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollLordag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollSondag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(4)
							.addComponent(lblVelgUke, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
		);
		panel_9.setLayout(gl_panel_9);
		
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
		
		txtEventTittel = new JTextField();
		txtEventTittel.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				if(txtEventTittel.getText().equals("tittel"))
					txtEventTittel.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEventTittel.getText().equals(""))
					txtEventTittel.setText("tittel");
			}
		});
		txtEventTittel.setText("tittel");
		txtEventTittel.setBounds(126, 8, 147, 20);
		panel_1.add(txtEventTittel);
		txtEventTittel.setColumns(10);
		
		JLabel lblDato = new JLabel("Dato");
		lblDato.setBounds(10, 38, 63, 14);
		panel_1.add(lblDato);
		
		txtEventDato = new JTextField();
		txtEventDato.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEventDato.getText().equals("dato"))
					txtEventDato.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEventDato.getText().equals(""))
					txtEventDato.setText("dato");
			}
		});
		txtEventDato.setText("dato");
		txtEventDato.setColumns(10);
		txtEventDato.setBounds(126, 39, 147, 20);
		panel_1.add(txtEventDato);

		JLabel lblTidspunkt = new JLabel("Tidspunkt");
		lblTidspunkt.setBounds(10, 74, 63, 14);
		panel_1.add(lblTidspunkt);

		txtFraTid = new JTextField();
		txtFraTid.setText("fra");
		txtFraTid.setColumns(10);
		txtFraTid.setBounds(126, 70, 64, 20);
		panel_1.add(txtFraTid);
		
		txtTilTid = new JTextField();
		txtTilTid.setText("til");
		txtTilTid.setColumns(10);
		txtTilTid.setBounds(210, 71, 63, 20);
		panel_1.add(txtTilTid);
		
		JLabel lblInvitertePersoner = new JLabel("Inviterte personer");
		lblInvitertePersoner.setBounds(10, 99, 106, 14);
		panel_1.add(lblInvitertePersoner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 105, 147, 95);
		panel_1.add(scrollPane);
		
		JLabel lblLeggTilAnsatt = new JLabel("Legg til person");
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
		txtNavn.setText("Person navn");
		txtNavn.setBounds(106, 211, 94, 20);
		panel_1.add(txtNavn);
		txtNavn.setColumns(10);
		
		JButton btnLeggTilPersonTilEvent = new JButton("Legg til");
		btnLeggTilPersonTilEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLeggTilPersonTilEvent.setBounds(200, 211, 73, 23);
		panel_1.add(btnLeggTilPersonTilEvent);
		
		JLabel lblLeggTilEkstern = new JLabel("Legg til ekstern");
		lblLeggTilEkstern.setBounds(10, 241, 94, 14);
		panel_1.add(lblLeggTilEkstern);
		
		txtRomNavn_1 = new JTextField();
		txtRomNavn_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtRomNavn_1.getText().equals("navn"))
					txtRomNavn_1.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtRomNavn_1.getText().equals(""))
					txtRomNavn_1.setText("navn");
			}
		});
		txtRomNavn_1.setText("Rom navn");
		txtRomNavn_1.setColumns(10);
		txtRomNavn_1.setBounds(106, 238, 94, 20);
		panel_1.add(txtRomNavn_1);
		
		JButton btnLeggTilRomTilEvent = new JButton("Legg til");
		btnLeggTilRomTilEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLeggTilRomTilEvent.setBounds(442, 182, 73, 23);
		panel_1.add(btnLeggTilRomTilEvent);
		
		JLabel lblLedigeRom = new JLabel("Ledige rom");
		lblLedigeRom.setBounds(313, 11, 76, 14);
		panel_1.add(lblLedigeRom);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(383, 38, 202, 95);
		panel_1.add(scrollPane_1);
		
		JLabel lblLeggTilRom = new JLabel("Legg til rom");
		lblLeggTilRom.setBounds(313, 164, 63, 14);
		panel_1.add(lblLeggTilRom);
		
		txtRomNavn = new JTextField();
		txtRomNavn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtRomNavn.getText().equals("navn"))
					txtRomNavn.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtRomNavn.getText().equals(""))
					txtRomNavn.setText("navn");
			}
		});
		txtRomNavn.setText("Rom navn");
		txtRomNavn.setColumns(10);
		txtRomNavn.setBounds(383, 164, 132, 20);
		panel_1.add(txtRomNavn);
		
		JButton btnLeggTilEksternTilEvent = new JButton("Legg til");
		btnLeggTilEksternTilEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLeggTilEksternTilEvent.setBounds(200, 237, 73, 23);
		panel_1.add(btnLeggTilEksternTilEvent);
		
		JLabel lblBeskrivelse = new JLabel("Beskrivelse");
		lblBeskrivelse.setBounds(586, 11, 74, 14);
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
		
		JLabel lblValgtRom = new JLabel("Valgt rom");
		lblValgtRom.setBounds(313, 216, 97, 14);
		panel_1.add(lblValgtRom);
		
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
