package packag.iis.com;
import java.util.*;

public class UserValidation extends Thread{
	Scanner sc;
	User obj;
	public UserValidation()
	{
		sc = new Scanner(System.in);
		obj= new User();
		obj.setName("veera");
		obj.setPassword("veera");
		
	}
	public void run()
	{
		System.out.println("enter user name");
		String name= sc.next();
		System.out.println("enter password name");
		String Password= sc.next();
		if(obj.getName().equals(name) && obj.getPassword().equals(Password))
		{
			
			System.out.println("user is validation");
		}
		else {
			System.out.println("user is not validation");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	public static void main(String[] args) {
		UserValidation us = new UserValidation();
		us.start();
	}
	

}
