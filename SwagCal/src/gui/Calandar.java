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

public class Calandar extends JFrame {

	private JPanel contentPane;
	private static int JFRAME_WIDTH = 1260;
	private static int JFRAME_HEIGHT = 780;

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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(10, 288, 1224, 443);
		contentPane.add(panel_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("lol");
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabbedPane.setBounds(340, 21, 894, 256);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		tabbedPane.addTab("Avtale", null, panel_1, null);
		
		JLabel lblLol = new JLabel("LOL");
		panel_1.add(lblLol);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Alarm", null, panel_3, null);
		
		JButton btnLol = new JButton("LOL");
		panel_3.add(btnLol);
		
		
		
		
	}
}
