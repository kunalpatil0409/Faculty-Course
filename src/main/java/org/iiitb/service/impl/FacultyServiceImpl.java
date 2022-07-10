package org.iiitb.service.impl;

import org.iiitb.bean.Faculty;
import org.iiitb.service.FacultyService;

import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    @Override
    public boolean validate(String username, String password) {
        return facultyDao.validate(username, password);
    }

    @Override
    public void updateGrade(String s) {
        facultyDao.updateGrade(s);
    }

    @Override
    public void save(Faculty faculty) {facultyDao.save(faculty);}

}