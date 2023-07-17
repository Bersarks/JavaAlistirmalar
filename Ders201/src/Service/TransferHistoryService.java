package Service;

import model.Player;
import model.Team;
import model.TransferHistory;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;

public class TransferHistoryService {
	public void addToTransferHistory(Team team, Player player) {
		if (player.getTransferHistories() == null) {
			player.setTransferHistories(new ArrayList<>());
			TransferHistory transferHistory = new TransferHistory();
			transferHistory.setFromTeam(team);
			transferHistory.setPlayer(player);
			transferHistory.setYear(2018);
			transferHistory.setFee(player.getValue());
			transferHistory.setCurrency(player.getCurrency());
			player.getTransferHistories().add(transferHistory);
		} else {
			model.TransferHistory transferHistory = new model.TransferHistory();
			transferHistory.setFromTeam(player.getTeamList().get(player.getTeamList().size() - 1));
			transferHistory.setPlayer(player);
			transferHistory.setYear(2018);
			transferHistory.setFee(player.getValue());
			transferHistory.setCurrency(player.getCurrency());
			player.getTransferHistories().add(transferHistory);
		}
	}
}
