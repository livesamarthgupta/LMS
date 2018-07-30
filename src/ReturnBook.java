
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
public class ReturnBook extends JFrame {

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
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\return_book-24.png"));
		con = JavaConnect.connectDB();
		setTitle("Return Book");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReturnBook = new JLabel("Return Book:");
		lblReturnBook.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblReturnBook.setBounds(164, 62, 98, 21);
		contentPane.add(lblReturnBook);
		
		JLabel lblStudentsEmail = new JLabel("Student's Email:");
		lblStudentsEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblStudentsEmail.setBounds(73, 102, 114, 21);
		contentPane.add(lblStudentsEmail);
		
		JLabel lblBooksIsbn = new JLabel("Book's ISBN:");
		lblBooksIsbn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblBooksIsbn.setBounds(95, 134, 89, 21);
		contentPane.add(lblBooksIsbn);
		
		tf1 = new JTextField();
		tf1.setBounds(203, 102, 138, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(203, 133, 138, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\return_book-24.png"));
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "select name from book where isbn = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf2.getText());
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						String bname = rs.getString(1);
						sql = "select b1, b2, b3, b4, b5 from student where email =?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, tf1.getText());
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							if(bname.equals(rs.getString(1)))
							{
								sql = "update student set b1 = NULL, noofbooks = noofbooks-1 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy+1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Book Successfully Returned!");
							}
							else
							if(bname.equals(rs.getString(2)))
							{
								sql = "update student set b2 = NULL, noofbooks = noofbooks-1 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy+1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Book Successfully Returned!");
							}
							else
							if(bname.equals(rs.getString(3)))
							{
								sql = "update student set b3 = NULL, noofbooks = noofbooks-1 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy+1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Book Successfully Returned!");
							}
							else
							if(bname.equals(rs.getString(4)))
							{
								sql = "update student set b4 = NULL, noofbooks = noofbooks-1 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy+1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Book Successfully Returned!");
							}
							else
							if(bname.equals(rs.getString(5)))
							{
								sql = "update student set b5 = NULL, noofbooks = noofbooks-1 where email = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf1.getText());
								pstmt.execute();
								sql = "update book set noofcopy = noofcopy+1 where isbn = ?";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, tf2.getText());
								pstmt.execute();
								JOptionPane.showMessageDialog(null, "Book Successfully Returned!");
							}
							else {
								JOptionPane.showMessageDialog(null, "You Haven't Issued This Book Yet!");
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No Such Student!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No Such Book!");
					}
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				finally {
					try {
						rs.close();
						pstmt.close();
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btnReturnBook.setBounds(73, 186, 125, 33);
		contentPane.add(btnReturnBook);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Librarian o1 = new Librarian();
				o1.setVisible(true);
			}
		});
		btnCancel.setBounds(258, 186, 98, 33);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\return_book-48.png"));
		label.setBounds(190, 11, 46, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\email-24.png"));
		label_1.setBounds(351, 102, 46, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\numbered_list-24.png"));
		label_2.setBounds(351, 134, 46, 20);
		contentPane.add(label_2);
	}
}
