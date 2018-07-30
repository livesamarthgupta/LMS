
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
public class IssueBook extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\borrow_book-24.png"));
		con = JavaConnect.connectDB();
		setTitle("Issue Book");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIssueBook = new JLabel("Issue Book:");
		lblIssueBook.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblIssueBook.setBounds(180, 59, 88, 28);
		contentPane.add(lblIssueBook);
		
		JLabel lblBooksIsbn = new JLabel("Book's ISBN:");
		lblBooksIsbn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblBooksIsbn.setBounds(78, 98, 99, 14);
		contentPane.add(lblBooksIsbn);
		
		JLabel lblStudentsEmail = new JLabel("Student's Email:");
		lblStudentsEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblStudentsEmail.setBounds(51, 129, 122, 14);
		contentPane.add(lblStudentsEmail);
		
		tf1 = new JTextField();
		tf1.setBounds(180, 98, 164, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(180, 129, 166, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\borrow_book-24.png"));
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "select noofbooks, b1, b2, b3, b4, b5 from student where email=?;";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf2.getText());
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						int i= rs.getInt(1);
						if(i<5)
						{
							sql = "select name from book where isbn = ?;";
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1, tf1.getText());
							rs = pstmt.executeQuery();
							if(rs.next())
							{switch (i) {
							
							case 0:
								sql = "update student set b1 = ? where email =?;";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1,rs.getString(1));
								pstmt.setString(2, tf2.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy-1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update student set noofbooks = 1 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Issued Successfully!");
								break;
							case 1:
								sql = "update student set b2 = ? where email =?;";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1,rs.getString(1));
								pstmt.setString(2, tf2.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy-1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update student set noofbooks = 2 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Issued Successfully!");
								break;
							case 2:
								sql = "update student set b3 = ? where email =?;";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1,rs.getString(1));
								pstmt.setString(2, tf2.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy-1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update student set noofbooks = 3 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Issued Successfully!");
								break;
							case 3:
								sql = "update student set b4 = ? where email =?;";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1,rs.getString(1));
								pstmt.setString(2, tf2.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy-1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update student set noofbooks = 4 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Issued Successfully!");
								break;
							case 4:
								sql = "update student set b5 = ? where email =?;";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1,rs.getString(1));
								pstmt.setString(2, tf2.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy-1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update student set noofbooks = 5 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Issued Successfully!");
								break;

							default:
								JOptionPane.showMessageDialog(null, "Unsuccessful!");
								break;
							}}
							else
							{
								JOptionPane.showMessageDialog(null, "No Such Book!!");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "5 Books Already Issued!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "No Such Student!");
					}
					rs.close();
					pstmt.close();
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e);
				}
				finally {
					try {
						rs.close();
						pstmt.close();
					}
					catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btnIssue.setBounds(97, 177, 89, 33);
		contentPane.add(btnIssue);
		
		JButton btnReturn = new JButton("Cancel");
		btnReturn.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Librarian o1 = new Librarian();
				o1.setVisible(true);
			}
		});
		btnReturn.setBounds(245, 177, 97, 33);
		contentPane.add(btnReturn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\borrow_book-48.png"));
		label.setBounds(197, 11, 46, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\numbered_list-24.png"));
		label_1.setBounds(354, 98, 46, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\email-24.png"));
		label_2.setBounds(356, 129, 46, 20);
		contentPane.add(label_2);
	}
}
