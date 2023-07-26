import model.Character;
import model.Player;
import model.Pokemon;
import model.WheatherTypeEnum;
import service.CharacterService;
import service.GameService;
import service.LoadService;
import service.PlayerService;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		LoadService load = new LoadService();
		PlayerService playerService = new PlayerService();
		CharacterService characterService = new CharacterService();
		GameService gameService = new GameService();
		Scanner scn = new Scanner(System.in);
		List<Character> characterList = load.initializeCharacters();
		List<Pokemon> pokemonList = load.initializePokemons();
		System.out.println("Welcome to Pokemon Game");
		System.out.println("Player 1 Please enter your name");
		Player player1 = playerService.createPlayer(scn.nextLine(), null);
		System.out.println("Player 2 Please enter your name");
		Player player2 = playerService.createPlayer(scn.nextLine(), null);
		int round = 0;
		while (round != 2) {
			if (player1.getCharacter() == null || player2.getCharacter() == null) {
				if (player1.getCharacter() == null) {
					System.out.println("Player 1 Please choose a character");
					playerService.chooseCharacter(player1, characterList);
				}
				if (player2.getCharacter() == null) {
					System.out.println("Player 2 Please choose a character");
					playerService.chooseCharacter(player2, characterList);
				}
			}
			if (player1.getCharacter().getPokemons().isEmpty()) {
				System.out.println("Player 1 Please choose a pokemon");
				characterService.addPokemon(player1, pokemonList);
			}
			if (player2.getCharacter().getPokemons().isEmpty()) {
				System.out.println("Player 2 Please choose a pokemon");
				characterService.addPokemon(player2, pokemonList);
			}
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
						gameService.fight(player1, player2, true, false, wheather);
					} else if (choice == 2) {
						gameService.fight(player1, player2, true, true, wheather);
					} else if (choice == 3) {
						gameService.fight(player1, player2, false, true, wheather);
					} else if (choice ==4) {
						gameService.fight(player1, player2, false, false, wheather);
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
						gameService.fight(player2, player1, true, false, wheather);
					} else if (choice == 2) {
						gameService.fight(player2, player1, true, true, wheather);
					} else if (choice == 3) {
						gameService.fight(player2, player1, false, true, wheather);
					} else if (choice == 4) {
						gameService.fight(player2, player1, false, false, wheather);
					} else {
						System.out.println("Wrong choice");
					}
					System.out.println("-----------------------------------");
				}
				if (gameService.checkPokemonHealth(player1)) {
					System.out.println("Player 2 won the round");
					gameService.endOfRoundAdjusments(player2, player1, pokemonList);
					round++;
					break;
				}
				if (gameService.checkPokemonHealth(player2)) {
					System.out.println("Player 1 won the round");
					gameService.endOfRoundAdjusments(player1, player2, pokemonList);
					round++;
					break;
				}
			}
		}
	}
}

/*
 * pokemonlar ve karakterler oluşturuluyor. ***
 * Scannerla 2 player geliyor bilgilerini giriyor. karakter seçiyor. ***
 * sonra pokemon seçiyor. ****
 * oyuna başlamak için 1 çıkmak için 2 diyoruz. ***
 * kimin başlayacağı random ile seçiliyor. ***
 * özel güçler kullanılacak mı hangi pokemonla saldırılacak. ***
 * health check ile savaşın durumu kontrol edilir. ***
 * 2. seviyeye geçiliyor kazanan kaybedenin pokemonunu alıyor, canı tekrar eski haline geliyor.**
 * Bizim ilk pokemonumuzun canı kaç kaldıysa o şekilde kalıyor.**
 * karşı tarafta en düşük güçteki pokemon alınıyor.***
 * savaş yeniden başlıyor ve 2. tur bittiğinde oyun sonlanıyor.***
 * her hamleden önce hava durumu değişiyor random geliyor. Pokemonların dezavantajları oluyor. ****
 * */