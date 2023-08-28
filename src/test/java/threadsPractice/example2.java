package threadsPractice;

public class example2 {

	public static void main(String[] args) {
		Thread t1=new Thread();
		System.out.println(t1.getName());
		t1.setName("sunday");
		System.out.println(t1.getName());
		Thread t2=new Thread("java");
		System.out.println(t2.getName());
     
	}

}
