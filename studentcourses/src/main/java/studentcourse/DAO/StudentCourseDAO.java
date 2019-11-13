package studentcourse.DAO;
import java.util.List;


import studentcourse.model.Student;

public interface StudentCourseDAO {
	public void save(Student student) throws Exception;
	public void delete(long studentId) throws Exception;
	public List<Student>getAllStudentList(String courseName) throws Exception;
	
	
}
