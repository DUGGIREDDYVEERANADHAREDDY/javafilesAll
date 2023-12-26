package com.tranning;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Appmain {
	public SessionFactory sat;
	public Session ses;
	public Transaction tax;
	public Appmain()
	{
		sat=new Configuration().configure("Connection.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class).buildSessionFactory();
	}
	public void insert()
	{
		ses=sat.openSession();
		tax=ses.beginTransaction();
		Employee em = new Employee();
		Address ad = new Address();
		//em.setEmpcode(01);
		em.setEmpname("Sravan");
		em.setEmpsalary(100);
		ad.setCity("kadp");
		ad.setHousenumber(10);
		ad.setEobj(em);
		//em.setAdd(ad);
		ses.save(em);
		tax.commit();
		System.out.println("data inserted");
	}
	public void retrivedata()
	{
		ses=sat.openSession();
		tax=ses.beginTransaction();
		Query q = ses.createQuery("from Employee");
		List<Employee> list= q.list();
		for(Employee em:list)
		{
			System.out.println("emp name is "+em.getEmpcode());
			System.out.println("emp  salary"+em.getEmpsalary());
			
			System.out.println("");
		}
		
	}
	public static void main(String[] args) {
		Appmain app = new Appmain();
		//app.insert();
		app.retrivedata();
	}

}
