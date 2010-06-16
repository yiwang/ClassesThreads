package test;  

import test.exceptions.CalcNotCompleteException;
import test.exceptions.ValuesNotSetException;
import test.interfaces.ICalculation;

public class AddCalculation implements ICalculation {  

    boolean valsSet = false;

    boolean computationComplete = false;

    int valA;

    int valB;

    int result;  

    @Override

    public void calculate() throws ValuesNotSetException {

		if (!valsSet)
		
		    throw new ValuesNotSetException();
		
		computationComplete = false;
		
		result = valA + valB;
		
		computationComplete = true;

    }  

    @Override

    public Integer getResult() throws CalcNotCompleteException {

		if (!valsSet || !computationComplete)
		
		    throw new CalcNotCompleteException();
		
		return result;

    }  

    public void setValues(int a, int b) {

		valsSet = false;
		
		computationComplete = false;
		
		valA = a;
		
		valB = b;
		
		// after valsSet
		valsSet = true;

    }

} 
