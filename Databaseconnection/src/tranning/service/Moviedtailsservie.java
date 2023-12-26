package tranning.service;
import java.sql.*;
import java.util.*;

import tranning.dao.MoviedetailsDAO;
import tranning.dto.Moviedetails;
public class Moviedtailsservie {
	private Scanner sc;
	private MoviedetailsDAO movie;
	public List<Moviedetails> mov;
	public Moviedtailsservie()
	{
		sc = new Scanner(System.in);
		movie = new MoviedetailsDAO();
		mov = new ArrayList<>();
	}
	public void insert() throws SQLException
	{
		System.out.println("enter how many you want");
		int x = sc.nextInt();
		for(int i=0;i<x;i++)
		{
			Moviedetails ml= new Moviedetails();
			System.out.println("ener movie number ");
			ml.setMovienumber(sc.nextInt());
			System.out.println("enter movie name");
			ml.setMoviename(sc.next());
			System.out.println("enter movie price");
			ml.setPrice(sc.nextDouble());
			System.out.println("enter movie duration");
			ml.setDuritation(sc.nextInt());
			mov.add(ml);
		}
		movie.inserData(mov);
	}
	/*public void delete() {
		System.out.println("enter you want to delate movie id");
		int id = sc.nextInt();
		if(id==id)
		{
			System.out.println(" movie  id is succefuly deleted");
		}
		else
		{
			System.out.println("the id  is not deleted");
		}
		// TODO Auto-generated method stub
		
	}*/
	public void retrive () throws SQLException
	{
		List<Moviedetails> mov= movie.getdetails();
		for(Moviedetails m:mov)
		{
			System.out.println("movie title is "+m.getMoviename());
			System.out.println("movienummber is "+m.getMovienumber());
			System.out.println("movie duration is "+m.getDuritation());
			System.out.println("the price  is"+m.getPrice());
			
		}
		
	}
	/*public void update ()throws SQLException
	{
		Moviedetails ml= new Moviedetails();
		System.out.println("ener movie number ");
		ml.setMovienumber(sc.nextInt());
		System.out.println("enter movie name");
		ml.setMoviename(sc.next());
		movie.inserData(ml);
		
	}
	public void moviename() throws SQLException
	{
		Moviedetails ml= new Moviedetails();
		System.out.println("enter movie name");
		ml.setMoviename(sc.next());
		movie.inserData(ml);*/
		
	}
	
	
	
	


