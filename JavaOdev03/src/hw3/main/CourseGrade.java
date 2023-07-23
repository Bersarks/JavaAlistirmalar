package hw3.main;

import hw3.util.Grade;

public class CourseGrade {
	private String courseDepartment;
	private int courseCode;
	private int courseCredit;
	private Grade gradeTaken;

	public CourseGrade(String courseDepartment) {
		this(courseDepartment, 100, 4, Grade.F);
	}

	public CourseGrade(String courseDepartment, int courseCode) {
		this(courseDepartment, courseCode, 4, Grade.F);
	}

	public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
		this(courseDepartment, courseCode, courseCredit, Grade.F);
	}

	public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade courseGrade) {
		this.setCourseDepartment(courseDepartment);
		this.setCourseCode(courseCode);
		this.setCourseCredit(courseCredit);
		this.setGradeTaken(courseGrade);
	}

	public String getCourseDepartment() {
		return courseDepartment;
	}

	/*		courseDepartment is a four letter acronym indicating the department, the class is offered.
	 *		The possible values of departments in your application are CENG, COMP, ECE, ME and MATH*/
	public void setCourseDepartment(String courseDepartment) {
		if (courseDepartment.equals("CENG") || courseDepartment.equals("COMP") ||
				courseDepartment.equals("ECE") || courseDepartment.equals("ME") || courseDepartment.equals("MATH")) {
			this.courseDepartment = courseDepartment;
		} else {
			this.courseDepartment = "CENG";
		}
	}

	public int getCourseCode() {
		return courseCode;
	}

	/*	courseCode is a three digit code (e.g., 101, 200, or 590) for the course. This number should
	 *	be between 100 and 599.
	 */
	public void setCourseCode(int courseCode) {
		if (courseCode >= 100 && courseCode <= 599) {
			this.courseCode = courseCode;
		} else {
			this.courseCode = 100;
		}
	}

	public int getCourseCredit() {
		return courseCredit;
	}

	/* courseCredit is an integer that indicates how many credits the course is worth. The only
	 *valid values are 3 and 4. */
	public void setCourseCredit(int courseCredit) {
		if (courseCredit == 3 || courseCredit == 4){
			this.courseCredit = courseCredit;
		} else {
			this.courseCredit = 4;
		}
	}

	public Grade getGradeTaken() {
		return gradeTaken;
	}

	public void setGradeTaken(Grade gradeTaken) {
		this.gradeTaken = gradeTaken;
	}
	public void setGradeTaken(double val) {
		if (val >= 0.0 && val <= 4.0){
			if (val >= 0.0 && val < 0.5)
				this.gradeTaken = Grade.F;
			else if (val >= 0.5 && val < 1.5)
				this.gradeTaken = Grade.D;
			else if (val >= 1.5 && val < 2.5)
				this.gradeTaken = Grade.C;
			else if (val >= 2.5 && val < 3.5)
				this.gradeTaken = Grade.B;
			else if (val >= 3.5 && val <= 4.0)
				this.gradeTaken = Grade.A;
		} else {
			this.gradeTaken = Grade.F;
		}
	}

	@Override
	public String toString() {
		return "Department: " + courseDepartment +
				" CourseCode: " + courseCode +
				" Credit: " + courseCredit +
				" Grade: " + gradeTaken + "\n";
	}
}
