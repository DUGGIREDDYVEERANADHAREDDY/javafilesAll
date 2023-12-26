package tranning.dao;
import java.sql.*;
import java.util.*;

import tranning.connection.DataConnection;
import tranning.dto.Moviedetails;

public class MoviedetailsDAO {
	private Connection con;
	private PreparedStatement sat;
	Scanner sc;
	public MoviedetailsDAO()
	{
		con =DataConnection.getconnection();
		sc=new Scanner(System.in);
	}
	public void inserData(List<Moviedetails> mov)throws SQLException {
		con.setAutoCommit(false);
		sat= con.prepareStatement("insert into movie values(?,?,?,?)");
		for(Moviedetails m :mov)
		{
			sat.setInt(1, m.getMovienumber());
			sat.setString(2,m.getMoviename());
			sat.setDouble(3, m.getPrice());
			sat.setInt(4,m.getDuritation());
			sat.addBatch();
		}
		int result[]= sat.executeBatch();
		if(result[0]>0)
		{
			System.out.println("data inserted");
		}
		else
		{
			System.out.println("the data was not inserted ");
		}
		/*sat=con.prepareStatement("insert into movie values(?,?,?,?)");
		sat.setInt(1, mov.movienumber);
		sat.setString(2,mov.getMoviename());
		sat.setDouble(3, mov.getPrice());
		sat.setInt(4, mov.getDuritation());
		int result =sat.executeUpdate();
		if(result>0)
		{
			System.out.println("sucessfully data was inserted ");
		}
		else
		{
			System.out.println("data was not iserted ");
		}*/
		
		
		
	}
	public void delete() throws SQLException
	{
		System.out.println("enter delete movie id");
		int id = sc.nextInt();
		sat=con.prepareStatement("delete from movie where id"+id);
		if(id==id)
		{
			System.out.println("the id  is succesfully delated ");
		}
		else
		{
			System.out.println("the id is not deleted");
		}
	}
	public List<Moviedetails> getdetails()throws SQLException {
		sat=con.prepareStatement("select * from movie");
		ResultSet re = sat.executeQuery();
		while(re.next())
		{
			Moviedetails mr = new Moviedetails();
			mr.setMovienumber(re.getInt(1));
			mr.setMoviename(re.getString(2));
			mr.setDuritation(re.getInt(3));
			mr.setPrice(re.getDouble(4));
			
		}
		
		
		// TODO Auto-generated method stub
		return getdetails();
	}
	public void update(Moviedetails ml)throws SQLException {
		sat=con.prepareStatement("update movie set moviecode =? where moviename=?");
		sat.setInt(1,ml.getMovienumber());
		sat.setString(2,ml.getMoviename());
		int result = sat.executeUpdate();
		if(result>0)
		{
			System.out.println("the id is updated");
		}
		else
		{
			System.out.println("the id is not updated");
		}
		
	}
	public void moviename(Moviedetails ml) throws SQLException
	{
		sat= con.prepareStatement("select * form movie where moviename=?");
		sat.setInt(2,ml.getDuritation());
		sat.setString(3, ml.getMoviename());
		ResultSet res = sat.executeQuery();
		while(res.next())
		{
			System.out.println("the movien number is "+res.getInt(1));
			System.out.println("the movie name is "+res.getString(2));
			System.out.println("the price is "+res.getDouble(3));
		}
			
			
	}
	
}
