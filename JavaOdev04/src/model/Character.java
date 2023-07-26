package model;

import java.util.List;

public class Character {
	private String name;
	private SpecialPower specialPower;
	private List<Pokemon> pokemons;
	private Pokemon selectedPokemon;

	public Character(String name, SpecialPower specialPower, List<Pokemon> pokemons) {
		this.name = name;
		this.specialPower = specialPower;
		this.pokemons = pokemons;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SpecialPower getSpecialPower() {
		return specialPower;
	}

	public void setSpecialPower(SpecialPower specialPower) {
		this.specialPower = specialPower;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public Pokemon getSelectedPokemon() {
		return selectedPokemon;
	}

	public void setSelectedPokemon(Pokemon selectedPokemon) {
		this.selectedPokemon = selectedPokemon;
	}

	@Override
	public String toString() {
		return "Character{" +
				"name='" + name + '\'' +
				", specialPower=" + specialPower +
				", pokemons=" + pokemons +
				'}';
	}
}
