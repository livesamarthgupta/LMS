
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class DelStu extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JPanel contentPane;
	private JTextField tf1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelStu frame = new DelStu();
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
	public DelStu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\change_user_female-24.png"));
		con = JavaConnect.connectDB();
		setTitle("Delete Student");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteStudent = new JLabel("Delete Student:");
		lblDeleteStudent.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDeleteStudent.setBounds(171, 58, 114, 26);
		contentPane.add(lblDeleteStudent);
		
		JLabel lblStudentsEmail = new JLabel("Student's Email:");
		lblStudentsEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblStudentsEmail.setBounds(55, 102, 114, 21);
		contentPane.add(lblStudentsEmail);
		
		tf1 = new JTextField();
		tf1.setBounds(171, 104, 186, 23);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\change_user_female-24.png"));
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "select * from student where email = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf1.getText());
					rs = pstmt.executeQuery();
					if(rs.next())
					{
					sql = "delete from student where email = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf1.getText());
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "Student Deleted Sucessfully!");
					pstmt.close();
					
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No such Student!");
					}
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				finally {
					try {
						pstmt.close();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btnDeleteStudent.setBounds(65, 158, 143, 33);
		contentPane.add(btnDeleteStudent);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Librarian o1 = new Librarian();
				o1.setVisible(true);
			}
		});
		btnCancel.setBounds(251, 158, 106, 33);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\change_user-48.png"));
		label.setBounds(206, 11, 46, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\email-24.png"));
		label_1.setBounds(367, 102, 46, 25);
		contentPane.add(label_1);
	}

}
