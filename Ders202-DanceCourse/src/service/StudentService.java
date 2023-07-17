package service;

import model.Sex;
import model.Student;

import java.math.BigDecimal;
import java.util.Date;

public class StudentService {
	public Student createStudent(String name, int age, Sex sex, boolean isPaid, BigDecimal contractAmount, Date startDate,
								 Date endDate){
		if (age < 18){
			System.err.println("Student age cannot be less than 18");
			//throw new IllegalArgumentException("Student age cannot be less than 18");
			return null;
		}
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setSex(sex);
		student.setPaid(isPaid);
		student.setContractAmount(contractAmount);
		student.setStartDate(startDate);
		student.setEndDate(endDate);
		return student;
	}
}
