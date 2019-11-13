package application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import studentcourse.error.ResourceNotFoundException;
import studentcourse.model.Student;
import studentcourse.service.StudentCourseService;
import studentcourse.service.serviceImpl.StudentCourseServiceImpl;

@RestController
@RequestMapping("/api")
public class StudentCourseController {

	
	
	@Autowired
	private StudentCourseService studentCourseService ;
	
	
	@GetMapping("/test")
	public String hello() {
		return "Hello, Test!";
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<Student>> getStudentList(@RequestParam("courseName")String courseName)
			throws ResourceNotFoundException{
			List<Student> students = new ArrayList<Student>();
			
			try {
				students = studentCourseService.getAllStudentListByCourseName(courseName);
				
			} catch (Exception e) {
				throw new ResourceNotFoundException(e.getMessage());
			}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	@DeleteMapping(value = "/delete")
	public String getStudentList(@RequestParam("studentId")int studentId)
			throws ResourceNotFoundException{
			try {
				 studentCourseService.deleteStudentById(studentId);
			} catch (Exception e) {
				throw new ResourceNotFoundException(e.getMessage());
			}
		return "Success";
	}
	
	
	@PostMapping(value = "/createstudentcourse", consumes = "application/json")	  
    public ResponseEntity<Student> createstudentcourse (
         @RequestBody Student student)throws ResourceNotFoundException {
			try {
				studentCourseService.saveStudenCourse(student);
			} catch (Exception e) {
				throw new ResourceNotFoundException(e.getMessage());
			}
		 return new ResponseEntity<>(student,HttpStatus.OK);
    }
	
	
}
