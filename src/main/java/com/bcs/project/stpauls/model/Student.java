package com.bcs.project.stpauls.model;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
//first_name, last_name, date_of_birth, enrollment_date,gender,parent_id,class_id
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;


    @Column(name = "date_of_birth",nullable = false)
    private String dateOfBirth;

    @Column(name = "enrollment_date",nullable = false)
    private String enrollmentDate;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "parent_id",nullable = false)
    private String parent_id;

    @Column(name = "class_id",nullable = false)
    private String class_id;

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    //    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id", nullable = false)
//    private Parent parent;

//    @JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false)
//    private Classes classes;


    // Getters and Setters
    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public Parent getParent() {
//        return parent;
//    }
//
//    public void setParent(Parent parent) {
//        this.parent = parent;
//    }

//    public Classes getClasses() {
//        return classes;
//    }
//
//    public void setClasses(Classes classes) {
//        this.classes = classes;
//    }
}