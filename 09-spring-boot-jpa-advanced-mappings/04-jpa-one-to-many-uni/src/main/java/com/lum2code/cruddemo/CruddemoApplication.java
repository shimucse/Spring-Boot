package com.lum2code.cruddemo;

import com.lum2code.cruddemo.dao.AppDAO;
import com.lum2code.cruddemo.entity.Course;
import com.lum2code.cruddemo.entity.Instructor;
import com.lum2code.cruddemo.entity.InstructorDetail;
import com.lum2code.cruddemo.entity.Review;
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
             //createCourseAndReviews(appDAO);
			 //retrieveCourseAndReviews(appDAO);
			 deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId =10;
		System.out.println("Deleteing course id: "+theId);
		//appDAO.deleteCourseById(theId);
		System.out.println("Done");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		 //get the course and reviews
          int theId =10;
		  Course thempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		 //print the course
		 System.out.println(thempCourse);

		//print the reviews
        System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		 //create a course
		 Course tempCourse = new Course("Pacman -How To Score One Million Points");

		//add some reviews
		tempCourse.AddReview(new Review("Great course ...loved it!"));
		tempCourse.AddReview(new Review("Cool course, ...job well done ."));
		tempCourse.AddReview(new Review("what a dumb course, you are an idiot!"));


		//save the course...and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);
        System.out.println("Done!");

	}

	private void updateCourse(AppDAO appDAO){
		 int theId = 10;
		 //find the course
		 System.out.println("Finding course id: "+theId );
		 Course tempCourse = appDAO.findCourseById(theId);
		 //update the course
		 System.out.println("Updating course id: "+ theId);
		 tempCourse.setTitle("Enjoy the Simple Things");
		 appDAO.update(tempCourse);
	}
	private void updateInstructor(AppDAO appDAO) {
		  int theId=1;
		  //find the instructor
		   System.out.println("Finding instructor id: "+ theId);
		   Instructor tempInstructor = appDAO.findInstructorById(theId);

		   //update the instructor
		   System.out.println("Updating instrucotor id: "+ theId);
		   tempInstructor.setLastName("TESTER");
		   appDAO.update(tempInstructor);
		   System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId =1;
		//find the instructor
		System.out.println("Finding instructor id:"+ theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+ tempInstructor.getCourse());
		System.out.println("Done!");

	}

	private void findCouresForInstructor(AppDAO appDAO) {
			int theId = 1;
			System.out.println("Finding instructor id: "+ theId );
			Instructor tempInstructor = appDAO.findInstructorById(theId);
			System.out.println("tempInstructor: "+tempInstructor);
			//find courses for instructor
		    System.out.println("Finding courses for instructor id: "+ theId);
			List<Course> courses = appDAO.findCoursesByInstructorId(theId);
			//associate the objects
		    tempInstructor.setCourse(courses);
			System.out.println("the associated courses: " + tempInstructor.getCourse());
			System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO){
		 int theId = 1;
		 System.out.println("Finding instructor id: "+ theId );
		 Instructor tempInstructor = appDAO.findInstructorById(theId);
		 System.out.println("tempInstructor: "+tempInstructor);
		 System.out.println("the associated courses: "+ tempInstructor.getCourse());
		 System.out.println("Done!");


	}
	private void createInstructorWithCourses(AppDAO appDAO){
		// Create the instructor
		Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");

		// Create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://www.youtube.com",
				"Video Games"
		);
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//create some courses
		Course tempCourse1 = new Course("Air Guitar -The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball MasterClass");
		System.out.println("Done!");
		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		//Note: this will also save the courses
		//because of CascadeType.PERSIST

		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The courses: "+ tempInstructor.getCourse());
		appDAO.save(tempInstructor);
		System.out.println("done");

	}
	private void deleteinstructorDetailse(AppDAO appDAO){
		int theId =3;
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}
	private void findInstructorDetail(AppDAO appDAO){
		//get the instructor detail object
        int theId =2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		//print the instructor detail
         System.out.println("tempInstructorDetail: "+tempInstructorDetail);
		//print the associated instructor
		System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());
		System.out.println("Done");
	}
	private void deleteinstructor(AppDAO appDAO){
		 int theId =1;
		 System.out.println("Deleting instructor id: "+theId);
		 appDAO.deleteInstructorById(theId);
		 System.out.println("Done!");
	}



	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
	    Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+ tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
		// Create the instructor
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		// Create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://www.luvcode.com/youtube",
				"Luv 2 Code !!!"
		);

		// Associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);


		// Save the instructor
		// NOTE: This will ALSO save the details object because of cascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}
}