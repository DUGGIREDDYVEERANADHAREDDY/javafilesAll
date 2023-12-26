package tranning.client;
import java.sql.SQLException;
import java.util.*;

import tranning.service.Moviedtailsservie;
public class Client {
	public Moviedtailsservie ser;
	Scanner sc;
	public Client()
	{
		ser =new Moviedtailsservie();
	}
	public void displaymenu() throws SQLException
	{
		sc=new Scanner(System.in);
		String choice ="y";
		int ch =0;
		while (choice.equals("y"))
		{
			System.out.println("enter choice ");
			System.out.println("1.insert movie");
			System.out.println("2.delete movie");
			System.out.println("3.update movie ");
			System.out.println("4.view movie details");
			System.out.println("5.according  to movie details");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				ser.insert();
				break;
			case 2:
				//ser.delete();
				break;
			case 3:
				//ser.update();
				break;
			case 4:
				ser.retrive();;
				break;
			case 5:
				//ser.moviename();
				
				
			}
		}

	}

}
