package model;

import java.math.BigDecimal;

public class Engineer extends Employee {
	public Engineer(String id, String name, String surname, int age, ShiftEnum shift, Department department, BigDecimal salary) {
		super(id, name, surname, age, shift, department, salary);
	}
}
