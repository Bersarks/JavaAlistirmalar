package service.interfaces;

import model.Car;

public interface ICarService {
	int x = 5; // public static final int x = 5;

	default public void horn() { // default method in interface does not need to be implemented in the class
		System.out.println(x + "BEEP BEEP");
	}

	static public void staticHorn() { // static method in interface does not need to be implemented in the class
		System.out.println(x + "BIP BOP");
	}
	public void speed(int x, double y);

	public void handBreak();

	public void engineSound();

	public void oilChange(Car car);
}
