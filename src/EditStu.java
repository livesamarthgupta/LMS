

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class EditStu extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStu frame = new EditStu();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EditStu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\edit_property-24.png"));
		con = JavaConnect.connectDB();
		setResizable(false);
		setTitle("Edit Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblEditDetails = new JLabel("Edit Details:");
		lblEditDetails.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEditDetails.setBounds(182, 62, 88, 21);
		contentPane.add(lblEditDetails);
		
		JLabel lblName = new JLabel("Edit Name:");
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblName.setBounds(56, 166, 88, 22);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("New Email:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEmail.setBounds(56, 105, 84, 18);
		contentPane.add(lblEmail);
		
		JLabel lblMobileNo = new JLabel("Edit Mobile No:");
		lblMobileNo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblMobileNo.setBounds(28, 192, 112, 28);
		contentPane.add(lblMobileNo);
		
		JLabel lblBranch = new JLabel("Edit Branch:");
		lblBranch.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblBranch.setBounds(56, 229, 84, 23);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Edit Year:");
		lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblYear.setBounds(73, 255, 71, 28);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Edit Semester:");
		lblSemester.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSemester.setBounds(206, 259, 94, 24);
		contentPane.add(lblSemester);
		
		tf1 = new JTextField();
		tf1.setBounds(150, 105, 198, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(150, 167, 198, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(150, 198, 198, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setBounds(150, 229, 64, 20);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		cb1.setBounds(150, 260, 38, 20);
		contentPane.add(cb1);
		
		JComboBox cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		cb2.setBounds(310, 262, 38, 20);
		contentPane.add(cb2);
		
		JButton btnEditDetails = new JButton("Edit Details");
		btnEditDetails.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\edit_property-24.png"));
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String email = StuLogin.getEmail();
					String sql = "select * from student where email = ?;";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, email);
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						sql = "update student set name = ?, mobno = ?, branch =?, year =?, semester =?, email = ? where email = ?;";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, tf2.getText());
						pstmt.setLong(2, Long.parseLong(tf3.getText()));
						pstmt.setString(3, tf4.getText());
						pstmt.setString(4, (String) cb1.getSelectedItem());
						pstmt.setString(5, (String) cb2.getSelectedItem());
						pstmt.setString(6, tf1.getText());
						pstmt.setString(7, email);
						pstmt.execute();
						JOptionPane.showMessageDialog(null, "Updated Successfully!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No Such Student!");
					}
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
		btnEditDetails.setBounds(73, 312, 124, 33);
		contentPane.add(btnEditDetails);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Student o1 = new Student();
				o1.setVisible(true);
			}
		});
		btnCancel.setBounds(246, 312, 102, 33);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\edit_property-48.png"));
		label.setBounds(199, 11, 46, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\email-24.png"));
		label_1.setBounds(358, 105, 46, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\name-24.png"));
		label_2.setBounds(358, 167, 46, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cell_phone-24.png"));
		label_3.setBounds(358, 199, 46, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\classroom-24.png"));
		label_4.setBounds(224, 231, 46, 21);
		contentPane.add(label_4);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewPassword.setBounds(32, 134, 108, 21);
		contentPane.add(lblNewPassword);
		
		textField = new JTextField();
		textField.setBounds(150, 136, 198, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\password-24.png"));
		label_5.setBounds(358, 136, 46, 20);
		contentPane.add(label_5);
	}
}
