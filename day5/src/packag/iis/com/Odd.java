package packag.iis.com;

public class Odd extends Thread {
	public void run()
	{
		for(int x =0;x<20;x++)
		{
			if(x%2!=0)
			{
				System.out.println("odd number is "+x);
			}
		}
	}

}
