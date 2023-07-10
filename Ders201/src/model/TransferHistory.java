package model;

import java.math.BigDecimal;
import java.util.List;

public class TransferHistory {
	private Team fromTeam;
	private Player player;
	private int year;
	private BigDecimal fee;
	private List<TransferHistory> transferHistories;
	private String currency;

	public Team getFromTeam() {
		return fromTeam;
	}

	public void setFromTeam(Team fromTeam) {
		this.fromTeam = fromTeam;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public List<TransferHistory> getTransferHistories() {
		return transferHistories;
	}

	public void setTransferHistories(List<TransferHistory> transferHistories) {
		this.transferHistories = transferHistories;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
