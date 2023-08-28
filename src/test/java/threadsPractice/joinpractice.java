package threadsPractice;
class logic1 extends Thread
{
	public void run() {
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
		}
	}
}
public class joinpractice {

	public static void main(String[] args) throws InterruptedException {
		

		logic1 l=new logic1();
		l.start();
		l.join();
		for(int j=11;j<=15;j++)
		{
			System.out.println(j);
		}
	}

}
