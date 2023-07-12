package service;

import model.BankAccount;

public class BankAccountService {
	public BankAccount createBankAccount(String bankName, String ibanNo, String companyName) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBankName(bankName);
		bankAccount.setIbanNo(ibanNo);
		bankAccount.setCompanyName(companyName);
		return bankAccount;
	}
}
