package com.lum2code.cruddemo.dao;

import com.lum2code.cruddemo.entity.Course;
import com.lum2code.cruddemo.entity.Instructor;
import com.lum2code.cruddemo.entity.InstructorDetail;
import com.lum2code.cruddemo.entity.Student;

public interface AppDAO {
      void save(Instructor instructor);
      Instructor findInstructorById(int id);
      void delete(int id);

      void save(InstructorDetail instructorDetail);
      InstructorDetail findInstructorDetailsById(int id);

      Course findCourseById(int id);
      void saveStudent(Student student);
      Student findStudentById(int id);

}
