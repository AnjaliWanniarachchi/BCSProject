package com.bcs.project.stpauls.model;


import jakarta.persistence.*;

@Entity
@Table(name = " report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long report_id;

    @Column(name = "report_name", nullable = false)
    private String reportName;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name="feedback")
    private String feedback;

    // Getters and Setters


    public Long getReport_id() {
        return report_id;
    }

    public void setReport_id(Long report_id) {
        this.report_id = report_id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}