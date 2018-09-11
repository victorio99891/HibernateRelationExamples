package com.wiktor.OneToOne;

import com.wiktor.Model.InstructorOneToOne;
import com.wiktor.Model.InstructorDetailsOneToOne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBidirectionalCascadeDelete {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToOne.class)
                .addAnnotatedClass(InstructorDetailsOneToOne.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Begin transaction!");

            session.beginTransaction();

            InstructorDetailsOneToOne instructorDetails = session.get(InstructorDetailsOneToOne.class, 8);

            System.out.println("tempInstructorDetail: " + instructorDetails);
            System.out.println("the associated instructor: " + instructorDetails.getInstructor());

            System.out.println("delete tempInstructorDetail: " + instructorDetails);
            session.delete(instructorDetails);

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
