package packag.iis.com;

public class Mainthread extends Thread {
	public void run()
	{
		if(Thread.currentThread().getName().equals("even"))
		{
			for(int i =0;i<10;i++)
			{
				if(i%2==0)
				{
					System.out.println("even number"+i);
				}
			}
		}
		else if(Thread.currentThread().getName().equals("odd"))
		{
			if(Thread.currentThread().getName().equals("odd"))
			{
				for(int i =0;i<10;i++)
				{
					if(i%2==0)
					{
						System.out.println("odd number"+i);
					}
				}
			}
			
		}
	}

}
