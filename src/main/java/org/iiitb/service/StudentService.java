package org.iiitb.service;

import org.iiitb.bean.Student;
import org.iiitb.dao.StudentDao;

import java.util.List;

public interface StudentService {
    
    StudentDao studentDao = new StudentDao();

    void save(Student student);
    
    Student find(Integer id);

    List<Student> getStudents();


    boolean validate(String username, String password);
}
