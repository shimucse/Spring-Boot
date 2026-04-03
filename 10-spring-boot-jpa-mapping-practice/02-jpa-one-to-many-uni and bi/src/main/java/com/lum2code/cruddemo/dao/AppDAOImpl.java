package com.lum2code.cruddemo.dao;

import com.lum2code.cruddemo.entity.Course;
import com.lum2code.cruddemo.entity.Instructor;
import com.lum2code.cruddemo.entity.InstructorDetail;
import com.lum2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl  implements  AppDAO{

    private EntityManager entityManager;
    @Autowired
    public  AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        return instructor;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        if(instructor!=null){
            entityManager.remove(instructor);
        }
        else {
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional
    public void save(InstructorDetail instructorDetail) {
         entityManager.persist(instructorDetail);
    }

    @Override
    public InstructorDetail findInstructorDetailsById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

             return instructorDetail;

    }

    @Override
    @Transactional
    public Course findCourseById(int id) {
        Course course = entityManager.find(Course.class,id);
        return course;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
          entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findStudentById(int id) {
        Student student = entityManager.find(Student.class,id);
        student.getCourses().size();

        return student;
    }


}
