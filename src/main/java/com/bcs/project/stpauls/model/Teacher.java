package com.bcs.project.stpauls.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id;
    //CREATE TABLE teacher (
    //    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    //    first_name VARCHAR(100) NOT NULL,
    //    last_name VARCHAR(100) NOT NULL,
    //    email VARCHAR(100) UNIQUE,
    //    phone_number VARCHAR(15) UNIQUE,
    //    desgnation VARCHAR(100),
    //    hire_date DATE NOT NULL
    //);
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;


    @Column(name = " email",nullable = false)
    private String  email;

    @Column(name = " phone_number",nullable = false)
    private String  phoneNumber;

    @Column(name = " desgnation",nullable = false)
    private String designation;

    @Column(name = "hire_date",nullable = false)
    private String hireDate;




    // Getters and Setters

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}