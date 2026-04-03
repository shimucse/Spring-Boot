package com.lum2code.cruddemo.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
    int id;

    @Column(name="title")
    String title ;
    public Course(){

    }
    @ManyToOne
    @JoinColumn(name="instructor_id")
    private Instructor instructor;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public void addStudent(Student student){
         if(students == null){
             students = new ArrayList<>();
         }
         students.add(student);
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

}
