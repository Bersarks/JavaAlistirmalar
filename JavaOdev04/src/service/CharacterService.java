package service;

import model.Character;
import model.Player;
import model.Pokemon;
import model.SpecialPower;

import java.util.List;
import java.util.Scanner;

public class CharacterService {
	public void addPokemon (Player player, List<Pokemon> pokemons) {
		PokemonService pokemonService = new PokemonService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a pokemon to your character");
		int counter = 1;
		for (Pokemon poke : pokemons) {
			System.out.println( (counter++) +" " + poke.getName());
		}
		int choice = scanner.nextInt();
		player.getCharacter().getPokemons().add(pokemons.get(choice - 1));
		player.getCharacter().setSelectedPokemon(pokemons.get(choice - 1));
		pokemonService.updatePokemons(pokemons, pokemons.get(choice - 1));
	}
	public void updateCharacters(List<Character> characterList, Character character) {
		for (Character chr : characterList) {
			if (chr.getName().equals(character.getName())) {
				characterList.remove(chr);
				break;
			}
		}
	}

	public void selectPokemon(Player player) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a pokemon to your character");
		int counter = 1;
		for (Pokemon poke : player.getCharacter().getPokemons()) {
			System.out.println( (counter++) +" " + poke.getName());
		}
		int choice = scanner.nextInt();
		player.getCharacter().setSelectedPokemon(player.getCharacter().getPokemons().get(choice - 1));
	}
}
