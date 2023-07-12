import model.BankAccount;
import model.Branch;
import model.DanceCourse;
import service.BankAccountService;
import service.BranchService;
import service.DanceCourseService;
import service.InitialDataService;

import java.math.BigDecimal;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		DanceCourseService danceCourseService = new DanceCourseService();
		BankAccountService bankAccountService = new BankAccountService();
		BranchService branchService = new BranchService();
		InitialDataService initialDataService = new InitialDataService();

		List<Branch> branchList = initialDataService.loadInitialDataForBranch();
		BankAccount bank1 = bankAccountService.createBankAccount("Ziraat Bankası", "TR1234567890", "Özçakır Dance School", new BigDecimal(1000));
		BankAccount bank2 = bankAccountService.createBankAccount("Ziraat Bankası", "TR1234567890", "Özçakır Dance School", new BigDecimal(3000));

		DanceCourse danceCourse = danceCourseService.createDanceCourse("Özçakır Dance School", "Eskişehir",
				"Tuğçe Özçakır", "TR34567890", "Eskişehir Vergi Dairesi");
		danceCourseService.addBankAccount(danceCourse, bank1);
		danceCourseService.addBankAccount(danceCourse, bank2);
		System.out.println(danceCourse);
		branchService.createBranchToBranchPool(branchList, "Bachata");
		System.out.println(branchList);
	}
}
