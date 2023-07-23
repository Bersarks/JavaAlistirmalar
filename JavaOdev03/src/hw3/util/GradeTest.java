package hw3.util;

public class GradeTest {
	public static void main(String[] args) {
		for (Grade g : Grade.values()) {
			System.out.println("Grade " + g + " corresponds to numeric grade " + g.letterGrade + ".");
		}
	}
}
