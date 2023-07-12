package service;

import model.*;

import java.util.List;

public class LectureService {
	public Lecture createLecture(String name, Instructor instructor, Branch branch, int capacity,
								 List<LectureScheduleTime> lectureScheduleTimeList, List<Student> studentList) {
		Lecture lecture = new Lecture();
		lecture.setName(name);
		lecture.setInstructor(instructor);
		lecture.setBranch(branch);
		lecture.setCapacity(capacity);
		lecture.setLectureScheduleTimeList(lectureScheduleTimeList);
		lecture.setStudentList(studentList);
		return lecture;
	}
}
