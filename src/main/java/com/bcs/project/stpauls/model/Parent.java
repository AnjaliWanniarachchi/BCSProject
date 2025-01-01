//package com.bcs.project.stpauls.model;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "parent")
//public class Parent {
//
//    //parent (
//    //    parent_id INT AUTO_INCREMENT PRIMARY KEY,
//    //    first_name VARCHAR(100) NOT NULL,
//    //    last_name VARCHAR(100) NOT NULL,
//    //    email VARCHAR(100) UNIQUE,
//    //    phone_number VARCHAR(15),
//    //    address TEXT
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long parent_id;
//
//    @Column(name = "first_name", nullable = false)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false)
//    private String lastName;
//
//
//    @Column(name = "email", nullable = false)
//    private String email;
//
//    @Column(name = "phone_number", nullable = false)
//    private String phone_number;
//
//    @Column(name = "address", nullable = false)
//    private String address;
//
//    //getters and setters
//
//    public Long getParent_id() {
//        return parent_id;
//    }
//
//    public void setParent_id(Long parent_id) {
//        this.parent_id = parent_id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone_number() {
//        return phone_number;
//    }
//
//    public void setPhone_number(String phone_number) {
//        this.phone_number = phone_number;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//}