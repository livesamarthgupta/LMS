
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
public class ViewLib extends JFrame {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblName;
	private JLabel lblEmail;
	private JLabel lblMobileNo;
	private JButton btnReturn;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLib frame = new ViewLib();
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
	public ViewLib() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\library-24.png"));
		con = JavaConnect.connectDB();
		setTitle("View Librarians");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewLibrarians = new JLabel("View Librarians:");
		lblViewLibrarians.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblViewLibrarians.setBounds(156, 66, 111, 21);
		contentPane.add(lblViewLibrarians);
		try
		{
			String sql = "select * from librarian";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next())
			{
				i++;
			}
			String row[][] = new String[i][3];
			String column[] = {"Name", "Email","Mobile No."};
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String a;
			int j = 0;
			while(rs.next())
			{
				a = rs.getString(3);
				row[j][0] = a;
				a = rs.getString(1);
				row[j][1] = a;
				a = String.valueOf(rs.getLong(4));
				row[j][2] = a;
				j++;
				
			}
			rs.close();
			pstmt.close();
			table = new JTable(row, column);
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			table.setRowSelectionAllowed(false);
			table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			table.setBounds(23, 123, 388, 127);
			contentPane.add(table);
			
			lblName = new JLabel("Name");
			lblName.setBounds(68, 98, 46, 14);
			contentPane.add(lblName);
			
			lblEmail = new JLabel("E-mail");
			lblEmail.setBounds(188, 98, 46, 14);
			contentPane.add(lblEmail);
			
			lblMobileNo = new JLabel("Mobile No.");
			lblMobileNo.setBounds(317, 98, 63, 14);
			contentPane.add(lblMobileNo);
			
			btnReturn = new JButton("Return");
			btnReturn.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\back-24.png"));
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Admin o1 = new Admin();
					o1.setVisible(true);
				}
			});
			btnReturn.setBounds(156, 281, 111, 33);
			contentPane.add(btnReturn);
			
			label = new JLabel("");
			label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\library-48.png"));
			label.setBounds(188, 11, 46, 55);
			contentPane.add(label);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		finally {
			try{
				rs.close();
				pstmt.close();
				}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		
	}
}
