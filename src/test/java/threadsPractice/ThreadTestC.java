package threadsPractice;

public class ThreadTestC {

	public static void main(String[] args) {
		
		Thread t1=new Thread();
		Thread.currentThread();
		System.out.println(t1.getName());
		System.out.println(t1.getId());
		System.out.println(t1.getPriority());

	}

}
