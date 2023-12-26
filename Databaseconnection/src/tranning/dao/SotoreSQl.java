package tranning.dao;
import java.util.*;

import tranning.connection.DataConnection;

import java.sql.*;
public class SotoreSQl {
	private Connection con;
	private CallableStatement st;
	Scanner sc;
	public SotoreSQl()
	{
		con =DataConnection.getconnection();
		sc = new Scanner(System.in);
	}
	public void call()throws SQLException
	{
		System.out.println("enter you  want to move detais");
		int movieid = sc.nextInt();
		st=con.prepareCall("call getmoviedetails(?,?)");
		st.setInt(1, movieid);
		st.registerOutParameter(2, Types.VARCHAR);
		st.executeUpdate();
		String moviename = st.getString(2);
		System.out.println("the movie name is "+moviename);

	}
	public static void main(String[] args) throws SQLException {
		SotoreSQl sr = new SotoreSQl();
		sr.call();
				
		
	}

}

