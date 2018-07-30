
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
public class Librarian extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian frame = new Librarian();
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
	public Librarian() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\library-24.png"));
		setTitle("Librarian");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 441, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeLibrarian = new JLabel("Welcome Librarian:");
		lblWelcomeLibrarian.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblWelcomeLibrarian.setBounds(151, 63, 141, 21);
		contentPane.add(lblWelcomeLibrarian);
		
		JButton btnAddNewBook = new JButton("Add New Book");
		btnAddNewBook.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\health_book-24.png"));
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NewBook o1 = new NewBook();
				o1.setVisible(true);
			}
		});
		btnAddNewBook.setBounds(10, 110, 144, 33);
		contentPane.add(btnAddNewBook);
		
		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\books-24.png"));
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ViewBook o1 = new ViewBook();
				o1.setVisible(true);
			}
		});
		btnViewBooks.setBounds(161, 110, 121, 33);
		contentPane.add(btnViewBooks);
		
		JButton btnIssueBooks = new JButton("Issue Books");
		btnIssueBooks.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\borrow_book-24.png"));
		btnIssueBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IssueBook o1 = new IssueBook();
				o1.setVisible(true);
			}
		});
		btnIssueBooks.setBounds(93, 172, 121, 33);
		contentPane.add(btnIssueBooks);
		
		JButton btnDeleteBooks = new JButton("Delete Books");
		btnDeleteBooks.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\book-24.png"));
		btnDeleteBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DelBook o1 = new DelBook();
				o1.setVisible(true);
			}
		});
		btnDeleteBooks.setBounds(290, 110, 132, 33);
		contentPane.add(btnDeleteBooks);
		
		JButton btnViewStudentBook = new JButton("View Student Book Record");
		btnViewStudentBook.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\book_stack-24.png"));
		btnViewStudentBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				BookRec o1 = new BookRec();
				o1.setVisible(true);
			}
		});
		btnViewStudentBook.setBounds(119, 240, 190, 33);
		contentPane.add(btnViewStudentBook);
		
		JButton btnAddNewStudent = new JButton("Add New Student");
		btnAddNewStudent.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\add_user_group_woman_man-24.png"));
		btnAddNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				NewStu o1 = new NewStu();
				o1.setVisible(true);
			}
		});
		btnAddNewStudent.setBounds(34, 306, 156, 33);
		contentPane.add(btnAddNewStudent);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\change_user_female-24.png"));
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DelStu o1 = new DelStu();
				o1.setVisible(true);
			}
		});
		btnDeleteStudent.setBounds(252, 306, 150, 33);
		contentPane.add(btnDeleteStudent);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\logout_rounded_down-24.png"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Logout o1 = new Logout();
				o1.setVisible(true);
			}
		});
		btnLogout.setBounds(168, 363, 102, 33);
		contentPane.add(btnLogout);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\return_book-24.png"));
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ReturnBook o1 = new ReturnBook();
				o1.setVisible(true);
			}
		});
		btnReturnBook.setBounds(224, 172, 121, 33);
		contentPane.add(btnReturnBook);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Text\\Programs\\Java Workspace\\LMS\\Icons\\library-48.png"));
		label.setBounds(199, 11, 46, 48);
		contentPane.add(label);
	}

}
