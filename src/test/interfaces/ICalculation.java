package test.interfaces;  

import test.exceptions.CalcNotCompleteException;
import test.exceptions.ValuesNotSetException;

public interface ICalculation {

    public void calculate() throws ValuesNotSetException;

    public Object getResult() throws CalcNotCompleteException;

}  
