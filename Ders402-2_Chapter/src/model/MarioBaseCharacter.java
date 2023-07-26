package model;

public class MarioBaseCharacter extends BaseCharacter {
	private int health;
	private int lifeCount;
	private GrowthCycleEnum growthCycle;
	private int lenght;
	private boolean immortality;
	private Coordinate coordinate;

	public MarioBaseCharacter(String name, int health, int lifeCount, GrowthCycleEnum growthCycle, int lenght, boolean immortality, Coordinate coordinate) {
		super(name);
		this.health = health;
		this.lifeCount = lifeCount;
		this.growthCycle = growthCycle;
		this.lenght = lenght;
		this.immortality = immortality;
		this.coordinate = coordinate;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLifeCount() {
		return lifeCount;
	}

	public void setLifeCount(int lifeCount) {
		this.lifeCount = lifeCount;
	}

	public GrowthCycleEnum getGrowthCycle() {
		return growthCycle;
	}

	public void setGrowthCycle(GrowthCycleEnum growthCycle) {
		this.growthCycle = growthCycle;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public boolean isImmortality() {
		return immortality;
	}

	public void setImmortality(boolean immortality) {
		this.immortality = immortality;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "MarioBaseCharacter{" +
				"health=" + health +
				", lifeCount=" + lifeCount +
				", growthCycle=" + growthCycle +
				", lenght=" + lenght +
				", immortality=" + immortality +
				", coordinate=" + coordinate +
				'}';
	}
}
