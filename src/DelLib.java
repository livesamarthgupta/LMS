
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
public class DelLib extends JFrame {

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
					DelLib frame = new DelLib();
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
	public DelLib() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\remove_user-24.png"));
		con = JavaConnect.connectDB();
		setTitle("Delete Librarian");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteLibrarian = new JLabel("Delete Librarian:");
		lblDeleteLibrarian.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDeleteLibrarian.setBounds(164, 55, 127, 21);
		contentPane.add(lblDeleteLibrarian);
		
		JLabel lblLibrariansEmail = new JLabel("Librarian's Email:");
		lblLibrariansEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLibrariansEmail.setBounds(55, 100, 117, 21);
		contentPane.add(lblLibrariansEmail);
		
		tf1 = new JTextField();
		tf1.setBounds(184, 103, 161, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JButton btnDeleteLibrarian = new JButton("Delete Librarian");
		btnDeleteLibrarian.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\remove_user-24.png"));
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "select * from librarian where email = ?;";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf1.getText());
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						sql = "delete from librarian where email = ?;";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, tf1.getText());
						pstmt.execute();
						JOptionPane.showMessageDialog(null, "Librarian Successfully Deleted!!");
					}
					else {
						JOptionPane.showMessageDialog(null, "No such Librarian!!");
					}
					
					pstmt.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				finally {
					try {
						pstmt.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		btnDeleteLibrarian.setBounds(65, 154, 144, 33);
		contentPane.add(btnDeleteLibrarian);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Admin o1 = new Admin();
				o1.setVisible(true);
			}
		});
		btnCancel.setBounds(256, 154, 102, 33);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\remove_user-48.png"));
		label.setBounds(200, 11, 46, 41);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\email-24.png"));
		label_1.setBounds(355, 100, 46, 23);
		contentPane.add(label_1);
	}

}
