package service;

import model.Pokemon;

import java.util.List;

public class PokemonService {
	public void updatePokemons(List<Pokemon> pokemons, Pokemon pokemon) {
		for (Pokemon poke : pokemons) {
			if (poke.getName().equals(pokemon.getName())) {
				pokemons.remove(poke);
				break;
			}
		}
	}
}
