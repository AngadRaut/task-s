package com.example.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_seq")
    @SequenceGenerator(name = "stu_seq", sequenceName = "jpamappings.stu_seq", allocationSize = 1)
    private int id;

    @NotNull(message = "Name field should not null!!")
    @NotEmpty(message = "Name field is required!" )
    @Size(min = 3,max = 20,message = "min 3  and max 20 characters are allowed!!")
    private String stuName;

    @NotEmpty(message = "please enter the address ")
    private String address;

    @NotBlank(message = "Mobile number is required!")
    @Pattern(regexp = "^[1-9]\\d{9}$", message = "Mobile number must be exactly 10 digits and not start with 0!")
    private String mobileNo;

    @NotNull(message = "Date of Birth cannot be null")
    @Past(message = "Date of Birth must be a past date")
    @JsonFormat(pattern = "MM/dd/yyyy") // Specify how JSON payload should handle the date
    private LocalDate dateOfBirth;

    @Column(unique = true)
    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid userEmail format")
    @NotEmpty(message = "Email cannot be empty!!!")
    private String studentEmail;

    @Embedded
    private Certificate certificate;

    @ManyToOne
    @JoinColumn(name = "collegeId")
    private College college;

    @ManyToOne
    private Department department;

    // setter getter

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "Name field should not null!!") @NotEmpty(message = "Name field is required!") @Size(min = 3, max = 20, message = "min 3  and max 20 characters are allowed!!") String getStuName() {
        return stuName;
    }

    public void setStuName(@NotNull(message = "Name field should not null!!") @NotEmpty(message = "Name field is required!") @Size(min = 3, max = 20, message = "min 3  and max 20 characters are allowed!!") String stuName) {
        this.stuName = stuName;
    }

    public @NotEmpty(message = "please enter the address ") String getAddress() {
        return address;
    }

    public void setAddress(@NotEmpty(message = "please enter the address ") String address) {
        this.address = address;
    }

    public @NotBlank(message = "Mobile number is required!") @Pattern(regexp = "^[1-9]\\d{9}$", message = "Mobile number must be exactly 10 digits and not start with 0!") String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(@NotBlank(message = "Mobile number is required!") @Pattern(regexp = "^[1-9]\\d{9}$", message = "Mobile number must be exactly 10 digits and not start with 0!") String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public @NotNull(message = "Date of Birth cannot be null") @Past(message = "Date of Birth must be a past date") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "Date of Birth cannot be null") @Past(message = "Date of Birth must be a past date") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid userEmail format") @NotEmpty(message = "Email cannot be empty!!!") String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid userEmail format") @NotEmpty(message = "Email cannot be empty!!!") String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
