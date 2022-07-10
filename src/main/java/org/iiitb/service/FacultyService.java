package org.iiitb.service;

import org.iiitb.bean.Faculty;
import org.iiitb.dao.FacultyDao;
import org.iiitb.dao.StudentDao;

import java.util.List;

public interface FacultyService {

    FacultyDao facultyDao = new FacultyDao();

    boolean validate(String username, String password);

    void updateGrade(String s);

    void save(Faculty faculty);

}
