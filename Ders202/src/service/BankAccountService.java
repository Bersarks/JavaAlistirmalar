package service;

import model.BankAccount;

import java.math.BigDecimal;

public class BankAccountService {
	public BankAccount createBankAccount(String bankName, String ibanNo, String companyName, BigDecimal balance) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBankName(bankName);
		bankAccount.setIbanNo(ibanNo);
		bankAccount.setCompanyName(companyName);
		bankAccount.setBalance(balance);
		return bankAccount;
	}
}
