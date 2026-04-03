package com.lum2code.cruddemo.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="student")
public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name ="id")
     int id;

     @Column(name ="first_name")
     String first_name;
     @Column(name = "last_name")
     String last_name;
     @Column(name = "email")
     String email;

     //Many to Many:
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})

    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name ="course_id")
    )
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public void addCourse(Course course){
         if(courses == null) courses = new ArrayList<>();
         courses.add(course);
         course.addStudent(this);
    }
    public Student(){

    }
    public Student(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
