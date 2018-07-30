
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ViewBook extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblIsbn;
	private JLabel lblBookName;
	private JLabel lblAuthorName;
	private JLabel lblPrice;
	private JLabel lblQuantity;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBook frame = new ViewBook();
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
	public ViewBook() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\books-24.png"));
		setResizable(false);
		con = JavaConnect.connectDB();
		setTitle("View Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 574, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewBooks = new JLabel("View Books:");
		lblViewBooks.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblViewBooks.setBounds(239, 63, 85, 23);
		contentPane.add(lblViewBooks);
		
		try
		{
			String sql = "select * from Book";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next())
			{
				i++;
			}
			String row[][] = new String[i][5];
			String column[] = {"ISBN", "Name","Author", "Price", "Quantity"};
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String a;
			int j = 0;
			while(rs.next())
			{
				a = rs.getString(1);
				row[j][0] = a;
				a = rs.getString(2);
				row[j][1] = a;
				a = rs.getString(3);
				row[j][2] = a;
				a = String.valueOf(rs.getLong(4));
				row[j][3] = a;
				a = String.valueOf(rs.getInt(5));
				row[j][4] = a;
				j++;
				
			}
			rs.close();
			pstmt.close();
			
			table = new JTable(row, column);
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			table.setBounds(10, 122, 546, 126);
			contentPane.add(table);
			
			lblIsbn = new JLabel("ISBN");
			lblIsbn.setBounds(53, 97, 46, 14);
			contentPane.add(lblIsbn);
			
			lblBookName = new JLabel("Book Name");
			lblBookName.setBounds(134, 97, 79, 14);
			contentPane.add(lblBookName);
			
			lblAuthorName = new JLabel("Author Name");
			lblAuthorName.setBounds(239, 97, 85, 14);
			contentPane.add(lblAuthorName);
			
			lblPrice = new JLabel("Price");
			lblPrice.setBounds(372, 97, 46, 14);
			contentPane.add(lblPrice);
			
			lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(471, 97, 62, 14);
			contentPane.add(lblQuantity);
			
			JButton btnReturn = new JButton("Return");
			btnReturn.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\back-24.png"));
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Librarian o1 = new Librarian();
					o1.setVisible(true);
				}
			});
			btnReturn.setBounds(239, 279, 93, 33);
			contentPane.add(btnReturn);
			
			label = new JLabel("");
			label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\books-48.png"));
			label.setBounds(255, 11, 53, 48);
			contentPane.add(label);
		}
		catch(Exception e)
		{
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
}
