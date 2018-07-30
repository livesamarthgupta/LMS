
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;



import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class NewLib extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JPasswordField pf1;
	private JTextField tf3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewLib frame = new NewLib();
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
	public NewLib() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\add_user-24.png"));
		con = JavaConnect.connectDB();
		setTitle("Add New Librarian");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNewLibrarian = new JLabel("Add New Librarian:");
		lblAddNewLibrarian.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblAddNewLibrarian.setBounds(145, 59, 140, 21);
		contentPane.add(lblAddNewLibrarian);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblName.setBounds(104, 91, 44, 14);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmail.setBounds(104, 123, 37, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPassword.setBounds(87, 154, 61, 14);
		contentPane.add(lblPassword);
		
		JLabel lblMobileNo = new JLabel("Mobile No:");
		lblMobileNo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMobileNo.setBounds(81, 185, 67, 14);
		contentPane.add(lblMobileNo);
		
		tf1 = new JTextField();
		tf1.setBounds(176, 91, 135, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(174, 122, 137, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		pf1 = new JPasswordField();
		pf1.setBounds(176, 153, 135, 20);
		contentPane.add(pf1);
		
		tf3 = new JTextField();
		tf3.setBounds(176, 184, 135, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		JButton btnAddLibrarian = new JButton("Add Librarian");
		btnAddLibrarian.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\add_user-24.png"));
		btnAddLibrarian.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "insert into librarian values (?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(3, tf1.getText());
					pstmt.setString(1, tf2.getText());
					pstmt.setString(2, pf1.getText());
					pstmt.setLong(4, Long.parseLong(tf3.getText()));
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "Librarian Added!!");
				}
				catch(MySQLIntegrityConstraintViolationException e1)
				{
					JOptionPane.showMessageDialog(null, "Librarian Already Registered!");
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				finally {
					try{
						pstmt.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		btnAddLibrarian.setBounds(72, 232, 123, 33);
		contentPane.add(btnAddLibrarian);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Admin o1 = new Admin();
				o1.setVisible(true);
			}
		});
		btnCancel.setBounds(236, 232, 111, 33);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\add_user-48.png"));
		label.setBounds(187, 11, 54, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\name-24.png"));
		label_1.setBounds(321, 91, 46, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\email-24.png"));
		label_2.setBounds(321, 122, 46, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\key-24.png"));
		label_3.setBounds(321, 153, 46, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cell_phone-24.png"));
		label_4.setBounds(321, 180, 46, 24);
		contentPane.add(label_4);
	}

}
