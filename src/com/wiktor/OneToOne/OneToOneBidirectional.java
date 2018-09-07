package com.wiktor.OneToOne;

import com.wiktor.Model.Instructor;
import com.wiktor.Model.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBidirectional {
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

            InstructorDetails instructorDetails = session.get(InstructorDetails.class, 6);

            System.out.println("tempInstructorDetail: " + instructorDetails);
            System.out.println("the associated instructor: " + instructorDetails.getInstructor());


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
