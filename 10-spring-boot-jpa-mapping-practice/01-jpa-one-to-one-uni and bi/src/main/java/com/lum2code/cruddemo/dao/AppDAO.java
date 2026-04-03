package com.lum2code.cruddemo.dao;

import com.lum2code.cruddemo.entity.Instructor;
import com.lum2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {
      void save(Instructor instructor);
      Instructor findInstructorById(int id);
      void delete(int id);

      void save(InstructorDetail instructorDetail);
      InstructorDetail findInstructorDetailsById(int id);

}
