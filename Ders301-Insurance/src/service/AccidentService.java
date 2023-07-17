package service;

import model.Accident;

import java.math.BigDecimal;
import java.util.Date;

public class AccidentService {
	public Accident createAccident (Date accidentDate, String description, BigDecimal damagePrice, int failureRate) {

		return new Accident(accidentDate, description, damagePrice, failureRate);
	}
}
