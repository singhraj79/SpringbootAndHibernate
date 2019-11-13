package studentcourse.DAO.DAOImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.OrderBy;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import studentcourse.DAO.StudentCourseDAO;
import studentcourse.model.Course;
import studentcourse.model.Student;
import utils.HibernateUtil;

public class StudentCourseDAOImpl implements StudentCourseDAO{

	public void save(Student student) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx =  session.beginTransaction();
        session.save(student);
        tx.commit();
        HibernateUtil.closeSession();
	}
	public void delete(long studentId) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx =  session.beginTransaction();
		Student student = new Student();
		student.setId(studentId);
        session.delete(student);
        tx.commit();
        HibernateUtil.closeSession();
	}
	public List<Student>getAllStudentList(String courseName) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Course course = new Course();
		course.setName(courseName);
		Set<Course> courses = new HashSet<>();
		courses.add(course);
		Criteria criteria = session.createCriteria(Student.class);
		criteria.createCriteria("courses").add(Expression.in("courses", courses)).addOrder(Order.asc("name"));
		return criteria.list();
	}
}
