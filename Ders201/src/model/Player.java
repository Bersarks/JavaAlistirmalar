package model;

import java.util.List;

public class Player {
	private String name;
	private String surname;
	private int kitNumber;
	private String position;
	private int birthYear;

	private List<TransferHistory> transferHistories;
	private List<Team> teamList;

	public Player(String name, String surname, int kitNumber, String position, int birthYear) {
		this.name = name;
		this.surname = surname;
		this.kitNumber = kitNumber;
		this.position = position;
		this.birthYear = birthYear;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getKitNumber() {
		return kitNumber;
	}

	public void setKitNumber(int kitNumber) {
		this.kitNumber = kitNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public List<TransferHistory> getTransferHistories() {
		return transferHistories;
	}

	public void setTransferHistories(List<TransferHistory> transferHistories) {
		this.transferHistories = transferHistories;
	}

	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}


}
