import java.util.*;
import java.lang.*; 
public class Calculator implements java.io.Serializable {
    private double operandOne;
    private double operandTwo;
    private double results;
    private String operation;
    private boolean used = false;
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public double getResult() {
		return results;
	}
	public void setResult(double result) {
		this.results = result;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public void performOperation() {
		double firstnumber = getOperandOne();
		double secondnumber = getOperandTwo();
		if(getOperation() == "+") {
			results = firstnumber+secondnumber;
		}
		else if(getOperation() == "-") {
			results = firstnumber-secondnumber;
		}
		else if(getOperation() == "*") {
			results = firstnumber*secondnumber;
		}
		else if(getOperation() == "/") {
			results = firstnumber/secondnumber;
		}
		else {
			System.out.println("Invalid Operation");
			results = 0;
		}
	}
	
	public double getResults() {
		return results;
	}
    


}
