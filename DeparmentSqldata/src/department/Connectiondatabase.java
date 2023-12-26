package department;
import java.sql.*;

//import tranning.connection.DataConnection;
public class Connectiondatabase {
	public  static Connection con;
	public Statement stat;
	private Connectiondatabase()
	{
		try {
			String str="com.mysql.cj.jdbc.Driver";
		Class.forName(str);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Department","root","veera");
		System.out.println(" sucessfully conneted to database");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			
		}

	}
	public static Connection getconnection()
	{
		Connectiondatabase data = new Connectiondatabase();
		return con;
	}
	public static void main(String[] args) {
		getconnection();
		
	}
	

}
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connectiondatabase {
    private static Connection con;
    private Statement stat;

    private Connectiondatabase() {
        try {
        	String str = "com.mysql.cj.jdbc.Driver";
            Class.forName(str);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/veera", "root", "veera");
            System.out.println("Successfully connected to the database");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Connection getconnection() {
        if (con == null) {
            new Connectiondatabase();
        }
        return con;
    }

    public static void main(String[] args) {
        Connection connection = getconnection();
        // You can use the 'connection' object to perform database operations.
        // For example: Statement statement = connection.createStatement();
    }
}*/


