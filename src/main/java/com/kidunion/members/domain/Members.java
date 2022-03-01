package com.kidunion.members.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String firstName;
    @Column(nullable = false, length = 255)
    private String lastName;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false, length = 255)
    private String email;
    @Column(nullable = false, length = 255)
    private String phoneNumber;
    @Column(nullable = false, length = 255)
    private String adress;
    @Column(nullable = false, length = 255)
    private String photo;
    @Column(nullable = false, length = 255)
    private LocalDate addedThe;
    @Column(nullable = false, length = 255)
    private String storageTime;
    @Column(nullable = false, length = 255)
    private String documentsProvided;
    @Column(nullable = false, length = 255)
    private String typeOfRegistration;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setAddedThe(LocalDate addedThe) {
        this.addedThe = addedThe;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime;
    }

    public void setDocumentsProvided(String documentsProvided) {
        this.documentsProvided = documentsProvided;
    }

    public void setTypeOfRegistration(String typeOfRegistration) {
        this.typeOfRegistration = typeOfRegistration;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoto() {
        return photo;
    }

    public LocalDate getAddedThe() {
        return addedThe;
    }

    public String getStorageTime() {
        return storageTime;
    }

    public String getDocumentsProvided() {
        return documentsProvided;
    }

    public String getTypeOfRegistration() {
        return typeOfRegistration;
    }

    @Override
    public String toString() {
        return "Members{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adress='" + adress + '\'' +
                ", photo='" + photo + '\'' +
                ", addedThe=" + addedThe +
                ", storageTime='" + storageTime + '\'' +
                ", documentsProvided='" + documentsProvided + '\'' +
                ", typeOfRegistration='" + typeOfRegistration + '\'' +
                '}';
    }
}
