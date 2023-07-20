package model;

public class Animal {
	private int age;
	private boolean isVegetarian;
	private String movementType;
	private String habitat;
	private String sound;

	public Animal() {
		System.out.println("Animal constructor");
	}

	public Animal(int age, boolean isVegetarian) {
		this.age = age;
		this.isVegetarian = isVegetarian;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isVegetarian() {
		return isVegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		isVegetarian = vegetarian;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"age=" + age +
				", isVegetarian=" + isVegetarian +
				", movementType='" + movementType + '\'' +
				", habitat='" + habitat + '\'' +
				", sound='" + sound + '\'' +
				'}';
	}

	public String animalSound() {
		return "Heyooo";
	}
}
