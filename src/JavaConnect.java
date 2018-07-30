import java.sql.*;
import javax.swing.JOptionPane;

public class JavaConnect 
{
	Connection con;
	public static Connection connectDB()
	{
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root","toor");
			return con;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}

}
