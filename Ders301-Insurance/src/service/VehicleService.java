package service;

import model.Accident;
import model.ColorTypeEnum;
import model.Vehicle;

import java.util.ArrayList;

public class VehicleService {
	//	Creates a vehicle object with the given parameters.
	public Vehicle createVehicle(String model, String brand, String plate, String chassisNumber, int modelYear,
								 ColorTypeEnum color) {
		Vehicle vehicle = new Vehicle();
		vehicle.setModel(model);
		vehicle.setBrand(brand);
		vehicle.setPlate(plate);
		vehicle.setChassisNumber(chassisNumber);
		vehicle.setModelYear(modelYear);
		vehicle.setColor(color);
		return vehicle;
	}

	// Adds an accident to the vehicle's accident list.
	public void addAccidentList(Vehicle vehicle, Accident accident) {
		if (vehicle.getAccidentList() == null) {
			vehicle.setAccidentList(new ArrayList<Accident>());
		}
		vehicle.getAccidentList().add(accident);
	}
}
