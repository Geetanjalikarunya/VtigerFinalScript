package threadsPractice;
class car extends Thread
{
	public synchronized void driving()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
		}
	}
}
class UserThread extends Thread
{
	car c1;
	public UserThread(car c1)
	{
		this.c1=c1;
	}
	public void run()
	{
		c1.driving();
	}
}
public class synchronizePractice {

	public static void main(String[] args) 
	{
		car c1=new car();
		UserThread u1=new UserThread(c1);
		u1.start();
		UserThread u2=new UserThread(c1);
		u2.start();
		
	}

}
