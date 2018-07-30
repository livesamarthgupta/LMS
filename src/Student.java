
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Student extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\student_male-24.png"));
		con = JavaConnect.connectDB();
		setResizable(false);
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeStudent = new JLabel("Welcome Student:");
		lblWelcomeStudent.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblWelcomeStudent.setBounds(148, 60, 133, 21);
		contentPane.add(lblWelcomeStudent);
		
		JButton btnViewIssuedBooks = new JButton("View Issued Books");
		btnViewIssuedBooks.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\borrow_book-24.png"));
		btnViewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ViewIssue o1 = new ViewIssue();
				o1.setVisible(true);
				try {
					String email = StuLogin.getEmail();
					String sql = "Select b1, b2, b3, b4, b5 from student where email = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, email);
					rs = pstmt.executeQuery();
					rs.next();
					ViewIssue.setTF1(rs.getString(1));
					ViewIssue.setTF2(rs.getString(2));
					ViewIssue.setTF3(rs.getString(3));
					ViewIssue.setTF4(rs.getString(4));
					ViewIssue.setTF5(rs.getString(5));
					rs.close();
					pstmt.close();
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				finally {
					try {
						rs.close();
						pstmt.close();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
			}
		});
		btnViewIssuedBooks.setBounds(134, 102, 154, 33);
		contentPane.add(btnViewIssuedBooks);
		
		JButton btnEditDetails = new JButton("Edit Details");
		btnEditDetails.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\edit_property-24.png"));
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EditStu o1 = new EditStu();
				o1.setVisible(true);
			}
		});
		btnEditDetails.setBounds(148, 146, 127, 33);
		contentPane.add(btnEditDetails);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\logout_rounded_down-24.png"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Logout o1 = new Logout();
				o1.setVisible(true);
			}
		});
		btnLogout.setBounds(158, 190, 107, 33);
		contentPane.add(btnLogout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\student_male-48.png"));
		label.setBounds(190, 11, 46, 48);
		contentPane.add(label);
	}

}
