package threadsPractice;
class magic1 implements Runnable
{

	@Override
	public void run()
	{
		System.out.println("daemon Thread");
		System.out.println(Thread.currentThread().isDaemon());
	}
	
}
public class DeamonTest1 {

	public static void main(String[] args)
	{
		System.out.println("main method");
		magic1 m=new magic1();
	Thread t=new Thread(m);
	t.setDaemon(false);
	t.start();

	}

}
