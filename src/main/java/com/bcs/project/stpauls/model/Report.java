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

    @Column(name = "report_month", nullable = false)
    private String reportMonth;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name="feedback")
    private String feedback;

    @Column(name="is_sitting")
    private Boolean isSitting;

    @Column(name="is_taking_turns")
    private Boolean isTakingTurns;

    @Column(name="is_happy")
    private Boolean isHappy;

    @Column(name="is_writing")
    private Boolean isWriting;

    @Column(name="is_following_instructions")
    private Boolean isFollowingInstructions;
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

    public String getReportMonth() {
        return reportMonth;
    }

    public void setReportMonth(String reportMonth) {
        this.reportMonth = reportMonth;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Boolean getSitting() {
        return isSitting;
    }

    public void setSitting(Boolean sitting) {
        isSitting = sitting;
    }

    public Boolean getTakingTurns() {
        return isTakingTurns;
    }

    public void setTakingTurns(Boolean takingTurns) {
        isTakingTurns = takingTurns;
    }

    public Boolean getHappy() {
        return isHappy;
    }

    public void setHappy(Boolean happy) {
        isHappy = happy;
    }

    public Boolean getWriting() {
        return isWriting;
    }

    public void setWriting(Boolean writing) {
        isWriting = writing;
    }

    public Boolean getFollowingInstructions() {
        return isFollowingInstructions;
    }

    public void setFollowingInstructions(Boolean followingInstructions) {
        isFollowingInstructions = followingInstructions;
    }
}