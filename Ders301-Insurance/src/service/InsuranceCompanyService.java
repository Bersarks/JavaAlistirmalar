package service;

import model.BankAccount;
import model.Insurance;
import model.InsuranceCompany;
import model.PaymentMovement;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InsuranceCompanyService {
	//	Creates a new insurance company with the given parameters.
	public InsuranceCompany createInsuranceCompany(String name, String taxOffice, String taxNumber, String address, BigDecimal commission) {
		return new InsuranceCompany(name, taxOffice, taxNumber, address, commission);
	}

	//	Adds an insurance to the insurance company.
	public void addInsurance(InsuranceCompany insuranceCompany, Insurance insurance) {
		if (insuranceCompany.getInsuranceList() == null) {
			insuranceCompany.setInsuranceList(new ArrayList<>());
		}
		insuranceCompany.getInsuranceList().add(insurance);
	}

	//	Adds a bank account to the insurance company.
	public void addBankAccount(InsuranceCompany insuranceCompany, BankAccount bankAccount) {
		if (insuranceCompany.getBankAccountList() == null) {
			insuranceCompany.setBankAccountList(new ArrayList<>());
		}
		insuranceCompany.getBankAccountList().add(bankAccount);
	}

	//	Adds a payment movement to the insurance company.
	public void addPaymentMovement(InsuranceCompany insuranceCompany, PaymentMovement paymentMovement) {
		if (insuranceCompany.getPaymentMovementList() == null) {
			insuranceCompany.setPaymentMovementList(new ArrayList<>());
		}
		insuranceCompany.getPaymentMovementList().add(paymentMovement);
	}
}
