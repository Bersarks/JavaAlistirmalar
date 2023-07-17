package service;

import model.Branch;
import model.Instructor;
import model.Sex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InstructorService {
	public Instructor createInstructor(String name, int age, Sex sex, BigDecimal salary) {
		if (age > 53)
		{
			System.err.println("Instructor age cannot be greater than 53");
			return null;
		}
		Instructor instructor = new Instructor();
		instructor.setName(name);
		instructor.setAge(age);
		instructor.setSex(sex);
		instructor.setSalary(salary);
		return instructor;
	}


	public void addBranch(Instructor instructor, Branch branch) {
		if (instructor.getBranches() == null) {
			instructor.setBranches(new ArrayList<>());
		}
			instructor.getBranches().add(branch);
	}
}
