package department;
import java.sql.*;
public class Databasemetadata {
	private Connection con;
	PreparedStatement sat;
	public Databasemetadata()
	{
		con=Connectiondatabase.getconnection();
	}
	public void database() throws SQLException
	{
		DatabaseMetaData db =con.getMetaData();
		System.out.println("the data base type is:- "+db.getCatalogSeparator());
		System.out.println("the driver name is:-"+db.getDriverName());
		System.out.println("databse version is "+db.getDatabaseMajorVersion());
		System.out.println("prperties of  database is "+db.getClientInfoProperties());
	}
	public static void main(String[] args) throws SQLException {
		Databasemetadata data= new Databasemetadata();
		data.database();
		
	}
	

}
