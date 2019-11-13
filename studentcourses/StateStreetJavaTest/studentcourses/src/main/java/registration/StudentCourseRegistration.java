package registration;

import java.util.HashSet;
import java.util.Set;

import studentcourse.DAO.StudentCourseDAO;
import studentcourse.DAO.DAOImpl.StudentCourseDAOImpl;
import studentcourse.model.Course;
import studentcourse.model.Student;

public class StudentCourseRegistration {

	public static void main(String[] args) {
		StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
		Student student1 = new Student();
        student1.setName("John");
        Student student2 = new Student();
        student2.setName("Joe");
        Course course1 = new Course();
        
        Set<Course> courses = new HashSet<Course>();
        course1.setName("Maths");
        Course course2 = new Course();
        course2.setName("Computer Science");
        courses.add(course1);
        courses.add(course2);
        student1.setCourses(courses);
        
        try {
			studentCourseDAO.save(student1);
			studentCourseDAO.save(student2);
		} catch (Exception e) {
			e.printStackTrace();
		}
        //studentCourseDAO.delete(1l);
        //studentCourseDAO.getAllStudentList("");

	}

}
