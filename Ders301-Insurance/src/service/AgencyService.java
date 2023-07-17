package service;

import model.*;

import java.util.ArrayList;

public class AgencyService {
	//	Creates an Agency object and return with given parameters applied.
	public Agency createAgency(String name) {
		return new Agency(name);
	}

	// Adds Bank Account to Agency's Bank Account List.
	public void addBankAccount(Agency agency, BankAccount bankAccount) {
		if (agency.getBankAccountList() == null) {
			agency.setBankAccountList(new ArrayList<>());
		}
		agency.getBankAccountList().add(bankAccount);
	}

	//	Adds Insurance Company to Agency's Insurance Company List.
	public void addInsuranceCompany(Agency agency, InsuranceCompany insuranceCompany) {
		if (agency.getInsuranceCompanyList() == null) {
			agency.setInsuranceCompanyList(new ArrayList<>());
		}
		agency.getInsuranceCompanyList().add(insuranceCompany);
	}

	//	Adds Customer to Agency's Customer List.
	public void addCustomer(Agency agency, Customer customer) {
		if (agency.getCustomerList() == null) {
			agency.setCustomerList(new ArrayList<>());
		}
		agency.getCustomerList().add(customer);
	}

	// Adds Payment Movement to Agency's Payment Movement List.
	public void addPaymentMovement(Agency agency, PaymentMovement paymentMovement) {
		if (agency.getPaymentMovementList() == null) {
			agency.setPaymentMovementList(new ArrayList<>());
		}
		agency.getPaymentMovementList().add(paymentMovement);
	}
}
