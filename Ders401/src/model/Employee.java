package model;

import java.math.BigDecimal;

public class Employee {
	private String id;
	private String name;
	private String surname;
	private int age;
	private ShiftEnum shift;
	private Department department;
	private BigDecimal salary;

	public Employee(String id, String name, String surname, int age, ShiftEnum shift, Department department, BigDecimal salary) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.shift = shift;
		this.department = department;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ShiftEnum getShift() {
		return shift;
	}

	public void setShift(ShiftEnum shift) {
		this.shift = shift;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public void raiseSalary(){
		this.salary = new BigDecimal(this.salary.doubleValue() * 1.1);
	}
	public void raiseSalary(int percentage){
		this.setSalary(this.getSalary().add(this.getSalary().multiply(new BigDecimal(percentage))
				.divide(new BigDecimal(100))));
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", age=" + age +
				", shift=" + shift +
				", department=" + department +
				", salary=" + salary +
				'}';
	}
}
