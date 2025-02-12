package com.bcs.project.stpauls.model;
import jakarta.persistence.*;

@Entity
@Table(name = "payment_details")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    @Enumerated(value = EnumType.STRING)
    private PaymentType payment_type;

    @Column(name = "payment_year", nullable = false)
    private String payment_year;

    @Column(name = "payment_month", nullable = false)
    private String payment_month;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name="paid")
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public PaymentType getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(PaymentType payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_year() {
        return payment_year;
    }

    public void setPayment_year(String payment_year) {
        this.payment_year = payment_year;
    }

    public String getPayment_month() {
        return payment_month;
    }

    public void setPayment_month(String payment_month) {
        this.payment_month = payment_month;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}