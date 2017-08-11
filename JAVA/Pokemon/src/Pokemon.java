
public class Pokemon {
	private String name;
	private int health;
	private String type;
	
	private static int count;
	
	
	public Pokemon(String name, String type, int health) {
		this.name = name;
		this.health = health;
		this.type = type;
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static Integer getCount() {
		return count;
	}

	public static void setCount(Integer count) {
		Pokemon.count = count;
	}
	
	//ge
}
