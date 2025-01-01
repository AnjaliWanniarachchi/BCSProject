//package com.bcs.project.stpauls.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "activity")
//public class Activity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long  notification_id;
//    // CREATE TABLE notification (
//    //    notification_id INT AUTO_INCREMENT PRIMARY KEY,
//    //    notification_description TEXT NOT NULL,
//    //    activity_id INT,
//    //    student_id INT,
//    //    FOREIGN KEY (activity_id) REFERENCES activity(activity_id) ON DELETE SET NULL,
//    //    FOREIGN KEY (student_id)
//    @Column(name = " notification_description",nullable = false)
//    private String notificationDescription;
//
//    @Column(name = "activity_id",nullable = false)
//    private String activity_id;
//
//
//    @Column(name = " student_id",nullable = false)
//    private String  student_id;
//
//
//    // Getters and Setters
//
//
//    public Long getNotification_id() {
//        return notification_id;
//    }
//
//    public void setNotification_id(Long notification_id) {
//        this.notification_id = notification_id;
//    }
//
//    public String getActivity_id() {
//        return activity_id;
//    }
//
//    public void setActivity_id(String activity_id) {
//        this.activity_id = activity_id;
//    }
//
//    public String getNotificationDescription() {
//        return notificationDescription;
//    }
//
//    public void setNotificationDescription(String notificationDescription) {
//        this.notificationDescription = notificationDescription;
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