package model;

import java.math.BigDecimal;

public class Cleaner extends Employee {
	public Cleaner(String id, String name, String surname, int age, ShiftEnum shift, Department department, BigDecimal salary) {
		super(id, name, surname, age, shift, department, salary);
	}
}
