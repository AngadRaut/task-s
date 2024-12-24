package com.example.task.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @NotNull(message = "Name field is required!")
    @Size(min = 2,max = 30,message = "min 2 and max 20 characters are allowed!!")
    private String name;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid userEmail format")
    @NotEmpty(message = "Email cannot be empty")
    private String studentEmail;

    @Column(length = 1000)
    private String aboutStudent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Name field is required!") @Size(min = 2, max = 30, message = "min 2 and max 20 characters are allowed!!") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name field is required!") @Size(min = 2, max = 30, message = "min 2 and max 20 characters are allowed!!") String name) {
        this.name = name;
    }

    public @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid userEmail format") @NotEmpty(message = "Email cannot be empty") String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid userEmail format") @NotEmpty(message = "Email cannot be empty") String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getAboutStudent() {
        return aboutStudent;
    }

    public void setAboutStudent(String aboutStudent) {
        this.aboutStudent = aboutStudent;
    }

    public StudentInfo() {
    }

    public StudentInfo(Long id, String name, String studentEmail, String aboutStudent) {
        this.id = id;
        this.name = name;
        this.studentEmail = studentEmail;
        this.aboutStudent = aboutStudent;
    }

}
