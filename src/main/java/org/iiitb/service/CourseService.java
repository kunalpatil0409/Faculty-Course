package org.iiitb.service;

import org.iiitb.bean.Course;
import org.iiitb.bean.CourseStudent;
import org.iiitb.bean.Student;
import org.iiitb.dao.CourseDao;

import java.util.List;

public interface CourseService {
    CourseDao coursedao = new CourseDao();

    List<CourseStudent> getCourseStudents();

    List<Course> getCourses();
}
