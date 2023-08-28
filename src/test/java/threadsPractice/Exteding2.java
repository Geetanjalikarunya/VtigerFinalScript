package threadsPractice;

class Task1 extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
		}
	}
}
class Java extends Thread
{
	public void run()
	{
		for(char c='a';c<='e';c++)
		{
			System.out.println(c);
		}
	}
}
public class Exteding2 {

	public static void main(String[] args) 
	{
		Task1 t1=new Task1();
		t1.start();
		Java j1=new Java();
		j1.start();

	}

}
