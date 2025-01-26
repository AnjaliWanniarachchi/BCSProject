package com.bcs.project.stpauls.model;

import jakarta.persistence.*;

@Entity
@Table(name = " class")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   class_id;

    @Column(name = "class_name",nullable = false)
    private String className;

    @OneToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    @OneToOne
    @JoinColumn(name = "teacher_id")
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