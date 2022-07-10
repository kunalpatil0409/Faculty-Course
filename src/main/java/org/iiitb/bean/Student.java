package org.iiitb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    
    @Column(unique = true)
    private String rollNumber;

    @NotBlank
    private String name;

    private String username;

    private String password;

    public void setCourseStudent(Set<CourseStudent> courseStudent) {
        this.courseStudent = courseStudent;
    }

    public Set<CourseStudent> getCourseStudent() {
        return courseStudent;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    private Set<CourseStudent> courseStudent = new HashSet<CourseStudent>();

    public Student() {
    }

    public Student(Integer id) {
        this.studentId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(String rollNumber, @NotBlank String name, String username, String password, Set<CourseStudent> courseStudent) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.username = username;
        this.password = password;
        this.courseStudent = courseStudent;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
