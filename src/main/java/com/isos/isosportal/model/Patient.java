package com.isos.isosportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Patient implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;


    @Column(name = "registrationNumber")
    private String registrationNumber;


    @Column(name = "gender")
    private  String gender;

    @Column(name = "dob")
    private LocalDateTime dob;

    @Column(name = "address")
    private String address;


    @Column(name = "consultation_date")
    private LocalDateTime consultationDate;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDateTime consultationDate) {
        this.consultationDate = consultationDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", consultationDate=" + consultationDate +
                '}';
    }
}
