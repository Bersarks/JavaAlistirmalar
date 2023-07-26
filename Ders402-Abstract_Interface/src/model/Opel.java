package model;

public class Opel extends Car {

	@Override
	public void carColor() {

	}

	@Override
	public int zeroToHundredCalculate() {
		return (getHorsePower() / getWeight()) * 2;
	}
}
