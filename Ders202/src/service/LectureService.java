package service;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LectureService {
	public Lecture createLecture(String name, Branch branch, int capacity) {
		Lecture lecture = new Lecture();
		lecture.setName(name);
		lecture.setBranch(branch);
		lecture.setCapacity(capacity);
		return lecture;
	}

	public void addInstructorToLecture(Lecture lecture, Instructor instructor) {
		//eğer bir dersin instructorı varsa onu silmeden yenisi ekletilemeyecek.
		lecture.setInstructor(instructor);
	}

	public void addLectureScheduleTime(Lecture lecture, Set<LectureScheduleTime> lectureScheduleTime) {
		if (lecture.getLectureScheduleTimeList() != null) {
			lecture.getLectureScheduleTimeList().addAll(lectureScheduleTime);
		}
		lecture.setLectureScheduleTimeList(lectureScheduleTime);
	}

	public void autoGenerateScheduleTimeForLecture(Lecture lecture, RepeatedTime repeatedTime, String time){
		/*if
		*
		* Ödev
		*
		*
		* */
	}
}
