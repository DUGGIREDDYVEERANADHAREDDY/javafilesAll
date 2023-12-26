package trannig.pratice;
import java.sql.*;

import tranning.connection.DataConnection;
public class BatchUpdate {
	private Connection con;
	PreparedStatement sat;
	public BatchUpdate()
	{
		con = DataConnection.getconnection();
	}
	public void addbatch() throws SQLException
	{
		con.setAutoCommit(false);
		sat=con.prepareStatement("insert into movie values(?,?,?,?)");
		sat.setInt(1, 24);
		sat.setString(2, "hello");
		sat.setDouble(3,400);
		sat.setInt(4, 100);
		sat.addBatch();
		con.setAutoCommit(true);
		sat.setInt(1, 245);
		sat.setString(2, "imageinfo");
		sat.setDouble(3,500);
		sat.setInt(4, 162);
		sat.addBatch();
		int result[] = sat.executeBatch();
		if(result[0]>0)
		{
			System.out.println("inserted sucessfully");
		}
		else
		{
			System.out.println("data was not inserted");
		}
				
	}
	public static void main(String[] args) throws SQLException {
		BatchUpdate bt = new BatchUpdate();
		bt.addbatch();
		
	}

}
