package com.demo.dao;
import java.util.*;

import com.dom.pojo.Bank;
public class BankDAO {
	private Bank bankarr[];
	Scanner sc;
	private Bank bk;
	private int Transation;
	public BankDAO()
	{
		sc=new Scanner(System.in);
	}
	public void insertbankaccount()
	{
		System.out.println("enter the bank account number");
		int index =sc.nextInt();
		bankarr= new Bank[index];
		for(int i=0;i<bankarr.length;i++)
		{
			bankarr[i]=new Bank();
			//System.out.println("acccount number");
			//System.out.println(bankarr[i]);
			bankarr[i].setBankacc("AB100"+i);
			System.out.println("enter the name of the depositor");
			bankarr[i].setNameofdepositor(sc.next());
			System.out.println("enter the address of the depositor");
			bankarr[i].setAddressofdepositor(sc.next());
			System.out.println("enter the type of account");
			bankarr[i].setTypeofaccount(sc.next());
			System.out.println("enter the balance");
			bankarr[i].setBalanace(sc.nextInt());
			System.out.println("enter  number of transactions");
			bankarr[i].setTransation(sc.nextInt());
		}
	}
	public void display()
	{
		for(Bank bc:bankarr)
		{
			System.out.println("the account number is :-"+bc.getBankacc());
			System.out.println("the dipostor name"+bc.getNameofdepositor());
			System.out.println("address of the banker"+bc.getAddressofdepositor());
			System.out.println("type of account"+bc.getBalanace());
			System.out.println("avaliable balance"+bc.getBalanace());
			System.out.println("the number o of transations are the "+bc.getTransation());
		}
	}
	public void update() {
		String name= sc.next();
		for(Bank b:bankarr)
		{
			if(b.getAddressofdepositor()==name)
			{
				System.out.println("the adress change"+b.getAddressofdepositor());
			}
		}
	}
	public void deposite(double amount)
	{
		double balance = amount;
		this.Transation++;
	}
}

