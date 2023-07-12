package service;

import model.Branch;
import model.Instructor;
import model.Sex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InstructorService {
	public Instructor createInstructor(String name, List<Branch> branchList, int age, Sex sex, BigDecimal salary) {
		Instructor instructor = new Instructor();
		instructor.setName(name);
		instructor.setAge(age);
		instructor.setSex(sex);
		instructor.setSalary(salary);
		addBranches(instructor, branchList);
		return instructor;
	}


	public void addBranches(Instructor instructor, List<Branch> branchList) {
		if (instructor.getBranches() == null) {
			instructor.setBranches(new ArrayList<>());
		}
		for (Branch branch : branchList) {
			instructor.getBranches().add(branch);
		}
	}
}
