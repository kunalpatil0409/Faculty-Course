package org.iiitb.service.impl;

import org.iiitb.bean.Student;
import org.iiitb.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    
    @Override
    public void save(Student student) {
        studentDao.save(student);
    }
    
    @Override
    public Student find(Integer id) {
        return studentDao.find(id);
    }

    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }


    @Override
    public boolean validate(String username, String password){ return studentDao.validate(username, password);}


}
