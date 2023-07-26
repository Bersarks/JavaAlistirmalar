package model;

public class Pokemon {
	private String name;
	private int hp;
	private int attack;
	private TypeEnum type;
	private SpecialPower specialPower;

	public Pokemon(String name, int hp, int attack, TypeEnum type, SpecialPower specialPower) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.type = type;
		this.specialPower = specialPower;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public SpecialPower getSpecialPower() {
		return specialPower;
	}

	public void setSpecialPower(SpecialPower specialPower) {
		this.specialPower = specialPower;
	}
	public int specialAttack(int deBuff) {
		if (specialPower.getUsageCount() == 0) {
			System.out.println("Special power is not available");
			return 0;
		}
		specialPower.setUsageCount(specialPower.getUsageCount() - 1);
		return (this.attack - deBuff) + specialPower.getDamage();
	}

	@Override
	public String toString() {
		return "Pokemon{" +
				"name='" + name + '\'' +
				", hp=" + hp +
				", attack=" + attack +
				", type=" + type +
				", specialPower=" + specialPower +
				'}';
	}
}
