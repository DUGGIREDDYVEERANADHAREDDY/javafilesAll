package trannig.pratice;
import java.sql.*;

import tranning.connection.DataConnection;
public class Workerdata {
	//private static final int result = 0;
	private Connection con;
	private Statement sat;
	public Workerdata()
	{
		con=DataConnection.getconnection();
	}
	public void insert()
	{
		try
		{
		sat=con.createStatement();
		int result = sat.executeUpdate("insert into Worker values(9,'veera','Duggireddy',90000,'2021-04-11 09:00:00','developer')");
		if(result>0)
		{
			System.out.println("data insert sucessfully");
		}
		else
		{
			System.out.println("no  data inserted");
		}
	}
		
		
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void delate(int WORKER_ID)
	{
		try
		{
		sat=con.createStatement();
		int result1= sat.executeUpdate("delete from Worker where WORKER_ID="+WORKER_ID+"");
		if(result1>0)
		{
			System.out.println("data delete sucessfully");
			
		}
		else
		{
			System.out.println("no data deleted");
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
	public void update(int WORKER_ID)
	{
		try
		{
		sat=con.createStatement();
		int result = sat.executeUpdate("update  Worker set SALARY=2000000 where WORKER_ID="+ WORKER_ID+"");
		if(result>0)
		{
			System.out.println("data update sucessfully");
		}
		else
		{
			System.out.println("data will not updated");
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void result()
	{
		try
		{
		sat = con.createStatement();
		ResultSet result = sat.executeQuery("select * from Worker");
		while(result.next())
		{
			System.out.println("the id is:-"+result.getInt(1));
			System.out.println("the name is :-"+result.getString(2));
			System.out.println("the last name is:-"+result.getString(3));
			
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void checkdetaits(String name,String pasword)
	{
		try
		{
		sat=con.createStatement();
		ResultSet result = sat.executeQuery("select * from employee");
		while(result.next())
		{
			if(result.getString(2).equals(name) && result.getString(4).equals(pasword))
			{
				System.out.println("the user is validate ");
				break;
			}
			else
			{
				System.out.println("the user is not validate");
				break;
			}
		}
		
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
	public void checkdetaits1(String name,String pasword)
	{
		try
		{
		sat=con.createStatement();
		ResultSet result = sat.executeQuery("select * from employee where name='"+name+"' and password+'password'"+"");
		
			if(result.next())
			{
				System.out.println("the user is validate ");

			}
			else
			{
				System.out.println("the user is not validate");

			}
		
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
	public static void main(String[] args) {
		Workerdata wr = new Workerdata();
		wr.insert();
		wr.delate(9);
		wr.update(1);
		wr.result();
		//wr.checkdetaits("veera","veera");
		wr.checkdetaits1("sri","sri");
		
	}
	

}
