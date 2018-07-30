
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ViewIssue extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JPanel contentPane;
	private static JTextField tf1;
	private static  JTextField tf2;
	private static JTextField tf3;
	private static JTextField tf4;
	private static JTextField tf5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewIssue frame = new ViewIssue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void setTF1(String tf)
	{
		tf1.setText(tf);
	}
	public static void setTF2(String tf)
	{
		tf2.setText(tf);
	}
	public static void setTF3(String tf)
	{
		tf3.setText(tf);
	}
	public static void setTF4(String tf)
	{
		tf4.setText(tf);
	}
	public static void setTF5(String tf)
	{
		tf5.setText(tf);
	}
	

	/**
	 * Create the frame.
	 */
	public ViewIssue() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\borrow_book-24.png"));
		setResizable(false);
		setTitle("View Issued Books");
		con = JavaConnect.connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewIssuedBooks = new JLabel("View Issued Books:");
		lblViewIssuedBooks.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblViewIssuedBooks.setBounds(149, 57, 139, 26);
		contentPane.add(lblViewIssuedBooks);
		
		JLabel lblBook = new JLabel("Book 1:");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBook.setBounds(59, 103, 62, 17);
		contentPane.add(lblBook);
		
		JLabel lblBook_4 = new JLabel("Book 2:");
		lblBook_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBook_4.setBounds(59, 131, 62, 20);
		contentPane.add(lblBook_4);
		
		JLabel lblBook_3 = new JLabel("Book 3:");
		lblBook_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBook_3.setBounds(59, 162, 62, 23);
		contentPane.add(lblBook_3);
		
		JLabel lblBook_2 = new JLabel("Book 4:");
		lblBook_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBook_2.setBounds(59, 196, 62, 23);
		contentPane.add(lblBook_2);
		
		JLabel lblBook_1 = new JLabel("Book 5:");
		lblBook_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBook_1.setBounds(59, 230, 62, 14);
		contentPane.add(lblBook_1);
		
		tf1 = new JTextField();
		tf1.setEditable(false);
		tf1.setBounds(116, 103, 240, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setBounds(116, 134, 240, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setColumns(10);
		tf3.setBounds(116, 165, 240, 20);
		contentPane.add(tf3);
		
		tf4 = new JTextField();
		tf4.setEditable(false);
		tf4.setColumns(10);
		tf4.setBounds(116, 196, 240, 20);
		contentPane.add(tf4);
		
		tf5 = new JTextField();
		tf5.setEditable(false);
		tf5.setColumns(10);
		tf5.setBounds(116, 227, 240, 20);
		contentPane.add(tf5);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\back-24.png"));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Student o1 = new Student();
				o1.setVisible(true);
			}
		});
		btnReturn.setBounds(162, 278, 101, 33);
		contentPane.add(btnReturn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\borrow_book-48.png"));
		label.setBounds(196, 11, 46, 48);
		contentPane.add(label);
	}
}

	