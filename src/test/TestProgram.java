package test;

public class TestProgram {

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			  public void run() {
			    try {
			      while (true) {
			        System.out.println("Hello, world!");
			        Calculator.getInstance();
			        Thread.sleep(1000L);
			      }
			    } catch (InterruptedException iex) {}
			  }
		};
		
		Thread thr1 = new Thread(r1);
		Thread thr2 = new Thread(r1);
		Thread thr3 = new Thread(r1);
		
		thr1.start();
		thr2.start();
		thr3.start();
	}

}
