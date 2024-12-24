package com.example.task.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
public class UpdatedStudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long updatedId ;

    @NotNull(message = "Name field is required!")
    @Size(min = 2,max = 30,message = "min 2 and max 20 characters are allowed!!")
    private String updatedName;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid userEmail format")
    @NotEmpty(message = "Email cannot be empty")
    private String updatedStudentEmail;

    private Long oldId;
    private String oldName;
    private String oldEmail;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    public UpdatedStudentInfo() {
    }

    public UpdatedStudentInfo(Long updatedId, String updatedName,
                              String updatedStudentEmail, Long oldId, String oldName,
                              String oldEmail, String fieldName, Date updateAt) {
        this.updatedId = updatedId;
        this.updatedName = updatedName;
        this.updatedStudentEmail = updatedStudentEmail;
        this.oldId = oldId;
        this.oldName = oldName;
        this.oldEmail = oldEmail;
//        this.fieldName = fieldName;
        this.updateAt = updateAt;
    }

    public Long getUpdatedId() {
        return updatedId;
    }

    public void setUpdatedId(Long updatedId) {
        this.updatedId = updatedId;
    }

    public @NotNull(message = "Name field is required!") @Size(min = 2, max = 30, message = "min 2 and max 20 characters are allowed!!") String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(@NotNull(message = "Name field is required!") @Size(min = 2, max = 30, message = "min 2 and max 20 characters are allowed!!") String updatedName) {
        this.updatedName = updatedName;
    }

    public @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid userEmail format") @NotEmpty(message = "Email cannot be empty") String getUpdatedStudentEmail() {
        return updatedStudentEmail;
    }

    public void setUpdatedStudentEmail(@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid userEmail format") @NotEmpty(message = "Email cannot be empty") String updatedStudentEmail) {
        this.updatedStudentEmail = updatedStudentEmail;
    }

    public Long getOldId() {
        return oldId;
    }

    public void setOldId(Long oldId) {
        this.oldId = oldId;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

   /* public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }*/

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}