package service;

import model.*;

import java.math.BigDecimal;
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
		if (customer.getBankAccountList() == null) {
			System.err.println("Insurance company has no bank account. Please add a bank account to move on.");
		} else {
			if (paymentMovement.getMovementType().equals(MovementType.INCOME)) {
				if (customer.getPaymentMovementList() == null) {
					customer.setPaymentMovementList(new ArrayList<>());
				}
				for (BankAccount bankAccount : customer.getBankAccountList()) {
					if (bankAccount.getName().equals(paymentMovement.getBankAccount().getName())) {
						bankAccount.setAmount(bankAccount.getAmount().add(paymentMovement.getAmount()));
						customer.getPaymentMovementList().add(paymentMovement);
						System.out.println("Successfully added payment movement to " + customer.getName() + ".");
						System.out.println(paymentMovement.toString());
						return;
					}
				}
				customer.getBankAccountList().get(0).setAmount
						(customer.getBankAccountList().get(0).getAmount().add(paymentMovement.getAmount()));
				customer.getPaymentMovementList().add(paymentMovement);
				System.out.println("Successfully added payment movement to " + customer.getName() + ".");
				System.out.println(paymentMovement.toString());
				return;
			} else {
				for (BankAccount bankAccount : customer.getBankAccountList()) {
					if (bankAccount.equals(paymentMovement.getBankAccount())) {
						if (customer.getPaymentMovementList() == null) {
							customer.setPaymentMovementList(new ArrayList<>());
						}
						bankAccount.setAmount(bankAccount.getAmount().subtract(paymentMovement.getAmount()));
						customer.getPaymentMovementList().add(paymentMovement);
						System.out.println("Successfully added payment movement to " + customer.getName() + ".");
						System.out.println(paymentMovement.toString());
						return;
					}
				}
			}
		}
		System.err.println(customer.getName() + " has not enough balance to pay.");
	}

	public BankAccount checkBalanceForPayment(Customer customer, BigDecimal amount) {
		for (BankAccount bankAccount : customer.getBankAccountList()) {
			if (bankAccount.getAmount().compareTo(amount) >= 0) {
				return bankAccount;
			}
		}
		return null;
	}

	// Adds a vehicle to the customer.
	public void addVehicle(Customer customer, Vehicle vehicle) {
		if (customer.getVehicleList() == null) {
			customer.setVehicleList(new ArrayList<>());
		}
		customer.getVehicleList().add(vehicle);
	}

	public BigDecimal getDiscountedPrice(Proposal proposal) {
		if (proposal.getDiscountPrice() == null) {
			return proposal.getOfferPrice();
		}
		return proposal.getOfferPrice().subtract(proposal.getDiscountPrice());
	}
// generate policy methodu yaz
	public void acceptProposal(Customer customer, Proposal proposal, Agency agency) {
		PaymentMovementService paymentMovementService = new PaymentMovementService();
		//InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
		InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
		AgencyService agencyService = new AgencyService();
		PolicyService policyService = new PolicyService();
		for (InsuranceRequest insuranceRequest1 : customer.getInsuranceRequestList()) {
			for (Proposal proposal1 : insuranceRequest1.getProposalList()) {
				if (proposal1.equals(proposal)) {
					proposal1.setApproved(true);
					BankAccount customerBankAccount = checkBalanceForPayment(customer, getDiscountedPrice(proposal1));
					if (customerBankAccount == null) {
						System.err.println("Customer has no enough balance to pay.");
						return;
					}else{
					PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement
							(customerBankAccount, agency.getName() + "' a teklif Ödemesi", MovementType.OUTCOME, getDiscountedPrice(proposal1));
					addPaymentMovement(customer, paymentMovement);
					PaymentMovement agencyPaymentMovement = paymentMovementService.createPaymentMovement
							(customerBankAccount, customer.getName() + "' den alınan teklif Ödemesi", MovementType.INCOME, getDiscountedPrice(proposal1));
					agencyService.addPaymentMovement(agency, agencyPaymentMovement);

					agencyService.sendMoneyToInsuranceCompany(agency, proposal1.getCompany(),
							getDiscountedPrice(proposal1));

					Policy policy = policyService.createPolicy(proposal1.getCompany(), proposal1.getVehicle(),
							getDiscountedPrice(proposal1), proposal1.getStartDate(), proposal1.getEndDate());
					addPolicy(customer, policy);
					insuranceRequestService.addPolicy(insuranceRequest1, policy);
					}
				}
			}
		}
	}

}
