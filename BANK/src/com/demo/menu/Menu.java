package com.demo.menu;
import java.util.*;

import com.dom.service.bankservice;

public class Menu {
	Scanner sc;
	bankservice bkser;
	public Menu()
	{
		bkser = new bankservice();	
	}
	public void displayMenu()
	{
		sc = new Scanner(System.in);
		String choice="y";
		int ch =0;
		while(choice.equals("y"))
		{
			System.out.println("enter the choice");
			System.out.println("1.insert");
			System.out.println("2.update");
			System.out.println("3.diposite");
			System.out.println("4.withdraw");
			System.out.println("5.display");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				bkser.insertbankaccount();
				break;
			case 2:
				bkser.update();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				bkser.display();
				break;
			case 6:
				System.exit(0);
			}
			System.out.println("you want to continue again y/n");
			choice=sc.next();
			
		}
	}

}
