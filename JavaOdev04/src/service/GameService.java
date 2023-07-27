package service;

import model.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameService {
	public void fight(Player attacker, Player defender, boolean isPokeSpecialPower, boolean isCharSpecialPower,
					  WheatherTypeEnum wheatherType){

		CharacterService characterService = new CharacterService();
		if (attacker.getCharacter().getPokemons().size() > 1){
			System.out.println("Are you want to change your pokemon? (y/n)");
			Scanner scanner = new Scanner(System.in);
			String choice = scanner.nextLine();
			if (choice.equals("y")) {
				characterService.selectPokemon(attacker);
			}
		}
		Pokemon attackerPokemon = attacker.getCharacter().getSelectedPokemon();
		Pokemon defenderPokemon = defender.getCharacter().getPokemons().get(0);
		if (isPokeSpecialPower && isCharSpecialPower) {
			if (attackerPokemon.getSpecialPower().getUsageCount() == 0 && attacker.getCharacter().getSpecialPower().getUsageCount() == 0) {
				System.out.println("Special power is not available, " + attacker.getName() + " missed the turn");
				return;
			}
		} else if (isCharSpecialPower || isPokeSpecialPower) {
			if (isPokeSpecialPower && attackerPokemon.getSpecialPower().getUsageCount() == 0) {
				System.out.println("Pokemon special power is not available, " + attacker.getName() + " missed the turn");
				return;
			}
			if (isCharSpecialPower && attacker.getCharacter().getSpecialPower().getUsageCount() == 0) {
				System.out.println("Character special power is not available, " + attacker.getName() + " missed the turn");
				return;
			}
		}
		int wheatherEffectDebuff = getWheatherEffectDebuff(wheatherType, attackerPokemon.getType());
		if (isCharSpecialPower) {
			int damage = attacker.getCharacter().getSpecialPower().getDamage();
			if (damage > 0) {
				defenderPokemon.setHp(defenderPokemon.getHp() - damage);
				attacker.getCharacter().getSpecialPower().setUsageCount
						(attacker.getCharacter().getSpecialPower().getUsageCount() - 1);
			}
		}
		if (isPokeSpecialPower) {
			int damage = attackerPokemon.specialAttack(wheatherEffectDebuff);
			if (damage > 0) {
				defenderPokemon.setHp(defenderPokemon.getHp() - damage);
				System.out.println(attacker.getName() + " attacked with " + attackerPokemon.getName()+ " to "
						+ defender.getName() + "'s " + defenderPokemon.getName());
				System.out.println(defender.getName() + "'s " + defenderPokemon.getName() + " has " + defenderPokemon.getHp() + " hp");
				System.out.println("Wheather effect Debuff: " + (-1 * wheatherEffectDebuff));
				System.out.println("--------------------------------------------------");
				return;
			}
		}

		defenderPokemon.setHp(defenderPokemon.getHp() - (attackerPokemon.getAttack() - wheatherEffectDebuff));
		System.out.println(attacker.getName() + " attacked with " + attackerPokemon.getName()+ " to "
				+ defender.getName() + "'s " + defenderPokemon.getName());
		System.out.println(defender.getName() + "'s " + defenderPokemon.getName() + " has " + defenderPokemon.getHp() + " hp");
		System.out.println("Wheather effect Debuff: " + (-1 * wheatherEffectDebuff));
		System.out.println("--------------------------------------------------");
	}

	public boolean checkPokemonHealth(Player player) {
		for (Pokemon pokemon : player.getCharacter().getPokemons()) {
			if (pokemon.getHp() > 0) {
				return false;
			}
		}
		return true;
	}

	public void endOfRoundAdjusments(Player winner, Player loser, List<Pokemon> pokemons){
		PokemonService pokemonService = new PokemonService();
		for (Pokemon pokemon : loser.getCharacter().getPokemons()){
			if (pokemon.getHp() <= 0){
				pokemon.setHp(100);
				winner.getCharacter().getPokemons().add(pokemon);
				loser.getCharacter().getPokemons().remove(pokemon);
				break;
			}
		}
		Pokemon temp = pokemons.get(0);
		for (Pokemon pokemon : pokemons){
			if (temp.getAttack() < pokemon.getAttack()){
				temp = pokemon;
			}
		}
		loser.getCharacter().getPokemons().add(temp);
		pokemonService.updatePokemons(pokemons, temp);
	}

	public int getWheatherEffectDebuff(WheatherTypeEnum wheather, TypeEnum type){
		if (wheather == WheatherTypeEnum.RAINY){
			if (type == TypeEnum.WATER){
				return -3;
			} else if (type == TypeEnum.FIRE){
				return 5;
			} else if (type == TypeEnum.ELECTRIC) {
				return -5;
			}
		} else if (wheather == WheatherTypeEnum.SUNNY){
			if (type == TypeEnum.FIRE){
				return -5;
			} else if (type == TypeEnum.WATER){
				return 5;
			} else if (type == TypeEnum.ELECTRIC) {
				return 3;
			}
		} else if (wheather == WheatherTypeEnum.CLOUDY){
			if (type == TypeEnum.ELECTRIC){
				return -3;
			} else if (type == TypeEnum.FIRE){
				return 3;
			} else if (type == TypeEnum.FAIRY) {
				return -5;
			}
		} else if (wheather == WheatherTypeEnum.WINDY) {
			if (type == TypeEnum.GRASS) {
				return -5;
			} else if (type == TypeEnum.WATER) {
				return 3;
			} else if (type == TypeEnum.FIRE) {
				return -3;
			} else if (type == TypeEnum.ELECTRIC) {
				return 5;
			}
		}
		return 0;
	}

	public int startGame(Player player1, Player player2, int round, List<Pokemon> pokemonList){
		Random rand = new Random();
		Scanner scn = new Scanner(System.in);
		while (!(player1.isWinner() && player2.isWinner())) {
			int wheatherValue = rand.nextInt(4);
			WheatherTypeEnum wheather = WheatherTypeEnum.values()[wheatherValue];
			System.out.println(wheather.name() + " wheather is started");
			int random = rand.nextInt(2);
			if (random == 0) {
				System.out.println("Player 1 will attack");
				System.out.println("if you want use your pokemon special power press 1\n" +
						"if you want to use your both special power 2\n" +
						"if you want to use your character special power press 3\n" +
						"if you want to normal attack 4");
				int choice = scn.nextInt();
				if (choice == 1) {
					fight(player1, player2, true, false, wheather);
				} else if (choice == 2) {
					fight(player1, player2, true, true, wheather);
				} else if (choice == 3) {
					fight(player1, player2, false, true, wheather);
				} else if (choice ==4) {
					fight(player1, player2, false, false, wheather);
				} else {
					System.out.println("Wrong choice");
				}
			} else {
				System.out.println("Player 2 will attack");
				System.out.println("if you want use your pokemon special power press 1\n" +
						"if you want to use your both special power 2\n" +
						"if you want to use your character special power press 3\n" +
						"if you want to normal attack 4");
				int choice = scn.nextInt();
				if (choice == 1) {
					fight(player2, player1, true, false, wheather);
				} else if (choice == 2) {
					fight(player2, player1, true, true, wheather);
				} else if (choice == 3) {
					fight(player2, player1, false, true, wheather);
				} else if (choice == 4) {
					fight(player2, player1, false, false, wheather);
				} else {
					System.out.println("Wrong choice");
				}
				System.out.println("-----------------------------------");
			}
			if (checkPokemonHealth(player1)) {
				System.out.println("Player 2 won the round");
				endOfRoundAdjusments(player2, player1, pokemonList);
				round ++;
				break;
			}
			if (checkPokemonHealth(player2)) {
				System.out.println("Player 1 won the round");
				endOfRoundAdjusments(player1, player2, pokemonList);
				round++;
				break;
			}
		}
		return round;
	}
}
