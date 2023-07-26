package service;

import model.*;
import model.Character;

import java.util.ArrayList;

public class LoadService {
	public ArrayList<Character> initializeCharacters() {
		ArrayList<Character> characters = new ArrayList<>();

		Character ash = new Ash("Ash", new StrategySP("Strategy", 10, 1), new ArrayList<>());
		Character brock = new Brock("Brock", new StrategySP("Strategy", 10, 1), new ArrayList<>());
		characters.add(ash);
		characters.add(brock);
		return characters;
	}

	public ArrayList<Pokemon> initializePokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<>();
		Pokemon pikachu = new Pikachu("Pikachu", 100, 20, TypeEnum.ELECTRIC,
				new SpecialPower("Lighting Strike", 15, 1));
		Pokemon charmender = new Charmender("Charmander", 100, 20, TypeEnum.FIRE,
				new SpecialPower("Flame Ball", 25, 1));
		Pokemon jigglypuff = new Jigglypuff("jigglypuff", 100, 20, TypeEnum.FAIRY,
				new SpecialPower("Sing", 15, 1));
		Pokemon bulbasaur = new Bulbasaur("Bulbasaur", 100, 20, TypeEnum.GRASS,
				new SpecialPower("Vine Whip", 20, 1));
		Pokemon squirtle = new Squirtle("Squirtle", 100, 17, TypeEnum.WATER,
				new SpecialPower("Vine Whip", 20, 1));
		pokemons.add(pikachu);
		pokemons.add(charmender);
		pokemons.add(jigglypuff);
		pokemons.add(bulbasaur);
		return pokemons;
	}
}
