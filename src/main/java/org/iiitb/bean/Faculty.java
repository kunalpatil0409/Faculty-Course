package org.iiitb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Faculty {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facultyId;

    @NotBlank
    private String name;

    public Faculty() {
    }

    @NotBlank
    private String username;
    @NotBlank
    private String password;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Course> course = new ArrayList<Course>();

    public Faculty(@NotBlank String name, @NotBlank String username, @NotBlank String password, List<Course> course) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}
