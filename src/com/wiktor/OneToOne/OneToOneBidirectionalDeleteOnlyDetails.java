package com.wiktor.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBidirectionalDeleteOnlyDetails {
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

            InstructorDetailsOneToOne instructorDetails = session.get(InstructorDetailsOneToOne.class, 10);

            instructorDetails.getInstructor().setDetails(null); // brake bi-directional link between InstructorOneToOne and InstructorDetailsOneToOne

            session.delete(instructorDetails);

           /* InstructorOneToOne tmpIns = session.get(InstructorOneToOne.class, 10);
            session.delete(tmpIns);*/

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
