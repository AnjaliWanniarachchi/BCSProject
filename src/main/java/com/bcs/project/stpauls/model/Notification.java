package com.bcs.project.stpauls.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  notification_id;
    // CREATE TABLE notification (
    //    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    //    notification_description TEXT NOT NULL,
    //    activity_id INT,
    //    student_id INT,
    //    FOREIGN KEY (activity_id) REFERENCES activity(activity_id) ON DELETE SET NULL,
    //    FOREIGN KEY (student_id)
    @Column(name = " notification_description",nullable = false)
    private String notificationDescription;


    @OneToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;


    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

     //Getters and Setters


    public Long getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(Long notification_id) {
        this.notification_id = notification_id;
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}