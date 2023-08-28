package threadsPractice;

class car1 extends Thread
{
	public void driving()
	{
		synchronized(this)
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println(i);
			}
		}
	}
}
class UserThread1 extends Thread
{
	car1 c1;
	public UserThread1(car1 c1)
	{
		this.c1=c1;
	}
}
public class synchronizeBlock 
{
	public static void main(String[] args) {
		
	
  car1 c1=new car1();
  UserThread1 u=new UserThread1(c1);
  u.start();
  UserThread1 u1=new UserThread1(c1);
  u1.start();
	}
}
