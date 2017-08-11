
public class CalculatorTwo {
	private double result;
	private double currentNumber;
	private double prevNumber;
	
	//private boolean add = false;
	private boolean addsubtract = false;
	private boolean multiplydivide = false;
	//private boolean divide = false;
	boolean resultSet = false;
	private String operand = "none";
	private String resultOperand;
	public void performOperation(double num) {
		System.out.println(num);
		prevNumber = currentNumber;
		currentNumber = num;
		if(operand != "none") {
			calculate();
		}
	}
	
	public void performOperation(String operation) {
		System.out.println(operation);
		this.operand = operation;
		if(operand.equals("=")) {
			calculate();
		}
		
	}
	
	public double getResults(){
		return result;
	}
	
	public void calculate() {
		if(this.operand == "*") {
			currentNumber = currentNumber*prevNumber;
			this.multiplydivide = true;
		}
		else if(this.operand == "/") {
			currentNumber = currentNumber/prevNumber;
			this.multiplydivide = true;
			
		}
		else if(this.operand == "-" || this.operand == "+") {
			if(addsubtract) {
				if(resultOperand == "+") {
					result = result + prevNumber;
				}else { //-
					result = result - prevNumber;
				}
			}
			else if(multiplydivide) {
				result = prevNumber;
				this.multiplydivide = false;
			}
			addsubtract = true;
			resultOperand = operand;
		}

		else {
			// = 
			if(addsubtract) {
				if(resultOperand == "+") {
					result = result + currentNumber;
				}else { //-
					result = result - currentNumber;
				}
			}
		}
		operand = "empty";
	}
	
	
}
