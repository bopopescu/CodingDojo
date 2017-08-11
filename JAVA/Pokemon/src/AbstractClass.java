
public abstract class AbstractClass implements PokemonInterface {
	
//	@Override
	public Pokemon createPokemon(String name, String type, int health) {
		Pokemon newPokemon = new Pokemon(name, type, health);
		return newPokemon;
	}
	
	public void attackPokemon(Pokemon gettingAttacked) {
		int getHealth;
		getHealth = gettingAttacked.getHealth();
		getHealth = getHealth - 10;
		gettingAttacked.setHealth(getHealth);
	}
	
	
}
