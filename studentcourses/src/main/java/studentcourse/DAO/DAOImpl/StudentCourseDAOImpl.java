package studentcourse.DAO.DAOImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;

import studentcourse.DAO.StudentCourseDAO;
import studentcourse.model.Course;
import studentcourse.model.Student;
import utils.HibernateUtil;

@Component
public class StudentCourseDAOImpl implements StudentCourseDAO{

	private Session session;
	public void save(Student student) throws Exception{
		 session = HibernateUtil.getSession();
		 session.save(student);
		 HibernateUtil.closeSession();
	}
	public void delete(long studentId) throws Exception{
		 session = HibernateUtil.getSession();
		 Student student = new Student();
		 student.setId(studentId);
         session.delete(student);
         HibernateUtil.closeSession();
	}
	public List<Student>getAllStudentList(String courseName) throws Exception{
		 session = HibernateUtil.getSession();
		Course course = new Course();
		course.setName(courseName);
		Set<Course> courses = new HashSet<>();
		courses.add(course);
		Criteria criteria = session.createCriteria(Student.class);
		criteria.createCriteria("courses").add(Expression.in("courses", courses)).addOrder(Order.asc("name"));
		return criteria.list();
	}
}
