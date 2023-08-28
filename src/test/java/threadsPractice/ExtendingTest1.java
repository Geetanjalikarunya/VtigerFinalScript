package threadsPractice;
class Task extends Thread
{
	public void run() 
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
		}
	}
}
public class ExtendingTest1 {

	public static void main(String[] args)
	{
		Task t1=new Task();
		t1.start();

	}

}
