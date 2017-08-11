
public class human {
	protected int strength = 3;
	protected int stealth = 3;
	protected int intelligence = 3;
	protected int health = 100;
	
	public void attack(human h) {
		h.health = h.health - strength;
	}
	
	public void display() {
		System.out.println("Health: "+health);
	}
	
}
