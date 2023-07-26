package model;

public class Mercedes extends Car{

	@Override
	public void carColor() {

	}

	@Override
	public int zeroToHundredCalculate() {
		return (getHorsePower() / getWeight()) * 7;
	}
}
