package com.bcs.project.stpauls.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  batch_id;

    @Column(name = " batch_name",nullable = false)
    private String batchName;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = " end_date")
    private String  endDate;

    @OneToMany(mappedBy = "batch")
    private List<Classes> classes;

    // Getters and Setters


    public Long getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Long batch_id) {
        this.batch_id = batch_id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
}