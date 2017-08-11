
public class CalculatorTest {
	public static void main(String[] args){
		Calculator calc = new Calculator();
		calc.setOperandOne(11.5);
		calc.setOperandTwo(3.4);
		calc.setOperation("+");
		calc.performOperation();
		System.out.println(calc.getResults());
		calc.setOperation("-");
		calc.performOperation();
		System.out.println(calc.getResults());
		calc.setOperation("*");
		calc.performOperation();
		System.out.println(calc.getResults());
	}
}
