package test;

import test.exceptions.CalcNotCompleteException;
import test.exceptions.ValuesNotSetException;

public class TestProgram {

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			public void run() {
				try {
					while (true) {
						int a = (int) (Math.random()*100);
						int b = (int) (Math.random()*100);
						System.out.println("Start calculating "+a+" + "+b);
						Calculator calculator = Calculator.getInstance();
						AddCalculation addCalc = new AddCalculation();
						addCalc.setValues(a, b);
						try {							
							calculator.processCalculation(addCalc);
						} catch (ValuesNotSetException e) {
							e.printStackTrace();
							System.exit(-1);
						}
						
						// retrieve result
						while (true) {
							try {
								System.out.println(a + " + " + b + " = "+ addCalc.getResult());
								break;
							} catch (CalcNotCompleteException e) {
								e.printStackTrace();
								System.exit(-1);
							}
						}
						
						Thread.sleep(1L);
					}
				} catch (InterruptedException iex) {}
			}
		};
		
		for(int i=0; i<1000; i++){
			Thread thr = new Thread(r1);
			thr.start();
		}
	}

}
