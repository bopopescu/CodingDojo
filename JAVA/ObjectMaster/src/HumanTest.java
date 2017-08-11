
public class HumanTest {
	public static void main(String[] args){
		human harry = new human();
		human vold = new human();
		harry.display();
		vold.display();
		harry.attack(vold);
		harry.display();
		vold.display();
		Wizard dumbledore = new Wizard();
		Ninja turtle = new Ninja();
		Samurai thebride = new Samurai();
		dumbledore.display();
		turtle.display();
		thebride.display();
		thebride.deathBlow(vold);
		vold.display();
		thebride.display();
		turtle.steal(thebride);
		thebride.display();
		turtle.display();
		dumbledore.fireball(turtle);
		turtle.display();
		dumbledore.display();
		turtle.runAway();
		turtle.display();
		dumbledore.heal(thebride);
		dumbledore.display();
		thebride.display();
		Samurai killbill = new Samurai();
		killbill.meditate();
		killbill.howMany();
		thebride.howMany();
	}
	
}
