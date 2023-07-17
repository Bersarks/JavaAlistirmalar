package service;

import model.*;

import java.util.ArrayList;

public class CustomerService {
	//	Creates a new customer with the given parameters.
	public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum) {
		return new Customer(name, customerTypeEnum);
	}

	// Adds a bank account to the customer.
	public void addBankAccount(Customer customer, BankAccount bankAccount) {
		if (customer.getBankAccountList() == null) {
			customer.setBankAccountList(new ArrayList<>());
		}
		customer.getBankAccountList().add(bankAccount);
	}

	// Adds an insurance request to the customer.
	public void addInsuranceRequest(Customer customer, InsuranceRequest insuranceRequest) {
		if (customer.getInsuranceRequestList() == null) {
			customer.setInsuranceRequestList(new ArrayList<>());
		}
		customer.getInsuranceRequestList().add(insuranceRequest);
	}

	// Adds a policy to the customer.
	public void addPolicy(Customer customer, Policy policy) {
		if (customer.getPolicyList() == null) {
			customer.setPolicyList(new ArrayList<>());
		}
		customer.getPolicyList().add(policy);
	}

	// Adds a payment movement to the customer.
	public void addPaymentMovement(Customer customer, PaymentMovement paymentMovement) {
		if (customer.getPaymentMovementList() == null) {
			customer.setPaymentMovementList(new ArrayList<>());
		}
		customer.getPaymentMovementList().add(paymentMovement);
	}

	// Adds a vehicle to the customer.
	public void addVehicle(Customer customer, Vehicle vehicle) {
		if (customer.getVehicleList() == null) {
			customer.setVehicleList(new ArrayList<>());
		}
		customer.getVehicleList().add(vehicle);
	}

}
