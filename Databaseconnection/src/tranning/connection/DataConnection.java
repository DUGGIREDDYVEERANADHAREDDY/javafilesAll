package tranning.connection;
import java.sql.*;

//import javax.annotation.processing.Completion;
public class DataConnection {
	private static Connection con;
	private DataConnection()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/veera","root","veera");
		System.out.println(" sucessfully conneted to database------------------------------------------");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			
		}

	}
	public static Connection getconnection()
	{
		DataConnection data = new DataConnection();
		return con;
	}
	public static void main(String[] args) {
		getconnection();
		
	}
	

}
