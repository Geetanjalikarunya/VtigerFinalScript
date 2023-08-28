package threadsPractice;

class magic implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}

	}

}

class logic implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int j = 5; j <= 10; j++) {
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(j);
		}
	}

}

public class implementingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		magic m = new magic();
		Thread t1 = new Thread(m);
		t1.start();

		logic l = new logic();
		Thread t2 = new Thread(l);
		t2.start();

	}

}
