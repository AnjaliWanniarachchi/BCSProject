//package com.bcs.project.stpauls.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = " class")
//public class Classes {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long   class_id;
//    // CREATE TABLE class (
//    //    class_id INT AUTO_INCREMENT PRIMARY KEY,
//    //    class_name VARCHAR(100) NOT NULL,
//    //    batch_id INT,
//    //    teacher_id INT,
//    //           FOREIGN KEY (batch_id) REFERENCES batch(batch_id) ON DELETE SET NULL,
//    //    FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id) ON DELETE SET NULL
//    //);
//    @Column(name = "class_name",nullable = false)
//    private String className;
//
//    @Column(name = " batch_id",nullable = false)
//    private String   batch_id;
//
//
//    @Column(name = " teacher_id",nullable = false)
//    private String    teacher_id;
//
//
//    // Getters and Setters
//
//
//    public Long getClass_id() {
//        return class_id;
//    }
//
//    public void setClass_id(Long class_id) {
//        this.class_id = class_id;
//    }
//
//    public String getClassName() {
//        return className;
//    }
//
//    public void setClassName(String className) {
//        this.className = className;
//    }
//
//    public String getBatch_id() {
//        return batch_id;
//    }
//
//    public void setBatch_id(String batch_id) {
//        this.batch_id = batch_id;
//    }
//
//    public String getTeacher_id() {
//        return teacher_id;
//    }
//
//    public void setTeacher_id(String teacher_id) {
//        this.teacher_id = teacher_id;
//    }
//}