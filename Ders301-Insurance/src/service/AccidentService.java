package service;

import model.Accident;

import java.math.BigDecimal;
import java.time.LocalDate;


public class AccidentService {
	/*
	 * Creates an Accident object and return with given parameters applied.
	 * */
	public Accident createAccident(LocalDate accidentDate, String description, BigDecimal damagePrice, int failureRate) {

		return new Accident(accidentDate, description, damagePrice, failureRate);
	}

}
