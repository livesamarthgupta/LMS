
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class AdminLogin extends JFrame {

	Connection con;
	ResultSet rs;
	PreparedStatement pstmt; //Added
	private JPanel contentPane;
	private JTextField tf1;
	private JPasswordField pf1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\administrator-24.png"));
		setResizable(false);
		con = JavaConnect.connectDB();
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login:");
		lblAdminLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblAdminLogin.setBounds(162, 32, 107, 26);
		contentPane.add(lblAdminLogin);
		
		JLabel lblUsername = new JLabel("Email:");
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblUsername.setBounds(104, 85, 46, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPassword.setBounds(77, 134, 73, 14);
		contentPane.add(lblPassword);
		
		tf1 = new JTextField();
		tf1.setBounds(160, 83, 153, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		pf1 = new JPasswordField();
		pf1.setBounds(160, 133, 153, 20);
		contentPane.add(pf1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\email-24.png"));
		label.setBounds(323, 83, 46, 26);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\key-24.png"));
		label_1.setBounds(323, 134, 34, 26);
		contentPane.add(label_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\login_rounded_right-24.png"));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try 
				{
					String sql = "select * from admin where email =? and password=?;";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf1.getText());
					pstmt.setString(2, pf1.getText());
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						rs.close();
						pstmt.close();
						setVisible(false);
						Admin o1 = new Admin();
						o1.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect Email or Password!");
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				finally {
					try {
						rs.close();
						pstmt.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
				}
			}
		});
		btnLogin.setBounds(77, 192, 107, 33);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login o1 = new Login();
				o1.setVisible(true);
			}
		});
		btnCancel.setBounds(236, 192, 107, 33);
		contentPane.add(btnCancel);
	}
}
