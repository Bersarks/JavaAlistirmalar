import Service.PlayerService;
import Service.TeamService;
import Service.TransferService;
import model.Player;
import model.Team;
import model.TransferHistory;
import model.AwardCategoryEnum;
import model.AwardTypeEnum;
import model.Award;


import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		PlayerService playerService = new PlayerService();
		TeamService teamService = new TeamService();
		TransferService transferService = new TransferService();

		ArrayList<Team> teams = new ArrayList<Team>();
		ArrayList<Player> players = new ArrayList<Player>();

		Team team = teamService.createTeam("Real Madrid", "Los Blancos", "White", "Zidane",
				"Florentino Perez", "Santiago Bernabeu", new BigDecimal(1000000000), "EUR");
		teams.add(team);
		Team team2 = teamService.createTeam("Barcelona", "Blaugrana", "Blue", "Ernesto Valverde",
				"Josep Maria Bartomeu", "Camp Nou", new BigDecimal(1000000000), "EUR");
		teams.add(team2);
		Team team3 = teamService.createTeam("Juventus", "Bianconeri", "Black", "Massimiliano Allegri",
				"Andrea Agnelli", "Allianz Stadium", new BigDecimal(1000000000), "EUR");
		teams.add(team3);

		teamService.addAward(team, "La Liga", AwardCategoryEnum.LEAGUE, AwardTypeEnum.CUP, 2017);
		teamService.addAward(team, "Champions League", AwardCategoryEnum.INTERNATIONAL, AwardTypeEnum.CUP, 2017);
		System.out.println(team.toString());

		Player player = playerService.createPlayer("Cristiano", "Ronaldo", 7, "Forward", 1985, new BigDecimal(50000000), "EUR");
		players.add(player);
		Player player2 = playerService.createPlayerWithTeam("Lionel", "Messi", 10, "Forward", 1987, team2);
		playerService.addTeamToPlayer(players.get(0), teams.get(0));
		transferService.makeTransfer(teams.get(2), players.get(0));
		for(Player p : players) {
			System.out.println(p.toString());
		}
		for(Team t : teams) {
			System.out.println(t.toString());
		}
	}
}
// currency dolar, euro, tl ve tüm stringler obje olacak. Ekleme çıkartma kontrol işlemlerinde kur değişimleri hesaplanacak.