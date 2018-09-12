package com.wiktor.Lazy;


import com.wiktor.Model.CourseOneToMany;
import com.wiktor.Model.InstructorOneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToMany.class)
                .addAnnotatedClass(CourseOneToMany.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            CourseOneToMany course = session.get(CourseOneToMany.class, 12);

            session.delete(course);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }


}
