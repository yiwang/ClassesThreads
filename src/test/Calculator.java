package test;  

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

import test.exceptions.ValuesNotSetException;
import test.interfaces.ICalculation;

public class Calculator {
	
	private final Semaphore sem = new Semaphore(1, true);
	
    public void processCalculation(ICalculation calc) throws InterruptedException, ValuesNotSetException {
    	//.....do calculation asynchronously but limit to at most 10 at a time...
    	sem.acquire();
    	calc.calculate();
    	sem.release();
    }

    private Calculator() {
    	System.out.println("Init Calculator Singleton");
    }
    
    private static class SingletonHolder {
    	private static final Calculator INSTANCE = new Calculator();
    }

    public static Calculator getInstance(){
    	return SingletonHolder.INSTANCE;
    }
}
