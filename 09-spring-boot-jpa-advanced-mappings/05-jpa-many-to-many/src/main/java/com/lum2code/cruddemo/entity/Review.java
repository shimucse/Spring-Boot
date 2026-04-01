package com.lum2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="review")

public class Review {
    //define fields
    //define constructors
    //define getter/setters
    //define toString
    //annotate fields
    private int id;
    private String comment;
    public Review(){

    }
    public Review(String comment){
        this.comment = comment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name ="comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
