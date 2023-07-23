import hw3.main.CourseGrade;
import hw3.main.Transcript;
import hw3.util.Grade;

import java.util.List;

public class Main {

	// main method
	public static void main(String args[]) {
		Transcript transcript = new Transcript();
		transcript.setStudentId(1112234);
		CourseGrade courseGrade1 = new CourseGrade("COMP", 201, 4, Grade.A);
		CourseGrade courseGrade2 = new CourseGrade("MATH", 101);
		CourseGrade courseGrade3 = new CourseGrade("ECE");
		CourseGrade courseGrade4 = new CourseGrade("COMP", 201, 4);

		List<CourseGrade> courseList = List.of(courseGrade1, courseGrade2, courseGrade3, courseGrade4);
		transcript.setCourseList(courseList);
		System.out.println(transcript.toString());
	}
}
