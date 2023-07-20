package model;

public class Dog extends Animal { // eğer istediğimiz constructor super lclassda yoksa super() içinde onu initialize edersek sorun kalkar.
	public Dog() {
	}

	public Dog(int age, boolean isVegetarian) {
		//super(age, isVegetarian);
		this.setAge(age * 5);
	}

	public String animalSound() {
		return "Hav Hav";
	}
}
