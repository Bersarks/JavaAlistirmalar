package service;

import model.*;

import java.math.BigDecimal;
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
		if (agency.getBankAccountList() == null) {
			System.err.println(agency.getName() + " has not bank account. Please add a bank account to move on.");
		} else {
			if (paymentMovement.getMovementType().equals(MovementType.INCOME)) {
				if (agency.getPaymentMovementList() == null) {
					agency.setPaymentMovementList(new ArrayList<>());
				}
				for (BankAccount bankAccount : agency.getBankAccountList()) {
					if (bankAccount.getName().equals(paymentMovement.getBankAccount().getName())) {
						bankAccount.setAmount(bankAccount.getAmount().add(paymentMovement.getAmount()));
						agency.getPaymentMovementList().add(paymentMovement);
						System.out.println("Successfully added payment movement to " + agency.getName() + ".");
						System.out.println(paymentMovement.toString());
						return;
					}
				}
				agency.getBankAccountList().get(0).setAmount
						(agency.getBankAccountList().get(0).getAmount().add(paymentMovement.getAmount()));
				agency.getPaymentMovementList().add(paymentMovement);
				System.out.println("Successfully added payment movement to " + agency.getName() + ".");
				System.out.println(paymentMovement.toString());
				return;
			} else {
				for (BankAccount bankAccount : agency.getBankAccountList()) {
					if (bankAccount.equals(paymentMovement.getBankAccount())) {
						if (agency.getPaymentMovementList() == null) {
							agency.setPaymentMovementList(new ArrayList<>());
						}
						bankAccount.setAmount(bankAccount.getAmount().subtract(paymentMovement.getAmount()));
						agency.getPaymentMovementList().add(paymentMovement);
						System.out.println("Successfully added payment movement to " + agency.getName() + ".");
						System.out.println(paymentMovement.toString());
						return;
					}
				}
			}
		}
		System.err.println(agency.getName() + " has not enough balance to pay.");
	}

	public BankAccount checkBalanceForPayment(Agency agency, BigDecimal amount) {
		for (BankAccount bankAccount : agency.getBankAccountList()) {
			if (bankAccount.getAmount().compareTo(amount) >= 0) {
				return bankAccount;
			}
		}
		return null;
	}
	public void sendMoneyToInsuranceCompany(Agency agency, InsuranceCompany insuranceCompany, BigDecimal amount) {
		PaymentMovementService paymentMovementService = new PaymentMovementService();
		InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
		for (InsuranceCompany agencyInsuranceCompany : agency.getInsuranceCompanyList()){
			if (agencyInsuranceCompany.equals(insuranceCompany)){
				PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement(checkBalanceForPayment(agency, amount),
						"Payment to Insurance Company", MovementType.OUTCOME, amount);
				addPaymentMovement(agency, paymentMovement);
				PaymentMovement paymentMovement1 = paymentMovementService.createPaymentMovement(checkBalanceForPayment(agency, amount),
						"Payment from Agency", MovementType.INCOME, amount);
				insuranceCompanyService.addPaymentMovement(insuranceCompany, paymentMovement1);
				System.out.println("Successfully sent money to insurance company.");
				return;
			}
		}
	}
}
