package model;

public class Collectible extends BaseCharacter {
	private CollectibleTypeEnum collectibleType;

	private Coordinate coordinate;

	public Collectible(String name, CollectibleTypeEnum collectibleType, Coordinate coordinate) {
		super(name);
		this.collectibleType = collectibleType;
		this.coordinate = coordinate;
	}

	public CollectibleTypeEnum getCollectibleType() {
		return collectibleType;
	}

	public void setCollectibleType(CollectibleTypeEnum collectibleType) {
		this.collectibleType = collectibleType;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "Collectible{" +
				"collectibleType=" + collectibleType +
				", coordinate=" + coordinate +
				'}';
	}
}
