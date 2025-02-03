package com.spring.demo;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "users")
public class
RegisteredUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "whatsapp_no")
    private String whatsappNo;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "profile_image_url")
    private String profileImageUrl;

    public RegisteredUser() {

    }
    public RegisteredUser(String username, String mail, String firstName, String lastName, String phoneNo, String whatsappNo,String gender, Date dob, String profileImageUrl) {
        this.username = username;
        this.email = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.whatsappNo = whatsappNo;
        this.gender = gender;
        this.dob = dob;
        this.profileImageUrl = profileImageUrl;
    }
//    public RegisteredUser(String username, String mail, String firstName, String lastName, String phoneNo, String whatsappNo, String gender, Date dob) {
//       this(username,mail,firstName,lastName,phoneNo,whatsappNo,gender,dob,"");
//
//    }
//    public RegisteredUser(String username, String mail, String firstName, String lastName, String phoneNo, String whatsappNo, String gender) {
//        this(username,mail,firstName,lastName,phoneNo,whatsappNo,gender, new Date(),"");
//
//    }
//    public RegisteredUser(String username, String mail, String firstName, String lastName, String phoneNo, String whatsappNo) {
//        this(username,mail,firstName,lastName,phoneNo,whatsappNo,whatsappNo, new Date(),"");
//
//    }
//    public RegisteredUser(String username, String mail, String firstName, String lastName, String phoneNo) {
//        this(username,mail,firstName,lastName,phoneNo,"","", new Date(),"");
//    }
//    public RegisteredUser(String username, String mail, String firstName, String lastName) {
//        this(username,mail,firstName,lastName,"","","", new Date(),"");
//    }
//    public RegisteredUser(String username, String mail, String firstName) {
//        this(username,mail,firstName,"","","","", new Date(),"");
//    }
    public RegisteredUser(String username, String mail) {
        this(username,mail,"","","","","", new Date(),"");

    }

    // Getters and Setters

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getWhatsappNo() {
        return whatsappNo;
    }

    public void setWhatsappNo(String whatsappNo) {
        this.whatsappNo = whatsappNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
