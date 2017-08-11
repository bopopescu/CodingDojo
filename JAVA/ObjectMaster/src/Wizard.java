
public class Wizard extends human{
	public Wizard() {
		this.health = 50;
		this.intelligence = 80;
	}
	
	public void heal(human h) {
		h.health += this.intelligence;
	}
	
	public void fireball(human h) {
		h.health = h.health - this.intelligence*3;
	}
}
