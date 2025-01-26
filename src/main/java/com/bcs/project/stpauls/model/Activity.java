package com.bcs.project.stpauls.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  activity_id;

    @Column(name = "activity_name",nullable = false)
    private String activity_name;

    @Column(name = "activity_description")
    private String activity_description;

    @OneToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    // Getters and Setters

    public Long getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Long activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_description() {
        return activity_description;
    }

    public void setActivity_description(String activity_description) {
        this.activity_description = activity_description;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}