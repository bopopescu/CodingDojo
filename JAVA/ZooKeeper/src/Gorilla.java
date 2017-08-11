
public class Gorilla extends Mammal {
	public Gorilla()
	{
		//System.out.println("An apple has been created");
	}
	public void throwsomething() {
		System.out.println("Gorilla has thrown something");
		energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Gorilla has eaten banana and is satisfied");
		energyLevel += 10;
	}
	public void climb() {
		System.out.println("Gorilla has climbed a tree");
		energyLevel -= 10;
	}
}
