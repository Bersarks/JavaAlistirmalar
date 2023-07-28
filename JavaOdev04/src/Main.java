import model.Character;
import model.Pokemon;
import service.GameService;
import service.LoadService;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		LoadService load = new LoadService();
		GameService gameService = new GameService();
		List<Character> characterList = load.initializeCharacters();
		List<Pokemon> pokemonList = load.initializePokemons();
		gameService.startGame(characterList, pokemonList);
	}
}