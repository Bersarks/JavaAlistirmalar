package service;

import model.*;

import java.util.ArrayList;

public class AgencyService {
	public Agency createAgency(String name) {
		return new Agency(name);
	}

	public void addBankAccount(Agency agency, BankAccount bankAccount) {
		if (agency.getBankAccountList() == null) {
			agency.setBankAccountList(new ArrayList<>());
		}
		agency.getBankAccountList().add(bankAccount);
	}

	public void addInsuranceCompany(Agency agency, InsuranceCompany insuranceCompany) {
		if (agency.getInsuranceCompanyList() == null) {
			agency.setInsuranceCompanyList(new ArrayList<>());
		}
		agency.getInsuranceCompanyList().add(insuranceCompany);
	}

	public void addCustomer(Agency agency, Customer customer) {
		if (agency.getCustomerList() == null) {
			agency.setCustomerList(new ArrayList<>());
		}
		agency.getCustomerList().add(customer);
	}

	public void addPaymentMovement(Agency agency, PaymentMovement paymentMovement) {
		if (agency.getPaymentMovementList() == null) {
			agency.setPaymentMovementList(new ArrayList<>());
		}
		agency.getPaymentMovementList().add(paymentMovement);
	}
}
