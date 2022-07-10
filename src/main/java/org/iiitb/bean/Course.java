package org.iiitb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private int courseId;

    @NotBlank
    private String courseName;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @ManyToOne
    @JoinColumn(name="facultyId")
    private Faculty faculty = new Faculty();

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<CourseStudent> courseStudent = new ArrayList<CourseStudent>();


    public List<CourseStudent> getCourseStudent() {
        return courseStudent;
    }

    public Course() {
    }

    public Course(int id) {
        this.courseId = id;
    }

    public Course(int courseId, @NotBlank String courseName, Faculty faculty, List<CourseStudent> courseStudent) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.faculty = faculty;
        this.courseStudent = courseStudent;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


}
