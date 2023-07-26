package model;

import java.math.BigDecimal;

public class Seller extends Employee{
	public Seller(String id, String name, String surname, int age, ShiftEnum shift, Department department, BigDecimal salary) {
		super(id, name, surname, age, shift, department, salary);
	}

}
