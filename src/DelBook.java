
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class DelBook extends JFrame {

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
					DelBook frame = new DelBook();
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
	public DelBook() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\book-24.png"));
		con = JavaConnect.connectDB();
		setTitle("Delete Book");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteBooks = new JLabel("Delete Books:");
		lblDeleteBooks.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDeleteBooks.setBounds(176, 47, 102, 32);
		contentPane.add(lblDeleteBooks);
		
		JLabel lblBooksIsbn = new JLabel("Book's ISBN:");
		lblBooksIsbn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblBooksIsbn.setBounds(79, 101, 90, 23);
		contentPane.add(lblBooksIsbn);
		
		tf1 = new JTextField();
		tf1.setBounds(179, 103, 153, 24);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\book-24.png"));
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "select * from book where isbn = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tf1.getText());
					rs = pstmt.executeQuery();
					if (rs.next())
					{
						sql = "delete from book where isbn = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, tf1.getText());
						pstmt.execute();
						JOptionPane.showMessageDialog(null, "Book Deleted Successfully!!");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No such Book!");
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
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btnDeleteBook.setBounds(79, 153, 125, 32);
		contentPane.add(btnDeleteBook);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\cancel-24.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Librarian o1 = new Librarian();
				o1.setVisible(true);
			}
		});
		btnCancel.setBounds(262, 153, 102, 32);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\book-48.png"));
		label.setBounds(204, 11, 46, 37);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\numbered_list-24.png"));
		label_1.setBounds(342, 103, 46, 21);
		contentPane.add(label_1);
	}
}
