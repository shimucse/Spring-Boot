package com.lum2code.cruddemo.dao;

import com.lum2code.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
