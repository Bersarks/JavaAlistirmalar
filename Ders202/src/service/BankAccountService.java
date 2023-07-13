package service;

import model.BankAccount;

import java.math.BigDecimal;
import java.util.List;

public class BankAccountService {
	public BankAccount createBankAccount(String bankName, String ibanNo, String companyName, BigDecimal balance) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBankName(bankName);
		bankAccount.setIbanNo(ibanNo);
		bankAccount.setCompanyName(companyName);
		bankAccount.setBalance(balance);
		return bankAccount;
	}

	public BankAccount getBankAccountWithEnoughMoney(List<BankAccount> bankAccountList, BigDecimal amount) {
		for (BankAccount bankAccount : bankAccountList) {
			if (bankAccount.getBalance().compareTo(amount) >= 0) {
				return bankAccount;
			}
		}
		return null;
	}
}
