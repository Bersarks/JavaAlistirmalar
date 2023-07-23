## Structure of the project
### Enum Grade
- The enum type Grade represents the grade of a student and defines constants representing the grades of A, B, C, D, F.

- Grade has two instance fields, stringValue and numericValue. stringValue contains a String representation of the letter grade. numericValue contains the numeric grade corresponding to the letter grade, which are 4, 3, 2, 1, 0 for A, B, C, D, and F respectively.

### GradeTest
- In this class a for each loop, and the values() method of Grade is used to print out a formatted String output.

### CourseGrade
- The CourseGrade class keeps information about the department the course is offered,
course code of the course, credit of the course and the grade taken for that course in the
courseDepartment, courseCode and courseCredit and gradeTaken fields.

- Four overloaded constructors that take different number of parameters are implemented Constructors with less parameters call the constructor with more parameters and fill the missing parameters with default values.

- An additional constructor that takes gradeTaken as a double value instead of a GradeEnum is also added.

- Inside of set methods there is a check for the validity of the input values for the fields. If the input is not valid, the field is set to default value.

### Transcript
- This class keeps the transcript of a student with id studentID and set gpa to "0.0".
We can add courses with list of CourseGrade objects and calculate GPA of the student or add courses with addCourseToList method one by one and calculate gpa everytime.

- The calculateGPA method calculates and stores the GPA of the student as a double field which is the average of all grades taken by the student for all the courses. GPA is therefore a value between "0.0" and "4.0".
