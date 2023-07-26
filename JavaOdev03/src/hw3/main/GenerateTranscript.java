package hw3.main;

import java.io.File;
import java.util.Scanner;

public class GenerateTranscript {
	public void takeInputFromUsers(){
		boolean isContinue = true;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Student ID: ");
		int studentId = scn.nextInt();
		scn.nextLine();
		Transcript transcript = new Transcript(studentId);
		while (isContinue){
			System.out.println("Enter Department: ");
			String department = scn.nextLine();
			System.out.println("Enter Course Code: ");
			int courseCode = scn.nextInt();
			System.out.println("Enter Course Credit: ");
			int courseCredit = scn.nextInt();
			System.out.println("Enter Course Grade: ");
			int courseGrade = scn.nextInt();
			transcript.addCourseToList(new CourseGrade(department, courseCredit, courseCode, courseGrade));
			System.out.println("Do you want to continue? (y/n)");
			String choice = scn.next();
			if (choice.equals("n")){
				isContinue = false;
			}
		}
		System.out.println(transcript.toString());
	}
	public void takeInputFromFile(){
		try {
			int studentId = 0;
			Transcript transcript = new Transcript(0);
			String line = "";
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter filename: ");
			String fileName = scn.nextLine();
			File file = new File(fileName);
			Scanner dataReader = new Scanner(file);
			while(dataReader.hasNextLine()) {
				if (studentId == 0){
					line = dataReader.nextLine();
					studentId = Integer.parseInt(line);
					System.out.println(studentId);
					transcript.setStudentId(studentId);
				}
				line = dataReader.nextLine();
				String[] courseArray = line.split(" ");
				String department = courseArray[0];
				int courseCode = Integer.parseInt(courseArray[1]);
				int courseCredit = Integer.parseInt(courseArray[2]);
				double courseGrade = Double.parseDouble(courseArray[3]);
				transcript.addCourseToList(new CourseGrade(department, courseCredit, courseCode, courseGrade));
			}
			System.out.println(transcript.toString());
		} catch (Exception e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
