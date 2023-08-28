package threadsPractice;
class Task3 extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
		 try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(i);
		}
	}
}
class sql extends Thread
{
	public void run()
	{
		for(char c='a';c<='e';c++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(c);
		}
	}
}
public class ExtendingTest3 {

	public static void main(String[] args) {
		
		Task3 t1=new Task3();
		t1.start();
		sql s=new sql();
		s.start();

	}

}
