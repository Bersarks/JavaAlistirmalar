import Service.PlayerService;
import Service.TeamService;
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

		Team team = teamService.createTeam("Real Madrid", "Los Blancos", "White", "Zidane",
				"Florentino Perez", "Santiago Bernabeu", new BigDecimal(1000000000), "EUR");



		teamService.addAward(team, "La Liga", AwardCategoryEnum.LEAGUE, AwardTypeEnum.CUP, 2017);
		teamService.addAward(team, "Champions League", AwardCategoryEnum.INTERNATIONAL, AwardTypeEnum.CUP, 2017);
		System.out.println(team.toString());
	}
}