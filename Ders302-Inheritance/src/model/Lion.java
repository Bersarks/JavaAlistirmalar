package model;

public class Lion extends Animal {
	public Lion() {
		System.out.println("Lion constructor");
	}

	public Lion(int age, boolean isVegetarian) {
		super(age, isVegetarian);
	}
}
