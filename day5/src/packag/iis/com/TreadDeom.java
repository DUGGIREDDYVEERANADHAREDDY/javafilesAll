package packag.iis.com;

public class TreadDeom extends Thread {
	public void run()
	{
		for(int i =0;i<10;i++)
		{
			System.out.println("the values of x is the "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		TreadDeom thread =new TreadDeom();
		thread.start();
	}

}
