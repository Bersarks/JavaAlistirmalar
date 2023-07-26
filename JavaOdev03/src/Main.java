import hw3.main.CourseGrade;
import hw3.main.Transcript;
import hw3.util.Grade;

import java.util.ArrayList;
import java.util.List;

public class Main {

	// main method
	public static void main(String args[]) {
		Transcript transcript = new Transcript(1112234);
		CourseGrade courseGrade1 = new CourseGrade("COMP", 201, 4, Grade.A);
		CourseGrade courseGrade2 = new CourseGrade("MATH", 101);
		CourseGrade courseGrade3 = new CourseGrade("ECE");
		CourseGrade courseGrade4 = new CourseGrade("COMP", 201, 4,3.7);

		List<CourseGrade> courseList = new ArrayList<>();
		courseList.add(courseGrade1);
		courseList.add(courseGrade2);
		courseList.add(courseGrade3);
		transcript.setCourseList(courseList);
		transcript.addCourseToList(courseGrade4);
		System.out.println(transcript.toString());
	}
}
