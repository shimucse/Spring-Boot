package com.lum2code.cruddemo;

import com.lum2code.cruddemo.dao.AppDAO;
import com.lum2code.cruddemo.entity.Instructor;
import com.lum2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			 // findInstructor(appDAO);
			 //deleteinstructor(appDAO);

			//createInstructorDetailse(appDAO);
			  findInstructorDetail(appDAO);

		};
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id =5;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailsById(id);
		System.out.println(instructorDetail);
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