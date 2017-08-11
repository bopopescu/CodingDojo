
public class Dragon extends Mammal{
	public Dragon()
	{
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("Whoosh");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("NomNom");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("AHHH");
		this.energyLevel -= 100;
	}
}
