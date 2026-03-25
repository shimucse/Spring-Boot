package com.shima.section4_rest_crud_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Transient
    private String country;
    @Transient
    private String favoriteLanguage;
    @Column(name="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

     public Employee(){

     }

    public Employee(String firstName, String lastName, String email,String country, String favoriteLanguage) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.favoriteLanguage = favoriteLanguage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "country='" + country + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", favoriteLanguage='" + favoriteLanguage + '\'' +
                '}';
    }
}
