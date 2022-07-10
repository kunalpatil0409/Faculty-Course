package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Course;
import org.iiitb.bean.CourseStudent;
import org.iiitb.util.SessionUtil;

import java.util.List;

public class CourseDao {

    public List<CourseStudent> getCourseStudents() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM CourseStudent";

        Query query = session.createQuery(hql);

        List<CourseStudent> studentList = query.list();

        transaction.commit();
        session.close();

        return studentList;
    }

    public List<Course> getCourses() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Course";
        Query query = session.createQuery(hql);
        List<Course> courseList = query.list();
        transaction.commit();
        session.close();
        return courseList;
    }
}
