package studentcourse.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import studentcourse.model.Student;
 
@Service
public interface StudentCourseService {

	public void saveStudenCourse(Student student) throws Exception;
	public void deleteStudentById(long studentId) throws Exception;
	public List<Student>getAllStudentListByCourseName(String courseName) throws Exception;
}
