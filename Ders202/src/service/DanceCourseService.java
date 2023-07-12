package service;

import model.BankAccount;
import model.DanceCourse;
import model.PaymentMovement;

import java.util.ArrayList;
import java.util.List;

public class DanceCourseService {
	public DanceCourse createDanceCourse(String name, String address, String founder, String taxNumber, String taxOffice) {
		DanceCourse danceCourse = new DanceCourse();
		danceCourse.setName(name);
		danceCourse.setAddress(address);
		danceCourse.setFounder(founder);
		danceCourse.setTaxNumber(taxNumber);
		danceCourse.setTaxOffice(taxOffice);
		return danceCourse;
	}

	public void addBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {
		if (danceCourse.getBankAccountList() == null) {
			danceCourse.setBankAccountList(new ArrayList<>());
			danceCourse.getBankAccountList().add(bankAccount);
		}// objelerde her zaman equals metodu ile karşılaştırma yapılır. "==" ile referans karşılaştırması yapıldığı için sıkıntı çıkabilir.
		else {
			for (BankAccount bankAccount2 : danceCourse.getBankAccountList()) {
				if (bankAccount2.getIbanNo().equals(bankAccount.getIbanNo())) {
					bankAccount2.setBalance(bankAccount2.getBalance().add(bankAccount.getBalance()));
				} else {
					danceCourse.getBankAccountList().add(bankAccount);
				}
			}
		}
	}

	public void addBankAccount(DanceCourse danceCourse, List<BankAccount> bankAccountList) {
		if (danceCourse.getBankAccountList() == null) {
			danceCourse.setBankAccountList(new ArrayList<>());
			danceCourse.setBankAccountList(bankAccountList);
		} else {// objelerde her zaman equals metodu ile karşılaştırma yapılır. "==" ile referans karşılaştırması yapıldığı için sıkıntı çıkabilir.
			for (BankAccount bankAccount : bankAccountList) {
				for (BankAccount bankAccount2 : danceCourse.getBankAccountList()) {
					if (bankAccount2.getIbanNo().equals(bankAccount.getIbanNo())) {
						bankAccount2.getBalance().add(bankAccount.getBalance());
					} else {
						danceCourse.getBankAccountList().add(bankAccount);
					}
				}
			}
		}
	}

	public void addPaymentMovement(DanceCourse danceCourse, List<PaymentMovement> paymentMovementList) {
		if (danceCourse.getPaymentMovementList() == null) {
			danceCourse.setPaymentMovementList(new ArrayList<>());
		}
		danceCourse.getPaymentMovementList().addAll(paymentMovementList);
	}

	public void addInstructor(DanceCourse danceCourse, List<model.Instructor> instructorList) {
		if (danceCourse.getInstructorList() == null) {
			danceCourse.setInstructorList(new ArrayList<>());
		}
		danceCourse.getInstructorList().addAll(instructorList);
	}

	public void addStudent(DanceCourse danceCourse, List<model.Student> studentList) {
		if (danceCourse.getStudentList() == null) {
			danceCourse.setStudentList(new ArrayList<>());
		}
		danceCourse.getStudentList().addAll(studentList);
	}
}
