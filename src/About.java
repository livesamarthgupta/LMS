
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;


@SuppressWarnings("serial")
public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\about-24.png"));
		setTitle("About");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(505, 300, 439, 141);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\about-48.png"));
		label.setBounds(195, 11, 46, 48);
		contentPane.add(label);
		
		JLabel lblCreatedBySamarth = new JLabel("Created By: Samarth Gupta under supervision of Abhinit sir");
		lblCreatedBySamarth.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCreatedBySamarth.setBounds(10, 70, 440, 21);
		contentPane.add(lblCreatedBySamarth);
	}
}
