package hw3.main;

import java.util.List;

public class Transcript {
	private int studentId;
	List<CourseGrade> courseList;
	private double gpa;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public List<CourseGrade> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseGrade> courseList) {
		this.courseList = courseList;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	private void calculateGpa() {
		double total = 0;
		int totalCredits = 0;
		for (CourseGrade course : courseList) {
			total += course.getGradeTaken().letterGrade * course.getCourseCredit();
			totalCredits += course.getCourseCredit();
		}
		gpa = total / totalCredits;
	}

	@Override
	public String toString() {
		String toString = "Student ID: " + studentId + "\n";
		for (CourseGrade course : courseList) {
			toString += course.toString();
		}
		calculateGpa();
		toString += "GPA: " + gpa;
		return toString;
	}
}
