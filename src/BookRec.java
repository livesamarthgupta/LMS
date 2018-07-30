
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
public class BookRec extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookRec frame = new BookRec();
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
	public BookRec() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\book_stack-24.png"));
		con = JavaConnect.connectDB();
		setTitle("Student Book Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewStudentBook = new JLabel("View Student Book Record:");
		lblViewStudentBook.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblViewStudentBook.setBounds(120, 59, 197, 29);
		contentPane.add(lblViewStudentBook);
		
		JLabel lblStudentsEmail = new JLabel("Student's Email:");
		lblStudentsEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblStudentsEmail.setBounds(21, 105, 111, 21);
		contentPane.add(lblStudentsEmail);
		
		tf1 = new JTextField();
		tf1.setBounds(142, 107, 185, 23);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lblBook = new JLabel("Book 1:");
		lblBook.setBounds(64, 163, 46, 14);
		contentPane.add(lblBook);
		
		JLabel lblBook_1 = new JLabel("Book 2:");
		lblBook_1.setBounds(64, 194, 46, 14);
		contentPane.add(lblBook_1);
		
		JLabel lblBook_2 = new JLabel("Book 3:");
		lblBook_2.setBounds(64, 225, 46, 14);
		contentPane.add(lblBook_2);
		
		JLabel lblBook_3 = new JLabel("Book 4:");
		lblBook_3.setBounds(64, 256, 46, 14);
		contentPane.add(lblBook_3);
		
		JLabel lblBook_4 = new JLabel("Book 5:");
		lblBook_4.setBounds(64, 287, 46, 14);
		contentPane.add(lblBook_4);
		
		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setBounds(120, 160, 243, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setBounds(120, 191, 243, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setEditable(false);
		tf4.setBounds(120, 222, 243, 20);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		tf5 = new JTextField();
		tf5.setEditable(false);
		tf5.setBounds(120, 253, 243, 20);
		contentPane.add(tf5);
		tf5.setColumns(10);
		
		tf6 = new JTextField();
		tf6.setEditable(false);
		tf6.setBounds(120, 284, 243, 20);
		contentPane.add(tf6);
		tf6.setColumns(10);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\back-24.png"));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Librarian o1 = new Librarian();
				o1.setVisible(true);
			}
		});
		btnReturn.setBounds(171, 331, 102, 33);
		contentPane.add(btnReturn);
		
		JButton btnGo = new JButton("");
		btnGo.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\checkmark-24.png"));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "Select b1, b2, b3, b4, b5 from student where email = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf1.getText());
					rs = pstmt.executeQuery();
					if(rs.next())
					{	tf2.setText(rs.getString(1));
						tf3.setText(rs.getString(2));
						tf4.setText(rs.getString(3));
						tf5.setText(rs.getString(4));
						tf6.setText(rs.getString(5));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No Such Student!");
					}
					
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
		btnGo.setBounds(373, 105, 46, 25);
		contentPane.add(btnGo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\book_stack-48.png"));
		label.setBounds(190, 11, 46, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\email-24.png"));
		label_1.setBounds(337, 105, 46, 25);
		contentPane.add(label_1);
	}
}
