package model;

public class MarioBaseCharacter extends BaseCharacter {
	private int lifeCount;
	private GrowthCycleEnum growthCycle;
	private Coordinate coordinate;
	private int collectedCoins = 0;
	private boolean hasFireFlower = false;

	public MarioBaseCharacter(String name, int lifeCount, GrowthCycleEnum growthCycle, Coordinate coordinate) {
		super(name);
		this.lifeCount = lifeCount;
		this.growthCycle = growthCycle;
		this.coordinate = coordinate;
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


	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public int getCollectedCoins() {
		return collectedCoins;
	}

	public void setCollectedCoins(int collectedCoins) {
		this.collectedCoins = collectedCoins;
	}

	public boolean isHasFireFlower() {
		return hasFireFlower;
	}

	public void setHasFireFlower(boolean hasFireFlower) {
		this.hasFireFlower = hasFireFlower;
	}

	@Override
	public String toString() {
		return "MarioBaseCharacter{" +
				"lifeCount=" + lifeCount +
				", growthCycle=" + growthCycle +
				", coordinate=" + coordinate +
				", collectedCoins=" + collectedCoins +
				", hasFireFlower=" + hasFireFlower +
				'}';
	}
}
