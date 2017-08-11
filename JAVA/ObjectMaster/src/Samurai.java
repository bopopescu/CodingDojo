
public class Samurai extends human{
	private static int counter;
	public Samurai() {
		this.health = 200;
		counter++;
	}
	
	public void deathBlow(human h) {
		h.health = 0;
		System.out.println("Killed a human");
		this.health = this.health/2;
	}
	
	public void meditate() {
		this.health = this.health*2;
	}
	
	public void howMany() {
		System.out.println("There are about "+counter+" samurais.");
	}
	
}
