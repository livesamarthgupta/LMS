
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setLocationByPlatform(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\167756.png"));
		setResizable(false);
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel(" Login");
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblLogin.setBounds(184, 51, 46, 21);
		contentPane.add(lblLogin);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\administrator-24.png"));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AdminLogin o1 = new AdminLogin();
				o1.setVisible(true);
			}
		});
		btnAdmin.setBounds(157, 96, 99, 33);
		contentPane.add(btnAdmin);
		
		JButton btnLibrarian = new JButton("Librarian");
		btnLibrarian.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\library-24.png"));
		btnLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				LibLogin o1 = new LibLogin();
				o1.setVisible(true);
			}
		});
		btnLibrarian.setBounds(134, 148, 144, 33);
		contentPane.add(btnLibrarian);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\student_male-24.png"));
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				StuLogin o1 = new StuLogin();
				o1.setVisible(true);
			}
		});
		btnStudent.setBounds(157, 203, 99, 33);
		contentPane.add(btnStudent);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\e_learning-48.png"));
		label.setBounds(184, 11, 63, 40);
		contentPane.add(label);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About o1 = new About();
				o1.setVisible(true);
			}
		});
		btnAbout.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\about-24.png"));
		btnAbout.setBounds(157, 260, 99, 33);
		contentPane.add(btnAbout);
	}
}
