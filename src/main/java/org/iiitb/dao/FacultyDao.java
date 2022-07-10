package org.iiitb.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.*;
import org.iiitb.util.SessionUtil;


public class FacultyDao {
    public boolean validate(String username, String password) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT f.password FROM Faculty f WHERE f.username = :username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        boolean valid = false;
        String myPass="";

        if (!query.list().isEmpty())
            myPass = (String) query.list().get(0);
        if (myPass.equals(password)) {
            valid = true;
        }
        transaction.commit();
        session.close();
        System.out.println(valid);
        return valid;
    }

    public void updateGrade(String s) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            CourseStudent[] pp1 = mapper.readValue(s, CourseStudent[].class);

            //System.out.println("JSON array to Array objects..."+pp1);
            for (CourseStudent person : pp1) {
                Session session = SessionUtil.getSession();
                Transaction transaction = session.beginTransaction();

                System.out.println(person.getCourse().getCourseId()+" "+person.getStudent().getStudentId()+" "+person.getGrade());
                int cid = person.getCourse().getCourseId();
                int sid = person.getStudent().getStudentId();
                int grade = person.getGrade();
                String hql = "UPDATE CourseStudent SET grade=:grade WHERE COURSE_ID=:cid and STUDENT_ID=:sid";
                Query query = session.createQuery(hql);
                query.setParameter("grade", grade);
                query.setParameter("cid", cid);
                query.setParameter("sid", sid);

                query.executeUpdate();
                //session.save();
                System.out.println("update");
                transaction.commit();
                session.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Faculty faculty) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(faculty);

        transaction.commit();
        session.close();
    }
}