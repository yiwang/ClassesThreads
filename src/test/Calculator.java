package test;  

import test.exceptions.ValuesNotSetException;
import test.interfaces.ICalculation;

public class Calculator {  

    public void processCalculation(ICalculation calc) throws ValuesNotSetException {
    	//.....do calculation asynchronously but limit to at most 10 at a time...
    	calc.calculate();

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
