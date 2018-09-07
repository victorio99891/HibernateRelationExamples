package com.wiktor.OneToOne;

import com.wiktor.Model.Instructor;
import com.wiktor.Model.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEntity {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Begin transaction!");
            session.beginTransaction();


            Instructor instructor = session.get(Instructor.class, 5);

            if (instructor != null) {
                System.out.println(instructor.toString());
                session.delete(instructor);
            } else {
                System.out.println(instructor.toString());
            }

            session.getTransaction().commit();
            System.out.println("SUCCES!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close(); // good habit to close session in this part
            factory.close();
        }


    }
}
