
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Logout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logout frame = new Logout();
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
	public Logout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\logout_rounded_down-24.png"));
		setResizable(false);
		setTitle("Successful Logout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 363, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSuccessfullLogout = new JLabel("Successful Logout!");
		lblSuccessfullLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblSuccessfullLogout.setBounds(108, 59, 166, 36);
		contentPane.add(lblSuccessfullLogout);
		
		JButton btnGoToMain = new JButton("Go to Main Menu");
		btnGoToMain.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\menu_2-24.png"));
		btnGoToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login o1 = new Login();
				o1.setVisible(true);
			}
		});
		btnGoToMain.setBounds(92, 106, 166, 33);
		contentPane.add(btnGoToMain);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\logout_rounded_down-48.png"));
		label.setBounds(158, 11, 46, 48);
		contentPane.add(label);
	}

}
