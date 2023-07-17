package model;

import java.math.BigDecimal;
import java.util.List;

public class Team {
	private String name;
	private String nickName;
	private String colors;
	private String coach;
	private String president;
	private String stadium;
	private BigDecimal budget;
	private String currency;
	private List<Award> awards;

	public Team() {

	}

	public Team(String name, String nickName, String colors, String coach, String president, String stadium,
				BigDecimal budget, String currency) {
		this.name = name;
		this.nickName = nickName;
		this.colors = colors;
		this.coach = coach;
		this.president = president;
		this.stadium = stadium;
		this.budget = budget;
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<Award> getAwards() {
		return awards;
	}

	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}

	@Override
	public String toString() {
		return "Team{" +
				"name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
				", colors='" + colors + '\'' +
				", coach='" + coach + '\'' +
				", president='" + president + '\'' +
				", stadium='" + stadium + '\'' +
				", budget=" + budget +
				", currency='" + currency + '\'' +
				", awards=" + awards +
				'}';
	}
}
