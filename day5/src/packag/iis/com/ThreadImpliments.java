package packag.iis.com;

public class ThreadImpliments implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			if(i%2==0)
			{
				System.out.println("the even numbe is "+i);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		ThreadImpliments thread = new ThreadImpliments();
		Thread th1 = new Thread(thread);
		th1.start();
		try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
