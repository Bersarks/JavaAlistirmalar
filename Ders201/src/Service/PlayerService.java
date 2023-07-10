package Service;

import model.Player;
import model.Team;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {
	// yeni bir oyuncu eklenecek
	// Başlangıçta bir takımı var.
	public Player createPlayer(String name, String surname, int kitNumber, String position, int birthYear, BigDecimal value, String currency){
		Player player = new Player(name, surname, kitNumber, position, birthYear, value, currency);
		return player;
	}
	public Player createPlayerWithTeam(String name, String surname, int kitNumber, String position, int birthYear, Team team){
		Player player = new Player(name, surname, kitNumber, position, birthYear);
		addTeamToPlayer(player, team);
		return player;
	}
	public void addTeamToPlayer(Player player, Team team){
		if (player.getTeamList() == null){
			player.setTeamList(new ArrayList<>());
			player.getTeamList().add(team);
		}
		/*else {
			List<Team> currentTeam = new ArrayList<>();
			currentTeam.add(team);
			player.setTeamList(currentTeam);
		}*/
		else {
			player.getTeamList().add(team);
		}
	}

	// Transfer oldukça takımı değişecek
}
