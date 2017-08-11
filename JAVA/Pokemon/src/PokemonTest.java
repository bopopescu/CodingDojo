
public class PokemonTest {
	public static void main(String[] args){
		Pokemon bulbasaur = new Pokemon("Bulbasaur", "Green", 50);
		Pokemon pikachu = new Pokemon("Pikachu", "Yellow", 20);
		Pokemon charmander = new Pokemon("Charmander", "Orange", 200);
		
		Pokedex somePokedex = new Pokedex();
		Pokemon squirtle = somePokedex.createPokemon("Squirtle", "Water", 120);
		System.out.println(somePokedex.pokemonInfo(bulbasaur));
		System.out.print(somePokedex+"/n");
		somePokedex.attackPokemon(squirtle);
		System.out.println(somePokedex.pokemonInfo(squirtle));
	}
}
