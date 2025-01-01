package com.bcs.project.stpauls.model;


import jakarta.persistence.*;

@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  batch_id;
    //  batch_id INT AUTO_INCREMENT PRIMARY KEY,
    //    batch_name VARCHAR(100) NOT NULL,
    //    start_date DATE,
    //    end_date DATE
    @Column(name = " batch_name",nullable = false)
    private String batchName;

    @Column(name = "start_date",nullable = false)
    private String startDate;


    @Column(name = " end_date",nullable = false)
    private String  endDate;


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
}