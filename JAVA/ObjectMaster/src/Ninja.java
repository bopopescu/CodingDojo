
public class Ninja extends human{
	public Ninja() {
		this.stealth = 10;
	}
	
	public void steal(human h) {
		int temp = this.stealth;
		this.stealth = temp +  h.health;
		h.health = h.health - temp;
	}
	
	public void runAway() {
		this.health -= 10;
	}
}
