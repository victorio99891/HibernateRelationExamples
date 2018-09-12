package com.wiktor.FetchJoin;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoin {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorFetchJoin.class)
                .addAnnotatedClass(CourseFetchJoin.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Query<InstructorFetchJoin> query = session.createQuery("select i from InstructorFetchJoin i " + "JOIN FETCH i.courseList " + "where i.id=:theInstructorId", InstructorFetchJoin.class);
            query.setParameter("theInstructorId", 1);


            InstructorFetchJoin ins = query.getSingleResult();

            System.out.println("luv2code: Instructor: " + ins);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }


}
