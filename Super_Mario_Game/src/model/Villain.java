package model;

public class Villain extends BaseCharacter {
	private boolean isKillable;
	private int health;
	private MoveTypeEnum moveType;
	private Coordinate coordinate;

	public Villain(String name, boolean isKillable, int health, MoveTypeEnum moveType, Coordinate coordinate) {
		super(name);
		this.isKillable = isKillable;
		this.health = health;
		this.moveType = moveType;
		this.coordinate = coordinate;
	}

	public boolean isKillable() {
		return isKillable;
	}

	public void setKillable(boolean killable) {
		isKillable = killable;
	}

	public MoveTypeEnum getMoveType() {
		return moveType;
	}

	public void setMoveType(MoveTypeEnum moveType) {
		this.moveType = moveType;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public String toString() {
		return "Villain{" +
				", isKillable=" + isKillable +
				", health=" + health +
				", moveType=" + moveType +
				", coordinate=" + coordinate +
				'}';
	}
}
