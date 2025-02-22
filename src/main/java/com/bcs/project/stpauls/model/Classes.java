package com.bcs.project.stpauls.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "class")
public class Classes {

    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  class_id;

    @Column(name = "class_name",nullable = false)
    private String className;

    @OneToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    //number of students

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

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}