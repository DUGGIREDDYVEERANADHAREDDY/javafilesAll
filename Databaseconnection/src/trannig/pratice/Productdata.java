package trannig.pratice;
import java.sql.*;
import java.util.Scanner;

import tranning.connection.DataConnection;
public class Productdata {
	private Connection con;
	PreparedStatement stat;
	private Scanner sc;
	public Productdata()
	{
		con=DataConnection.getconnection();
		sc= new Scanner(System.in);
	}
	public void insert() throws SQLException
	{
		//stat=con.prepareStatement("insert into product values(?,?,?,?,?)");
		System.out.println("enter how many you want");
		int x = sc.nextInt();
		stat=con.prepareStatement("insert into product values(?,?,?,?,?)");
		for(int i =1;i<=x;i++)
		{
			System.out.println("enter number");
			stat.setInt(1, sc.nextInt());
			System.out.println("enter productname");
			stat.setString(2, sc.next());
			System.out.println("enter price");
			stat.setDouble(3, sc.nextDouble());
			System.out.println("enter qualulity");
			stat.setInt(4, sc.nextInt());
			
			int result= stat.executeUpdate();
			if(result>0)
			{
				System.out.println("data updated");
			}
			else
			{
				System.out.println("data will not update");
			}
		}
	}
	/*public void threeinsert() throws SQLException
	{
		//con=DataConnection.getconnection();
		stat=con.prepareStatement("insert into product values(productname ,quantity , producttype ),(?,?,?)");
			//insert into product values( productname ,quantity , producttype )(?,?,?)");
		System.out.println("enter how many you want");
		int y =sc.nextInt();
		for(int i =1;i<=y;i++)
		{
			System.out.println("enter productname");
			stat.setString(1, sc.next());
			System.out.println("enter qualulity");
			stat.setInt(2, sc.nextInt());
			System.out.println("enter product type");
			stat.setString(3,sc.next());
			int result=stat.executeUpdate();
			if(result>0)
			{
				System.out.println("updated");
			}
			else
			{
				System.out.println("not updated");
			}
			
			
		}
		
	}*/
	public static void main(String[] args) throws SQLException {
		Productdata  pr = new Productdata();
		pr.insert();
		//pr.threeinsert();
		
	}
	

}
