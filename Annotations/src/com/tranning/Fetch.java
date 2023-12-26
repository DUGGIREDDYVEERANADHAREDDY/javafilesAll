package com.tranning;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
	public SessionFactory set;
	public Fetch()
	{
		set=new Configuration().configure("Connection.cf.xml").buildSessionFactory();
	}
	public void server()
	{
		
	}

}
