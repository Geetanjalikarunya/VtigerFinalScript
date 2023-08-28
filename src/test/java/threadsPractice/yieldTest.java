package threadsPractice;
class magic2 extends Thread
{
	public void run()
	{
		
	
	for(int i=1;i<=3;i++)
	{
		System.out.println(i);
	}
}
}
public class yieldTest 
{
public static void main(String[] args)
{
	magic2 m=new magic2();
	m.start();
	Thread.yield();
	for(int j=11;j<=13;j++)
	{
		System.out.println(j);
	}
}
	
}
