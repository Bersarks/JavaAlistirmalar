package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

/**
* @param: Bu method içerisinde ilk olarak banka hesabı eklenip eklenilmediği kontrol ediliyor.
* Eğer varsa; Payment movement tipine göre işlemlere geçiliyor. Gelen para payment movement listesinin varlığı kontrol edildikten sonra
* Şirket içerisindeki banka hesaplarından isimi uyuşan banka var mı ona bakıyor. Ör: "Yapı Kredi" == "Yapı Kredi".
* Eğer aynı isimde bankadan açılmışl banka hesabı yoksa BankAccountList içerisindeki ilk eleman olan hesaba parayı ekliyor.
*
* @param: Eğer paymentMovement tipi outcome olarak geldiyse daha önceden bakiyesi yeterli olan hesaplandığı için
 * InsuranceCompany içerisindeki BankAccountList içinde dolaşarak paymentMovement içerisinden gelen banka hesabını bulup para gönderme işlemini tamamlıyor.*/
	public void addPaymentMovement(InsuranceCompany insuranceCompany, PaymentMovement paymentMovement) {
		if (insuranceCompany.getBankAccountList() == null) {
			System.err.println(insuranceCompany.getName() + " has no bank account. Please add a bank account to move on.");
		} else {
			if (paymentMovement.getMovementType().equals(MovementType.INCOME)) {
				if (insuranceCompany.getPaymentMovementList() == null) {
					insuranceCompany.setPaymentMovementList(new ArrayList<>());
				}
				for (BankAccount bankAccount : insuranceCompany.getBankAccountList()) {
					if (bankAccount.getName().equals(paymentMovement.getBankAccount().getName())) {
						bankAccount.setAmount(bankAccount.getAmount().add(paymentMovement.getAmount()));
						insuranceCompany.getPaymentMovementList().add(paymentMovement);
						System.out.println("Successfully added payment movement to " + insuranceCompany.getName());
						System.out.println(paymentMovement.toString());
						return;
					}
				}
				insuranceCompany.getBankAccountList().get(0).setAmount
						(insuranceCompany.getBankAccountList().get(0).getAmount().add(paymentMovement.getAmount()));
				insuranceCompany.getPaymentMovementList().add(paymentMovement);
				System.out.println("Successfully added payment movement to " + insuranceCompany.getName());
				System.out.println(paymentMovement.toString());
				return;
			} else {
				for (BankAccount bankAccount : insuranceCompany.getBankAccountList()) {
					if (bankAccount.equals(paymentMovement.getBankAccount())) {
						if (insuranceCompany.getPaymentMovementList() == null) {
							insuranceCompany.setPaymentMovementList(new ArrayList<>());
						}
						bankAccount.setAmount(bankAccount.getAmount().subtract(paymentMovement.getAmount()));
						insuranceCompany.getPaymentMovementList().add(paymentMovement);
						System.out.println("Successfully added payment movement to " + insuranceCompany.getName());
						System.out.println(paymentMovement.toString());
						return;
					}
				}
			}
		}
		System.err.println("Insurance company has no enough balance to pay.");
	}

	public BankAccount checkBalanceForPayment(InsuranceCompany insuranceCompany, BigDecimal amount) {
		for (BankAccount bankAccount : insuranceCompany.getBankAccountList()) {
			if (bankAccount.getAmount().compareTo(amount) >= 0) {
				return bankAccount;
			}
		}
		return null;
	}

	public void sendCommissionToAgency(Agency agency, InsuranceCompany insuranceCompany) {
		PaymentMovementService paymentMovementService = new PaymentMovementService();
		AgencyService agencyService = new AgencyService();
		ProposalService proposalService = new ProposalService();
		for (Customer customer : agency.getCustomerList()) {
			for (InsuranceRequest insuranceRequest : customer.getInsuranceRequestList()) {
				for (Proposal proposal : insuranceRequest.getProposalList()) {
					if (proposal.getCompany().equals(insuranceCompany)){
						if (proposal.isApproved()) {
							BankAccount bankAccount = checkBalanceForPayment(insuranceCompany, proposalService.calculateDiscountedPrice(proposal));
							PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement
									(bankAccount, "Commission to " + agency.getName(), MovementType.OUTCOME,
											proposalService.calculateDiscountedPrice(proposal).multiply(insuranceCompany.getCommission()));
							addPaymentMovement(insuranceCompany, paymentMovement);
							PaymentMovement agencyPaymentMovement = paymentMovementService.createPaymentMovement(bankAccount, "Commission from " + insuranceCompany.getName(),
									MovementType.INCOME, proposalService.calculateDiscountedPrice(proposal).multiply(insuranceCompany.getCommission()));
							agencyService.addPaymentMovement(agency, agencyPaymentMovement);
						}
					}
				}
			}
		}
	}
}
/*Payment movement içerisine bakiye yeterlilik kontrolü eklenip,
 *para giriş çıkışları banlka hesaplarına buradan yaptırılacak.*/