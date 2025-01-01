package com.bcs.project.stpauls.model;

import jakarta.persistence.*;

@Entity
@Table(name = " class")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   class_id;
    // CREATE TABLE class (
    //    class_id INT AUTO_INCREMENT PRIMARY KEY,
    //    class_name VARCHAR(100) NOT NULL,
    //    batch_id INT,
    //    teacher_id INT,
    //           FOREIGN KEY (batch_id) REFERENCES batch(batch_id) ON DELETE SET NULL,
    //    FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id) ON DELETE SET NULL
    //);
    @Column(name = "class_name",nullable = false)
    private String className;


    @OneToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    // Getters and Setters


    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}