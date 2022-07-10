package org.iiitb.service.impl;

import org.iiitb.bean.Course;
import org.iiitb.bean.CourseStudent;
import org.iiitb.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {


    @Override
    public List<CourseStudent> getCourseStudents() {
        return coursedao.getCourseStudents();
    }

    @Override
    public List<Course> getCourses() {
        return coursedao.getCourses();
    }
}
