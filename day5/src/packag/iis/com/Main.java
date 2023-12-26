package packag.iis.com;

import java.util.Scanner;

public class Main extends Thread{
	public void run()
	{
		if(Thread.currentThread().getName().equals("evennumber")) {
			System.out.println("eve number");
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter your choice:-");
		System.out.println("1.even numbers");
		System.out.println("2.oddnumbers");
		int choice = sc.nextInt();
		Main obj =new Main();
		//int ch =sc.nextInt();
		switch(choice)
		{
		//Main obj =new Main();
		case  1:
			Even eve= new Even();
			eve.start();
		case 2:
			Thread.currentThread().setName("oodnumber ");
			Odd odd= new Odd();
			odd.start();
			//obj.start();;
		
			
			
		}
		
	}

}
