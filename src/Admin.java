
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\administrator-24.png"));
		setTitle("Admin");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin:");
		lblNewLabel.setIcon(null);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setBounds(154, 70, 126, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnAddNewLibrarian = new JButton("Add New Librarian");
		btnAddNewLibrarian.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\add_user-24.png"));
		btnAddNewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NewLib o1 = new NewLib();
				o1.setVisible(true);
			}
		});
		btnAddNewLibrarian.setBounds(141, 102, 151, 33);
		contentPane.add(btnAddNewLibrarian);
		
		JButton button = new JButton("View Librarians");
		button.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\library-24.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ViewLib o1 = new ViewLib();
				o1.setVisible(true);
			}
		});
		button.setBounds(141, 146, 151, 33);
		contentPane.add(button);
		
		JButton btnDeleteLibrarians = new JButton("Delete Librarians");
		btnDeleteLibrarians.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\remove_user-24.png"));
		btnDeleteLibrarians.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DelLib o1 = new DelLib();
				o1.setVisible(true);
			}
		});
		btnDeleteLibrarians.setBounds(141, 190, 151, 33);
		contentPane.add(btnDeleteLibrarians);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\logout_rounded_down-24.png"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Logout o1 = new Logout();
				o1.setVisible(true);
			}
		});
		btnLogout.setBounds(154, 234, 126, 33);
		contentPane.add(btnLogout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\administrator-48.png"));
		label.setBounds(188, 11, 46, 48);
		contentPane.add(label);
	}

}
