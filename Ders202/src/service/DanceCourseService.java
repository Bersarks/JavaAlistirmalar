package service;

import model.BankAccount;
import model.DanceCourse;

import java.util.ArrayList;
import java.util.List;

public class DanceCourseService {
	public DanceCourse createDanceCourse (String name, String address, String founder, String taxNumber, String taxOffice, List<BankAccount> bankAccountList) {
		DanceCourse danceCourse = new DanceCourse();
		danceCourse.setName(name);
		danceCourse.setAddress(address);
		danceCourse.setFounder(founder);
		danceCourse.setTaxNumber(taxNumber);
		danceCourse.setTaxOffice(taxOffice);
		addBankAccount(danceCourse, bankAccountList);
		return danceCourse;
	}
	public void addBankAccount(DanceCourse danceCourse, List<BankAccount> bankAccountList) {
		if (danceCourse.getBankAccountList() == null) {
			danceCourse.setBankAccountList(new ArrayList<>());
		}
		danceCourse.getBankAccountList().addAll(bankAccountList);
	}
}
