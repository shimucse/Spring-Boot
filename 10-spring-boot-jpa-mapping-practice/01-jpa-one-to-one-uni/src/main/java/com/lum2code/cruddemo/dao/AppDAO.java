package com.lum2code.cruddemo.dao;

import com.lum2code.cruddemo.entity.Instructor;

public interface AppDAO {
   void save(Instructor instructor);
   Instructor findInstructorById(int id);
   void delete(int id);
}
