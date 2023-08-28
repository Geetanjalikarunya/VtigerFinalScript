package threadsPractice;

public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread();
		System.out.println(t1.getId());
		System.out.println(t1.getName());
		t1.setName("saii");
		System.out.println(t1.getName());
		System.out.println(t1.getPriority());
		t1.setPriority(10);
		System.out.println(t1.getPriority());
	}

}
