package com.wiktor.Eager;


import com.wiktor.Model.CourseOneToMany;
import com.wiktor.Model.InstructorOneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesToInstructor {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToMany.class)
                .addAnnotatedClass(CourseOneToMany.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            InstructorOneToMany instructor1 = session.get(InstructorOneToMany.class, 2);
            InstructorOneToMany instructor2 = session.get(InstructorOneToMany.class, 3);



            CourseOneToMany first = new CourseOneToMany("Adobe Premiere Masterclass PRO");
            CourseOneToMany second = new CourseOneToMany("How to make a perfect shot? - Movie Making");

            instructor1.add(first);
            instructor2.add(second);

            session.save(first);
            session.save(second);





            session.getTransaction().commit();
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }


}
