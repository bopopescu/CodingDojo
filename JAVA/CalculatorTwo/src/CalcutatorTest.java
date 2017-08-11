
public class CalcutatorTest {
	public static void main(String[] args){
		CalculatorTwo c = new CalculatorTwo();
		c.performOperation(10);
		c.performOperation("*");
		c.performOperation(2);
		c.performOperation("-");
		c.performOperation(5);
		c.performOperation("=");
		System.out.println(c.getResults());
	}

}
