import model.Character;
import model.Player;
import model.Pokemon;
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
			round = gameService.startGame(player1, player2, round, pokemonList);
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