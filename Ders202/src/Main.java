import model.*;
import service.*;

import java.math.BigDecimal;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		DanceCourseService danceCourseService = new DanceCourseService();
		BankAccountService bankAccountService = new BankAccountService();
		BranchService branchService = new BranchService();
		InstructorService instructorService = new InstructorService();
		LectureService lectureService = new LectureService();
		LectureScheduleTimeService lectureScheduleTimeService = new LectureScheduleTimeService();

		InitialDataService initialDataService = new InitialDataService();

		List<Branch> branchList = initialDataService.loadInitialDataForBranch();
		BankAccount bank1 = bankAccountService.createBankAccount("Ziraat Bankası", "TR1234567890", "Özçakır Dance School", new BigDecimal(15000));
		BankAccount bank2 = bankAccountService.createBankAccount("Ziraat Bankası", "TR1234567890", "Özçakır Dance School", new BigDecimal(35000));

		DanceCourse danceCourse = danceCourseService.createDanceCourse("Özçakır Dance School", "Eskişehir",
				"Tuğçe Özçakır", "TR34567890", "Eskişehir Vergi Dairesi");
		danceCourseService.addBankAccount(danceCourse, bank1);
		danceCourseService.addBankAccount(danceCourse, bank2);
		branchService.createBranchToBranchPool(branchList, "Bachata"); // Aynı cranş varmı onun kontrolü için yeniden ekledik.

		Instructor instructor = instructorService.createInstructor("Ahmet Demir", 28,
				Sex.MALE, new BigDecimal(12000));
		danceCourseService.addInstructor(danceCourse, instructor);

		Lecture lecture = lectureService.createLecture("Bacata", branchList.get(0), 10);
		LectureScheduleTime lectureScheduleTime = lectureScheduleTimeService.createLectureScheduleTime(Day.MONDAY, "20:00 - 21:00");
		Set<LectureScheduleTime> lectureScheduleTimeSet = new HashSet<>();
		lectureScheduleTimeSet.add(lectureScheduleTime);
		lectureService.addLectureScheduleTime(lecture, lectureScheduleTimeSet);
		danceCourseService.addLecture(danceCourse, lecture);
		System.out.println(danceCourse);

/*		Öğrenci ekleme kısmı ve tekrarlanan ders tarhileri ödev olarak yapılacak. Dersler ve ders programı eklenecek. öğrenciler buralara eklenecek. muhasebesi yapılacak.
		Dans kursunun Toplam kapasitesi olacak ve derslerin kapasitesi toplam kapasiteyi geçmeyecek.
		Dans kursu özelinde toplam banka hesaplarında bulunan para miktarı hesaplanacak.
		dans hocasının yaşı 53'tan büyük olamaz.
		öğrencinin yaşı 18 den küçük olamaz
		Öğrencilerin (erkek - kadın) > 2 == False
		Lecturelar için grup yada bireysel kurs özelliği eklenecek.
		Grup dersler için öğrenci sayıları eşit olması gerekiyor.
		*/
	}
}
