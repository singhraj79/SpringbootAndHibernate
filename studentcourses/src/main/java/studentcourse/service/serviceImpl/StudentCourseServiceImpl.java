package studentcourse.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import studentcourse.DAO.StudentCourseDAO;
import studentcourse.model.Student;
import studentcourse.service.StudentCourseService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService{

	@Autowired
	private StudentCourseDAO studentCourseDAO;
	@Transactional
	public void saveStudenCourse(Student student) throws Exception{
		studentCourseDAO.save(student);
	}
	@Transactional
	public void deleteStudentById(long studentId) throws Exception{
		studentCourseDAO.delete(studentId);
	}
	@Transactional(readOnly = true)
	public List<Student>getAllStudentListByCourseName(String courseName) throws Exception{
		return studentCourseDAO.getAllStudentList(courseName);
	}
	
	
}
