package com.dom.service;

import com.demo.dao.BankDAO;

public class bankservice {
	private BankDAO bankedo;
	
	public bankservice()
	{
		bankedo= new BankDAO();
	}
	public void insertbankaccount()
	{
		bankedo.insertbankaccount();
	}
	public void display()
	{
		bankedo.display();
	}
	public void update() {
		bankedo.update();
		// TODO Auto-generated method stub
		
	}
}
