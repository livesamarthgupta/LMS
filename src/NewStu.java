
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class NewStu extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField pf1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStu frame = new NewStu();
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
	public NewStu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\add_user_group_woman_man-24.png"));
		con = JavaConnect.connectDB();
		setTitle("Add New Student");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNewStudent = new JLabel("Add New Student:");
		lblAddNewStudent.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblAddNewStudent.setBounds(159, 56, 138, 21);
		contentPane.add(lblAddNewStudent);
		
		JLabel lblStudentsEmail = new JLabel("Student's Email:");
		lblStudentsEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblStudentsEmail.setBounds(60, 98, 112, 23);
		contentPane.add(lblStudentsEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPassword.setBounds(97, 132, 71, 17);
		contentPane.add(lblPassword);
		
		tf1 = new JTextField();
		tf1.setBounds(177, 100, 160, 21);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		pf1 = new JTextField();
		pf1.setBounds(178, 132, 159, 21);
		contentPane.add(pf1);
		pf1.setColumns(10);
		
		JButton btnAddNewStudent = new JButton("Add New Student");
		btnAddNewStudent.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\add_user_group_woman_man-24.png"));
		btnAddNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "insert into student values(?,?,null,null,null,null,null,null,null,null,null,null,null)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf1.getText());
					pstmt.setString(2, pf1.getText());
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "Student Added Successfully!");
					pstmt.close();
				}
				catch(MySQLIntegrityConstraintViolationException e)
				{
					JOptionPane.showMessageDialog(null, "Student Already Registered!");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				finally {
					try {
						pstmt.close();
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btnAddNewStudent.setBounds(60, 184, 150, 33);
		contentPane.add(btnAddNewStudent);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Librarian o1 = new Librarian();
				o1.setVisible(true);
			}
		});
		btnCancel.setBounds(267, 184, 101, 33);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\add_user_group_woman_man-48.png"));
		label.setBounds(203, 11, 46, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\email-24.png"));
		label_1.setBounds(347, 98, 46, 23);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\password-24.png"));
		label_2.setBounds(347, 132, 46, 21);
		contentPane.add(label_2);
	}

}
