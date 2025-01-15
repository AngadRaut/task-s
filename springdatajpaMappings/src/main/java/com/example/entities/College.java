package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "college_seq_gen")
    @SequenceGenerator(name = "college_seq_gen", sequenceName = "college_seq", allocationSize = 1)
    private int collegeId;

    @NotNull(message = "College Name field should not null!")
    @NotEmpty(message = "College field is required!" )
    @Size(min = 3,max = 50,message = "min 3  and max 20 characters are allowed for college name field!!")
    private String collegeName;

    @NotNull(message = "College address field should not null!")
    @NotEmpty(message = "College address is required!" )
    @Size(min = 3,max = 50,message = "min 3  and max 20 characters are allowed for college address field!!")
    private String collegeAddressCity;

    @NotNull(message = "College pinCode field should not null!")
//    @NotEmpty(message = "College pinCode field is required!" )
//    @Size(min = 3,max = 6,message = "college pin code must be in between 3 to 6 characters!!")
    private int pinCode;

    @NotEmpty(message = "Specify the type of the college!!")
    @Pattern(regexp = "^(Government|Semi-Government|Private|Autonomous)$", message = "Status must be one of: Government, SemiGovernment, Private, Autonomous!")
    private String type;

    @OneToMany(mappedBy = "college",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> student;

    @OneToMany(mappedBy = "college",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Department> departments;

    // getters setters

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public @NotNull(message = "College Name field should not null!") @NotEmpty(message = "College field is required!") @Size(min = 3, max = 50, message = "min 3  and max 20 characters are allowed for college name field!!") String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(@NotNull(message = "College Name field should not null!") @NotEmpty(message = "College field is required!") @Size(min = 3, max = 50, message = "min 3  and max 20 characters are allowed for college name field!!") String collegeName) {
        this.collegeName = collegeName;
    }

    public @NotNull(message = "College address field should not null!") @NotEmpty(message = "College address is required!") @Size(min = 3, max = 50, message = "min 3  and max 20 characters are allowed for college address field!!") String getCollegeAddressCity() {
        return collegeAddressCity;
    }

    public void setCollegeAddressCity(@NotNull(message = "College address field should not null!") @NotEmpty(message = "College address is required!") @Size(min = 3, max = 50, message = "min 3  and max 20 characters are allowed for college address field!!") String collegeAddressCity) {
        this.collegeAddressCity = collegeAddressCity;
    }

    @NotNull(message = "College pinCode field should not null!")
//    @NotEmpty(message = "College pinCode field is required!")
//    @Size(min = 3, max = 6, message = "college pin code must be in between 3 to 6 characters!!")
    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(@NotNull(message = "College pinCode field should not null!") @NotEmpty(message = "College pinCode field is required!") int pinCode) {
        this.pinCode = pinCode;
    }

    public @NotEmpty(message = "Specify the type of the college!!") @Pattern(regexp = "^(Government|Semi-Government|Private|Autonomous)$", message = "Status must be one of: Government, SemiGovernment, Private, Autonomous!") String getType() {
        return type;
    }

    public void setType(@NotEmpty(message = "Specify the type of the college!!") @Pattern(regexp = "^(Government|Semi-Government|Private|Autonomous)$", message = "Status must be one of: Government, SemiGovernment, Private, Autonomous!") String type) {
        this.type = type;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "College {" +
                "collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                ", collegeAddressCity='" + collegeAddressCity + '\'' +
                ", pinCode=" + pinCode +
                ", type='" + type + '\'' +
                ", student=" + student +
                ", departments=" + departments +
                '}';
    }
}
