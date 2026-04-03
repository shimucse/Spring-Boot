package com.lum2code.cruddemo;

import com.lum2code.cruddemo.dao.AppDAO;
import com.lum2code.cruddemo.entity.Course;
import com.lum2code.cruddemo.entity.Instructor;
import com.lum2code.cruddemo.entity.InstructorDetail;
import com.lum2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO ){
		//Executed after Spring Beans have been loaded
		return runner->{
			  //createInstructor(appDAO);
			  //findInstructor(appDAO);
			 //deleteinstructor(appDAO);
			 //createInstructorDetailse(appDAO);
			 // findInstructorDetail(appDAO);

			// createCourses(appDAO);
			// findCourseById(appDAO);
			// findInstructorAndCourses(appDAO);
			// createStudentAndCourses(appDAO);
			  findStudentAndCourses(appDAO);

		};
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id =5;
		 Student student = appDAO.findStudentById(id);
		 System.out.println(student.getFirst_name()+"  "+student.getLast_name());
		 List<Course> courses = student.getCourses();
		 if(courses!=null && !courses.isEmpty()){
			 for(Course c :courses){
				 System.out.println("- "+c.getTitle());
			 }
		 }
		 else {
			 System.out.println("No courses found for this instructor.");
		 }

	}

	private void createStudentAndCourses(AppDAO appDAO) {
		Student student = new Student("Shima", "akter","Shima@gmail.com");
		Course course1 = new Course("Java");
		Course course2 = new Course("Spring");

		student.addCourse(course1);
		student.addCourse(course2);
		appDAO.saveStudent(student);
		System.out.println("Saved sucessfully");
	}

	private void findInstructorAndCourses(AppDAO appDAO) {
		 int id =1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());
		List<Course> courses = instructor.getCourses(); // works inside transaction
		if(courses != null && !courses.isEmpty()) {
			System.out.println("Courses:");
			for(Course c : courses) {
				System.out.println("- " + c.getTitle());
			}
		} else {
			System.out.println("No courses found for this instructor.");
		}

	}

	private  void findCourseById(AppDAO appDAO){
		 int id =10;
		 System.out.println(appDAO.findCourseById(id));
	}
	private void createCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Shima","Aurora","aurora@gmail.com");

		Course course1 = new Course("Java");
		Course course2 = new Course("C");
		Course course3 = new Course("Fundamental Of English");

		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructor.addCourse(course3);

        appDAO.save(instructor);
 }

	private void findInstructorDetail(AppDAO appDAO) {
		int id =1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailsById(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void createInstructorDetailse(AppDAO appDAO) {
		InstructorDetail instructorDetail = new InstructorDetail("lizachannel","ghura");
		Instructor instructor = new Instructor("Shishir","Liza", "shishir@gmail.com");
		instructorDetail.setInstructor(instructor);
		appDAO.save(instructorDetail);
		System.out.println("done");
	}

	private void deleteinstructor(AppDAO appDAO) {
		 int id =2;
		 appDAO.delete(id);
		 System.out.println("deleted");
	}

	private void findInstructor(AppDAO appDAO) {
		 int id =1;
		 System.out.println(appDAO.findInstructorById(id));
		 System.out.println("found");
	}

	private void createInstructor(AppDAO appDAO) {
		 Instructor instructor = new Instructor("Fahima ","Akter","Fahima@gmail.com");
		 InstructorDetail instructorDetail  = new InstructorDetail("FahimaChannel","Arting");
		 instructor.setInstructorDetail(instructorDetail);
		 appDAO.save(instructor);
		 System.out.println("saved");
	}

}