package service;

import model.Character;
import model.Player;

import java.util.List;
import java.util.Scanner;

public class PlayerService {
	public Player createPlayer(String name, Character character) {
		return new Player(name, character, false);
	}

	public void chooseCharacter(Player player, List<Character> characterList) {
		CharacterService characterService = new CharacterService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a character");
		int counter = 1;
		for (Character character : characterList) {
			System.out.println((counter++) +" " + character.getName());
		}
		int choice = scanner.nextInt();
		player.setCharacter(characterList.get(choice - 1));
		characterService.updateCharacters(characterList, characterList.get(choice - 1));
	}
}
