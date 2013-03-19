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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class ClientGUI extends JFrame {

	private JPanel contentPane;
	private static int JFRAME_WIDTH = 1440;
	private static int JFRAME_HEIGHT = 900;
	private JTextField txtEventTittel;
	private JTextField txtEventDato;
	private JTextField txtFraTid;
	private JTextField txtTilTid;
	private JTextField txtNavn;
	private JTextField txtPerson_extern;
	private JTextField txtRomNavn;
	private JTextField txtAlarmTittel;
	private JTextField txtAlarmDato;
	private JTextField textAlarmTidspunkt;
	private JTextField txtNavn_1;
	private Person user;
	private JTextField txtGruppeNavn;
	private JTextField textEksternNavn;


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
		
		JPanel NotificationPanel = new JPanel();
		NotificationPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		NotificationPanel.setBounds(10, 11, 320, 320);
		contentPane.add(NotificationPanel);
		NotificationPanel.setLayout(null);
		
		JLabel lblVarsel = new JLabel("Varsler");
		lblVarsel.setBounds(10, 11, 46, 14);
		NotificationPanel.add(lblVarsel);
		
		JTabbedPane NotificationTab = new JTabbedPane(JTabbedPane.TOP);
		NotificationTab.setBounds(10, 36, 300, 272);
		NotificationPanel.add(NotificationTab);
		
		JPanel Motatt = new JPanel();
		NotificationTab.addTab("Mottatt", null, Motatt, null);
		
		JPanel Sendt = new JPanel();
		NotificationTab.addTab("Sendt", (Icon) null, Sendt, null);
		NotificationTab.setBackgroundAt(1, Color.WHITE);
		
		JPanel StorUnderpanel = new JPanel();
		StorUnderpanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		StorUnderpanel.setBounds(10, 341, 1404, 510);
		contentPane.add(StorUnderpanel);
		StorUnderpanel.setLayout(null);
		
		JPanel LeggTilPersonPanel = new JPanel();
		LeggTilPersonPanel.setBounds(10, 11, 300, 488);
		StorUnderpanel.add(LeggTilPersonPanel);
		LeggTilPersonPanel.setLayout(null);
		
		JLabel lblLeggTilPersoner = new JLabel("Legg til personer i kalenderen");
		lblLeggTilPersoner.setBounds(10, 11, 195, 14);
		LeggTilPersonPanel.add(lblLeggTilPersoner);
		
		JButton btnNewButton = new JButton("Legg til");
		btnNewButton.setBounds(178, 36, 89, 23);
		LeggTilPersonPanel.add(btnNewButton);
		
		txtNavn_1 = new JTextField();
		txtNavn_1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				if(txtNavn_1.getText().equals("Person navn"))
					txtNavn_1.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNavn_1.getText().equals(""))
					txtNavn_1.setText("Person navn");
			}
		});
		txtNavn_1.setText("Person navn");
		txtNavn_1.setBounds(10, 36, 145, 20);
		LeggTilPersonPanel.add(txtNavn_1);
		txtNavn_1.setColumns(10);
		
		JLabel lblPersonerIKalenderen = new JLabel("Personer i kalenderen");
		lblPersonerIKalenderen.setBounds(10, 234, 259, 14);
		LeggTilPersonPanel.add(lblPersonerIKalenderen);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 259, 280, 185);
		LeggTilPersonPanel.add(scrollPane_4);
		
		JButton btnFjernPerson = new JButton("Fjern person");
		btnFjernPerson.setBounds(10, 455, 108, 23);
		LeggTilPersonPanel.add(btnFjernPerson);
		
		JLabel label = new JLabel("Legg til en gruppe");
		label.setBounds(10, 70, 195, 14);
		LeggTilPersonPanel.add(label);
		
		txtGruppeNavn = new JTextField();
		txtGruppeNavn.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				if(txtGruppeNavn.getText().equals("Gruppe navn"))
					txtGruppeNavn.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtGruppeNavn.getText().equals(""))
					txtGruppeNavn.setText("Gruppe navn");
			}
		});
		txtGruppeNavn.setText("Gruppe navn");
		txtGruppeNavn.setColumns(10);
		txtGruppeNavn.setBounds(10, 95, 145, 20);
		LeggTilPersonPanel.add(txtGruppeNavn);
		
		JButton button_2 = new JButton("Legg til");
		button_2.setBounds(178, 95, 89, 23);
		LeggTilPersonPanel.add(button_2);
		
		JPanel KalenderPanel = new JPanel();
		KalenderPanel.setBounds(322, 11, 1074, 488);
		StorUnderpanel.add(KalenderPanel);
		
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
		
		JLabel lblMandagDato = new JLabel("New label");
		
		JLabel lblTirsdagDato = new JLabel("New label");
		
		JLabel lblOnsdagDato = new JLabel("New label");
		
		JLabel lblTorsdagDato = new JLabel("New label");
		
		JLabel lblFredagDato = new JLabel("New label");
		
		JLabel lblLordagDato = new JLabel("New label");
		
		JLabel lblSondagDato = new JLabel("New label");
		GroupLayout gl_KalenderPanel = new GroupLayout(KalenderPanel);
		gl_KalenderPanel.setHorizontalGroup(
			gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_KalenderPanel.createSequentialGroup()
					.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_KalenderPanel.createSequentialGroup()
							.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(scrollMandag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblMandagDato)))
							.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollTirsdag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTirsdagDato))
							.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollOnsdag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblOnsdagDato))
							.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollTorsdag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTorsdagDato))
							.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollFredag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFredagDato))
							.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollLordag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLordagDato))
							.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addComponent(scrollSondag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(lblVelgUke, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSondagDato))
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_KalenderPanel.createSequentialGroup()
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
							.addComponent(lblSndag, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
					.addGap(6))
		);
		gl_KalenderPanel.setVerticalGroup(
			gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_KalenderPanel.createSequentialGroup()
					.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_KalenderPanel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTirsdag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblMandag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblOnsdag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTorsdag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFredag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLrdag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSndag, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(gl_KalenderPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(scrollMandag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(scrollTirsdag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(scrollOnsdag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(scrollTorsdag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(scrollFredag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(scrollLordag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(scrollSondag, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_KalenderPanel.createSequentialGroup()
									.addGap(4)
									.addComponent(lblVelgUke, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_KalenderPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblMandagDato))
						.addGroup(gl_KalenderPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblTirsdagDato))
						.addGroup(gl_KalenderPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblOnsdagDato))
						.addGroup(gl_KalenderPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblTorsdagDato))
						.addGroup(gl_KalenderPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblFredagDato))
						.addGroup(gl_KalenderPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblLordagDato))
						.addGroup(gl_KalenderPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblSondagDato)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		KalenderPanel.setLayout(gl_KalenderPanel);
		
		JPanel EventPanel = new JPanel();
		EventPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		EventPanel.setBounds(334, 11, 1080, 320);
		contentPane.add(EventPanel);
		EventPanel.setLayout(null);
		
		JTabbedPane EventTab = new JTabbedPane(JTabbedPane.TOP);
		EventTab.setBounds(0, 0, 1080, 320);
		EventPanel.add(EventTab);
		EventTab.setBackground(Color.WHITE);
		EventTab.setToolTipText("");
		EventTab.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel AvtaleTab = new JPanel();
		EventTab.addTab("Avtale", null, AvtaleTab, null);
		EventTab.setEnabledAt(0, true);
		AvtaleTab.setLayout(null);
		
		JLabel lblAvtaletittel = new JLabel("AvtaleTittel");
		lblAvtaletittel.setBounds(10, 11, 63, 14);
		AvtaleTab.add(lblAvtaletittel);
		
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
		AvtaleTab.add(txtEventTittel);
		txtEventTittel.setColumns(10);
		
		JLabel lblDato = new JLabel("Dato");
		lblDato.setBounds(10, 38, 63, 14);
		AvtaleTab.add(lblDato);
		
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
		AvtaleTab.add(txtEventDato);

		JLabel lblTidspunkt = new JLabel("Tidspunkt");
		lblTidspunkt.setBounds(10, 74, 63, 14);
		AvtaleTab.add(lblTidspunkt);

		txtFraTid = new JTextField();
		txtFraTid.setText("fra");
		txtFraTid.setColumns(10);
		txtFraTid.setBounds(126, 70, 64, 20);
		AvtaleTab.add(txtFraTid);
		
		txtTilTid = new JTextField();
		txtTilTid.setText("til");
		txtTilTid.setColumns(10);
		txtTilTid.setBounds(210, 71, 63, 20);
		AvtaleTab.add(txtTilTid);
		
		JLabel lblInvitertePersoner = new JLabel("Inviterte personer");
		lblInvitertePersoner.setBounds(10, 99, 106, 14);
		AvtaleTab.add(lblInvitertePersoner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 105, 147, 95);
		AvtaleTab.add(scrollPane);
		
		JList invitertePersonerListe = new JList();
		scrollPane.setViewportView(invitertePersonerListe);
		
		JLabel lblLeggTilAnsatt = new JLabel("Legg til person");
		lblLeggTilAnsatt.setBounds(10, 216, 97, 14);
		AvtaleTab.add(lblLeggTilAnsatt);
		
		txtNavn = new JTextField();
		txtNavn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNavn.getText().equals("Person navn"))
					txtNavn.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNavn.getText().equals(""))
					txtNavn.setText("Person navn");
			}
		});
		txtNavn.setText("Person navn");
		txtNavn.setBounds(126, 211, 147, 20);
		AvtaleTab.add(txtNavn);
		txtNavn.setColumns(10);
		
		JButton btnLeggTilPersonTilEvent = new JButton("Legg til");
		btnLeggTilPersonTilEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLeggTilPersonTilEvent.setBounds(272, 211, 73, 23);
		AvtaleTab.add(btnLeggTilPersonTilEvent);
		
		JLabel lblLeggTilEkstern = new JLabel("Legg til ekstern");
		lblLeggTilEkstern.setBounds(10, 241, 94, 14);
		AvtaleTab.add(lblLeggTilEkstern);
		
		txtPerson_extern = new JTextField();
		txtPerson_extern.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPerson_extern.getText().equals("Person navn"))
					txtPerson_extern.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPerson_extern.getText().equals(""))
					txtPerson_extern.setText("Person navn");
			}
		});
		
		JButton btnLeggTilRomTilEvent = new JButton("Legg til");
		btnLeggTilRomTilEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLeggTilRomTilEvent.setBounds(512, 156, 73, 23);
		AvtaleTab.add(btnLeggTilRomTilEvent);

		JLabel lblLedigeRom = new JLabel("Ledige rom");
		lblLedigeRom.setBounds(313, 11, 76, 14);
		AvtaleTab.add(lblLedigeRom);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(383, 11, 202, 95);
		AvtaleTab.add(scrollPane_1);
		
		JList ledigRomListe = new JList();
		scrollPane_1.setViewportView(ledigRomListe);
		
		JLabel lblLeggTilRom = new JLabel("Legg til rom");
		lblLeggTilRom.setBounds(313, 137, 63, 14);
		AvtaleTab.add(lblLeggTilRom);
		
		txtRomNavn = new JTextField();
		txtRomNavn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtRomNavn.getText().equals("Rom navn"))
					txtRomNavn.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtRomNavn.getText().equals(""))
					txtRomNavn.setText("Rom navn");
			}
		});
		txtRomNavn.setText("Rom navn");
		txtRomNavn.setColumns(10);
		txtRomNavn.setBounds(383, 137, 202, 20);
		AvtaleTab.add(txtRomNavn);
		
		JButton btnLeggTilEksternTilEvent = new JButton("Legg til");
		btnLeggTilEksternTilEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLeggTilEksternTilEvent.setBounds(272, 237, 73, 23);
		AvtaleTab.add(btnLeggTilEksternTilEvent);
		
		JLabel lblBeskrivelse = new JLabel("Beskrivelse");
		lblBeskrivelse.setBounds(621, 11, 74, 14);
		AvtaleTab.add(lblBeskrivelse);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(687, 11, 369, 168);
		AvtaleTab.add(scrollPane_2);
		
		JTextPane textPane = new JTextPane();
		scrollPane_2.setViewportView(textPane);
		
		JButton btnVelgRom = new JButton("Velg rom");
		btnVelgRom.setBounds(512, 103, 73, 23);
		AvtaleTab.add(btnVelgRom);
		
		JLabel lblValgtRom = new JLabel("Valgt rom");
		lblValgtRom.setBounds(313, 186, 97, 14);
		AvtaleTab.add(lblValgtRom);
		
		JButton btnOppdaterAvtale = new JButton("Oppdater avtale");
		btnOppdaterAvtale.setBounds(974, 237, 89, 23);
		AvtaleTab.add(btnOppdaterAvtale);
		
		JButton btnNyAvtale = new JButton("Ny avtale");
		btnNyAvtale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNyAvtale.setBounds(875, 237, 89, 23);
		AvtaleTab.add(btnNyAvtale);
		
		JButton btnSlettAvtale = new JButton("Slett avtale");
		btnSlettAvtale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSlettAvtale.setBounds(776, 237, 89, 23);
		AvtaleTab.add(btnSlettAvtale);
		
		JLabel lblValtRom = new JLabel("Ingen");
		lblValtRom.setBounds(383, 186, 202, 14);
		AvtaleTab.add(lblValtRom);
		
		textEksternNavn = new JTextField();
		textEksternNavn.setText("Ekstern navn");
		textEksternNavn.setBounds(126, 238, 147, 20);
		AvtaleTab.add(textEksternNavn);
		textEksternNavn.setColumns(10);
		
		JPanel AlarmTab = new JPanel();
		EventTab.addTab("Alarm", null, AlarmTab, null);
		AlarmTab.setLayout(null);
		
		JLabel lblAlarmer = new JLabel("Alarmer");
		lblAlarmer.setBounds(32, 11, 46, 14);
		AlarmTab.add(lblAlarmer);
		
		JScrollPane scrollPaneAlarmListe = new JScrollPane();
		scrollPaneAlarmListe.setBounds(32, 36, 123, 217);
		AlarmTab.add(scrollPaneAlarmListe);
		
		JLabel lblTittel = new JLabel("Tittel");
		lblTittel.setBounds(185, 11, 46, 14);
		AlarmTab.add(lblTittel);
		
		txtAlarmTittel = new JTextField();
		txtAlarmTittel.setText("tittel");
		txtAlarmTittel.setBounds(257, 8, 86, 20);
		AlarmTab.add(txtAlarmTittel);
		txtAlarmTittel.setColumns(10);
		
		JLabel lblDato_1 = new JLabel("Dato");
		lblDato_1.setBounds(185, 39, 46, 14);
		AlarmTab.add(lblDato_1);
		
		txtAlarmDato = new JTextField();
		txtAlarmDato.setText("dato");
		txtAlarmDato.setColumns(10);
		txtAlarmDato.setBounds(257, 36, 86, 20);
		AlarmTab.add(txtAlarmDato);
		
		JLabel lblTidspunkt_1 = new JLabel("Tidspunkt");
		lblTidspunkt_1.setBounds(185, 70, 62, 14);
		AlarmTab.add(lblTidspunkt_1);
		
		textAlarmTidspunkt = new JTextField();
		textAlarmTidspunkt.setText("12:00");
		textAlarmTidspunkt.setColumns(10);
		textAlarmTidspunkt.setBounds(257, 67, 86, 20);
		AlarmTab.add(textAlarmTidspunkt);
		
		JLabel lblBeskrivelse_1 = new JLabel("Beskrivelse");
		lblBeskrivelse_1.setBounds(185, 95, 62, 14);
		AlarmTab.add(lblBeskrivelse_1);
		
		JButton btnOppdaterAlarm = new JButton("Oppdater Alarm");
		btnOppdaterAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOppdaterAlarm.setBounds(368, 240, 131, 23);
		AlarmTab.add(btnOppdaterAlarm);
		
		JButton btnNyAlarm = new JButton("Ny Alarm");
		btnNyAlarm.setBounds(974, 240, 89, 23);
		AlarmTab.add(btnNyAlarm);
		
		JTextArea textAlarmBeskrivelse = new JTextArea();
		textAlarmBeskrivelse.setBounds(257, 98, 238, 122);
		AlarmTab.add(textAlarmBeskrivelse);
		
		
		
		
	}
}
