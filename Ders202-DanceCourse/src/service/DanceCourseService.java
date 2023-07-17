package service;

import model.*;

import java.math.BigDecimal;
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

	public void setTotalCapacity(DanceCourse danceCourse, int totalCapacity) {
		danceCourse.setTotalCapacity(totalCapacity);
	}

	public boolean checkStudentsSex(DanceCourse danceCourse) {
		int count = 0;
		int count2 = 0;
		for (Student student : danceCourse.getStudentList()) {
			if (student.getSex().equals(Sex.FEMALE))
				count++;
			else
				count2++;
		}
		return !((count > count2 + 2) || (count2 > count + 2));
	}

	public void addBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {
		if (danceCourse.getBankAccountList() == null) {
			danceCourse.setBankAccountList(new ArrayList<>());
			danceCourse.getBankAccountList().add(bankAccount);
			totalBalance(danceCourse);
		}// objelerde her zaman equals metodu ile karşılaştırma yapılır. "==" ile referans karşılaştırması yapıldığı için sıkıntı çıkabilir.
		else {
			for (BankAccount bankAccount2 : danceCourse.getBankAccountList()) {
				if (bankAccount2.getIbanNo().equals(bankAccount.getIbanNo())) {
					bankAccount2.setBalance(bankAccount2.getBalance().add(bankAccount.getBalance()));
					totalBalance(danceCourse);
				} else {
					danceCourse.getBankAccountList().add(bankAccount);
					totalBalance(danceCourse);
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

	public void addStudent(DanceCourse danceCourse, Student student) {
		PaymentMovementService paymentMovementService = new PaymentMovementService();

		if (danceCourse.getStudentList() == null) {
			danceCourse.setStudentList(new ArrayList<>());
		}
		if (checkStudentsSex(danceCourse)) {
			PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement(danceCourse.getBankAccountList().get(0), student.getName() + " Kayıt ücreti ödemesi.",
					MovementType.INCOME, student.getContractAmount());
			addPaymentMovement(danceCourse, paymentMovement);
			student.setPaid(true);
			danceCourse.getStudentList().add(student);
		} else
			System.out.println("Kursa kayıtlı öğrencilerin cinsiyetleri dengesiz.");
	}

	public void addLecture(DanceCourse danceCourse, Lecture lecture) {
		if (danceCourse.getLectureList() == null) {
			danceCourse.setLectureList(new ArrayList<>());
			if (danceCourse.getTotalCapacity() - lecture.getCapacity() >= 0) {
				danceCourse.getLectureList().add(lecture);
				danceCourse.setTotalCapacity(danceCourse.getTotalCapacity() - lecture.getCapacity());
			} else
				System.out.println("Kapasite yetersiz.");
		} else {
			if (danceCourse.getTotalCapacity() - lecture.getCapacity() >= 0) {
				danceCourse.getLectureList().add(lecture);
				danceCourse.setTotalCapacity(danceCourse.getTotalCapacity() - lecture.getCapacity());
			} else
				System.out.println("Kapasite yetersiz.");
		}
	}

	/* danceCourse.setLectureList(list.of(lecture))*/
	public void totalBalance(DanceCourse danceCourse) {
		BigDecimal totalBalance = BigDecimal.ZERO;
		for (BankAccount bankAccount : danceCourse.getBankAccountList()) {
			totalBalance = totalBalance.add(bankAccount.getBalance());
		}
		System.out.println("Toplam Bakiye: " + totalBalance);
	}
}
