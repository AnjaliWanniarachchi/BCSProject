//package com.bcs.project.stpauls.model;
//
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = " report")
//public class Report {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long    report_id;
//    // CREATE TABLE report (
//    //    report_id INT AUTO_INCREMENT PRIMARY KEY,
//    //    report_name VARCHAR(100) NOT NULL,
//    //    teacher_id INT,
//    //    student_id INT,
//    //    FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE SET NULL,
//    //    FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id) ON DELETE SET NULL,
//    //    feedback TEXTeacher(teacher_id) ON DELETE SET NULL
//    //);
//    @Column(name = "report_name",nullable = false)
//    private String reportName;
//
//    @Column(name = " teacher_id",nullable = false)
//    private String   teacher_id;
//
//
//    @Column(name = " student_id",nullable = false)
//    private String    student_id;
//
//
//    // Getters and Setters
//
//
//    public Long getReport_id() {
//        return report_id;
//    }
//
//    public void setReport_id(Long report_id) {
//        this.report_id = report_id;
//    }
//
//    public String getReportName() {
//        return reportName;
//    }
//
//    public void setReportName(String reportName) {
//        this.reportName = reportName;
//    }
//
//    public String getTeacher_id() {
//        return teacher_id;
//    }
//
//    public void setTeacher_id(String teacher_id) {
//        this.teacher_id = teacher_id;
//    }
//
//    public String getStudent_id() {
//        return student_id;
//    }
//
//    public void setStudent_id(String student_id) {
//        this.student_id = student_id;
//    }
//}