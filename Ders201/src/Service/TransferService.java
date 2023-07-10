package Service;

import model.Player;
import model.Team;

import java.math.BigDecimal;

public class TransferService {

	public boolean checkBudget(Team team, Player player){
		if (team.getBudget().compareTo(player.getValue()) >= 0){
			return true;
		}
		else {
			return false;
		}
	}
	public void makeTransfer(Team team, Player player){
		if (checkBudget(team, player)){
			team.setBudget(team.getBudget().subtract(player.getValue()));
		}
		player.getTeamList().get(player.getTeamList().size() - 1).setBudget(
				player.getTeamList().get(player.getTeamList().size() - 1).getBudget().add(player.getValue()));
		player.getTeamList().add(team);
	}
}
