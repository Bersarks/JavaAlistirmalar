package model;

public class Mario extends MarioBaseCharacter{

	public Mario(String name, int health, int lifeCount, GrowthCycleEnum growthCycle, int lenght, boolean immortality, Coordinate coordinate) {
		super(name, health, lifeCount, growthCycle, lenght, immortality, coordinate);
	}
}
