package test;

import test.exceptions.CalcNotCompleteException;
import test.exceptions.ValuesNotSetException;

public class TestProgram {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				try {
					int a = (int) (Math.random()*100);
					int b = (int) (Math.random()*100);
					System.out.println("Start calculating "+a+" + "+b);
					Calculator calculator = Calculator.getInstance();
					AddCalculation addCalc = new AddCalculation();
					addCalc.setValues(a, b);
					calculator.processCalculation(addCalc);
					
					Thread.sleep(10L);
					// retrieve result
					System.out.println(a + " + " + b + " = "+ addCalc.getResult());

				} catch (InterruptedException iex) {} catch (ValuesNotSetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(-1);
				} catch (CalcNotCompleteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(-2);
				}
			}
		};
		
		// spawn threads
		for(int i=0; i<100000; i++){
			Thread thr = new Thread(r);
			thr.start();
		}
	}

}
