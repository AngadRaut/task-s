package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq_gen")
    @SequenceGenerator(name = "dept_seq_gen", sequenceName = "dept_seq", allocationSize = 1)
    private int deptId;

    @NotNull(message = "Department Name field should not null!")
    @NotEmpty(message = "Department field is required!" )
    @Size(min = 3,max = 50,message = "min 3  and max 20 characters are allowed for department name field!!")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "collegeId")
    private College college;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public @NotNull(message = "Department Name field should not null!") @NotEmpty(message = "Department field is required!") @Size(min = 3, max = 50, message = "min 3  and max 20 characters are allowed for department name field!!") String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(@NotNull(message = "Department Name field should not null!") @NotEmpty(message = "Department field is required!") @Size(min = 3, max = 50, message = "min 3  and max 20 characters are allowed for department name field!!") String departmentName) {
        this.departmentName = departmentName;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
