package model;

public class Reptile extends Villain{

	public Reptile(String name, int damage, boolean isKillable, int health, MoveTypeEnum moveType, Coordinate coordinate) {
		super(name, damage, isKillable, health, moveType, coordinate);
	}
}
