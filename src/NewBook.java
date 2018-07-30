
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class NewBook extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook frame = new NewBook();
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
	public NewBook() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\health_book-24.png"));
		con = JavaConnect.connectDB();
		setResizable(false);
		setTitle("Add  New Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNewBook = new JLabel("Add New Book:");
		lblAddNewBook.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblAddNewBook.setBounds(158, 60, 116, 31);
		contentPane.add(lblAddNewBook);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblIsbn.setBounds(128, 111, 46, 14);
		contentPane.add(lblIsbn);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblBookName.setBounds(88, 142, 86, 21);
		contentPane.add(lblBookName);
		
		JLabel lblAuthorName = new JLabel("Author Name:");
		lblAuthorName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblAuthorName.setBounds(76, 174, 98, 21);
		contentPane.add(lblAuthorName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPrice.setBounds(128, 206, 46, 21);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblQuantity.setBounds(108, 238, 66, 21);
		contentPane.add(lblQuantity);
		
		tf1 = new JTextField();
		tf1.setBounds(189, 111, 116, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(189, 142, 116, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(189, 173, 116, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setBounds(189, 204, 66, 20);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		tf5 = new JTextField();
		tf5.setBounds(189, 235, 66, 20);
		contentPane.add(tf5);
		tf5.setColumns(10);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\health_book-24.png"));
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "insert into book values (?,?,?,?,?);";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf1.getText());
					pstmt.setString(2, tf2.getText());
					pstmt.setString(3, tf3.getText());
					pstmt.setDouble(4, Double.parseDouble(tf4.getText()));
					pstmt.setInt(5, Integer.parseInt(tf5.getText()));
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "Book Added!!");
					pstmt.close();
				}
				catch(MySQLIntegrityConstraintViolationException e)
				{
					JOptionPane.showMessageDialog(null, "Book Already Exists!");
				}
				catch (Exception e) {
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
		btnAddBook.setBounds(88, 288, 105, 31);
		contentPane.add(btnAddBook);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Librarian o1 = new Librarian();
				o1.setVisible(true);
			}
		});
		btnCancel.setBounds(241, 288, 98, 31);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\health_book-48.png"));
		label.setBounds(193, 11, 46, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\numbered_list-24.png"));
		label_1.setBounds(315, 111, 46, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\book-24.png"));
		label_2.setBounds(315, 142, 46, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\user_typing_using_typewriter-24.png"));
		label_3.setBounds(315, 174, 46, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\price_tag-24.png"));
		label_4.setBounds(265, 205, 46, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\stack-24.png"));
		label_5.setBounds(265, 235, 46, 23);
		contentPane.add(label_5);
	}

}
