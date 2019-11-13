package application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import studentcourse.DAO.StudentCourseDAO;
import studentcourse.DAO.DAOImpl.StudentCourseDAOImpl;
import studentcourse.service.StudentCourseService;
import studentcourse.service.serviceImpl.StudentCourseServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public StudentCourseService studentCourseService() {
        return new StudentCourseServiceImpl();
    }
    
    @Bean
    public StudentCourseDAO studentCourseDAO() {
        return new StudentCourseDAOImpl();
    }
    
}
