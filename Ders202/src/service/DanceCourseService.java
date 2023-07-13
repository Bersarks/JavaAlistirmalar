package service;

import model.*;

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

	public void addPaymentMovement(DanceCourse danceCourse, PaymentMovement paymentMovement) {
		if (danceCourse.getPaymentMovementList() == null) {
			danceCourse.setPaymentMovementList(new ArrayList<>());
		}
		danceCourse.getPaymentMovementList().add(paymentMovement);
		//list.of(paymentMovement); şeklinde atama yapıldığında direkt olarak yeni bir liste oluşlturarak atama yapıyor.
	}

	public void addInstructor(DanceCourse danceCourse, Instructor instructor) {
		BankAccountService bankAccountService = new BankAccountService();
		PaymentMovementService paymentMovementService = new PaymentMovementService();

		if (danceCourse.getBankAccountList() != null) {
			BankAccount bankAccount = bankAccountService.getBankAccountWithEnoughMoney
					(danceCourse.getBankAccountList(), instructor.getSalary());
			if (bankAccount != null) {
				PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement(bankAccount,
						"Eğitmen: " + instructor.getName() + " Maaş Ödemesi", MovementType.OUTCOME, instructor.getSalary());
				bankAccount.setBalance(bankAccount.getBalance().subtract(instructor.getSalary()));
				addPaymentMovement(danceCourse, paymentMovement);
				if (danceCourse.getInstructorList() == null) {
					danceCourse.setInstructorList(new ArrayList<>());
					danceCourse.getInstructorList().add(instructor);
				} else {
					danceCourse.getInstructorList().add(instructor);
				}
			} else {
				System.err.println("Yeterli bakiyesi olan hesap yok.");
			}
		} else {
			System.out.println("Önce banka hesabı ekleyin.");
		}
	}

	public void addStudent(DanceCourse danceCourse, List<model.Student> studentList) {
		if (danceCourse.getStudentList() == null) {
			danceCourse.setStudentList(new ArrayList<>());
		}
		danceCourse.getStudentList().addAll(studentList);
	}

	public void addLecture(DanceCourse danceCourse, Lecture lecture) {
		if (danceCourse.getLectureList() == null) {
			danceCourse.setLectureList(new ArrayList<>());
			danceCourse.getLectureList().add(lecture);
		} else{
		danceCourse.getLectureList().add(lecture);
		}
	}
	/* danceCourse.setLectureList(list.of(lecture))*/
	public void totalBalance(DanceCourse danceCourse){

	}
}
