import model.Car;
import model.Mercedes;
import service.CarService;
import service.interfaces.ICarService;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		CarService carService = new CarService();
		ICarService iCarService = new CarService(); // implement ettiği classtan oluşturursak interface üzerinden erişebiliriz

		List<String> asd = new ArrayList<>(); // List bir interface olmasına rağmen ArrayList ile mothodları override etmeden kullanabiliyoruz.


		Car mercedes = new Mercedes();
		mercedes.setBrand("Opel");
		mercedes.setModel("Astra");
		mercedes.setColor("Red");
		mercedes.setPlate("34 ABC 34");
		mercedes.setZeroToHundredSpeedTime(10);
		mercedes.setHorsePower(4000);
		mercedes.setWeight(1450);
		int calculate = mercedes.zeroToHundredCalculate();
		System.out.println(calculate);
		iCarService.horn(); //default method in interface
		ICarService.staticHorn(); //static method in interface
		carService.horn(); //default method call in implemented class
	}
}