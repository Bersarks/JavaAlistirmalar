package Service;

import java.math.BigDecimal;
import java.util.ArrayList;

import model.Currency;
import model.Player;
import model.Team;

public class TransferService {
	CurrencyService currencyService = new CurrencyService();

	public boolean checkBudget(Team team, Player player) {
		return team.getBudget().compareTo(player.getValue()) >= 0;
	}

	public void makeTransfer(Team team, Player player, ArrayList<Currency> currencyList) {
		if (team.getCurrency() != player.getCurrency()) {
			team.setBudget(currencyService.exchangeCurrency(currencyList, player.getCurrency(),
					team.getCurrency(), team.getBudget()));
		}
		if (checkBudget(team, player)) {
			team.setBudget(team.getBudget().subtract(player.getValue()));
			team.setBudget(currencyService.exchangeCurrency(currencyList, team.getCurrency(),
					player.getCurrency(), team.getBudget()));
			Team buyer = player.getTeamList().get(player.getTeamList().size() - 1);
			if (buyer.getCurrency() != player.getCurrency()) {
				buyer.setBudget(currencyService.exchangeCurrency(currencyList, player.getCurrency(),
						buyer.getCurrency(), buyer.getBudget()));
				buyer.setBudget(buyer.getBudget().add(player.getValue()));
				buyer.setBudget(currencyService.exchangeCurrency(currencyList, buyer.getCurrency(),
						player.getCurrency(), buyer.getBudget()));
			} else {
				buyer.setBudget(buyer.getBudget().add(player.getValue()));
			}
			player.getTeamList().add(team);
			TransferHistoryService transferHistoryService = new TransferHistoryService();
			transferHistoryService.addToTransferHistory(team, player);
		} else {
			System.out.println("Budget is not enough!");
		}
	}
}
