package model;

public class SpecialPower {
	private String name;
	private int damage;
	private int usageCount;

	public SpecialPower(String name, int damage, int usageCount) {
		this.name = name;
		this.damage = damage;
		this.usageCount = usageCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getUsageCount() {
		return usageCount;
	}

	public void setUsageCount(int usageCount) {
		this.usageCount = usageCount;
	}

	@Override
	public String toString() {
		return "SpecialPower{" +
				"name='" + name + '\'' +
				", damage=" + damage +
				", usageCount=" + usageCount +
				'}';
	}
}
