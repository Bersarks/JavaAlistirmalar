package service;

import model.Insurance;
import model.InsuranceTypeEnum;

public class InsuranceService {
	//	Creates an insurance object with the given parameters.
	public Insurance createInsurance(InsuranceTypeEnum insuranceTypeEnum, String name) {
		return new Insurance(insuranceTypeEnum, name);
	}
}
