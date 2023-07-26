import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

	/*Polymorphism
	* alt sınıftan bir nesneyi üst sınıftan üretebilmeye denir.
	*
	* xxx instanceof cccc şeklinde kontrol edilebilir hangi obje olduğu.
	*
	* Bir tane iş yerinde çalışanlar var ben Patronum. Mühendisler var Temizlik görevlileri var, pazarlamacı var
	*
	* Bu Çalışanları bir sisteme kayıt edin ve bana listeleyin.*/


	/*pokemon
	* Kullanıcılar var 2 adet
	* Pkemonlar var
	* pokemonlar savaşacak çiuv çiuv
	*
	* Scannerla 2 kişi oynayacak
	* Başlangıçta tanımlı pokemonlar olacak
	* bu pokemonların güçleri alaca ve ayrıyeten özel güçleri olacak (özel güç 1 defa kullanılır normal güç + x şeklinde)
	* Health ilk biten ölüyor.
	* Hamleler sırayla yapılacak.
	*
	* */
	public static void main(String[] args) {
/*		Animal animal = new Dog(5, true);
		Animal animal2 = new Lion(5, true);

		System.out.println(animal.animalSound());
        System.out.println(animal.toString());
		if (animal instanceof Dog) {
			System.out.println("animal is a dog");
		} else if (animal instanceof Lion) {
			System.out.println("animal is a lion");
		} else {
			System.out.println("animal is an animal");
		}

		List<Employee> employees = new ArrayList<>();
		Department engineering = new Department("1", "Engineering", "Engineering Department",
				"1");
		Department sales = new Department("1", "Sales", "Sales Department", "2");

		Employee employee = new Seller("2", "Süleyman", "Kaya", 25, ShiftEnum.DAY_TIME, sales ,
				new BigDecimal(5000));
		Employee employee1 = new Engineer("1", "Ali", "Işık", 27, ShiftEnum.DAY_TIME, engineering ,
				new BigDecimal(15000));
		Employee employee2 = new Seller("1", "Mehmet", "Aşık", 22, ShiftEnum.DAY_TIME, sales ,
				new BigDecimal(6000));
		Employee employee3 = new Engineer("2", "Ahmet", "Ufuk", 23, ShiftEnum.DAY_TIME, engineering ,
				new BigDecimal(16000));

		employees.add(employee);
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);

		for (Employee emp : employees) {
			if (emp instanceof Engineer){
				emp.raiseSalary(30);
				System.out.println(emp.toString());
			}
			else if (emp instanceof Seller){
				emp.raiseSalary(10);
				System.out.println(emp.toString());
			}
			else {
				System.out.println(emp.toString());
			}
		}*/


	}
}