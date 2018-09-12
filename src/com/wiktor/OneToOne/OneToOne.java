package com.wiktor.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToOne.class)
                .addAnnotatedClass(InstructorDetailsOneToOne.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Begin transaction!");

            InstructorOneToOne tempInstructor = new InstructorOneToOne("Andrey", "McCain", "McCain@dot.stand.edu.com");
            InstructorDetailsOneToOne tempDetails = new InstructorDetailsOneToOne("El professore", "teaching people");

            session.beginTransaction();
            tempInstructor.setDetails(tempDetails);

            //Zapisze wszystko ponieważ mamy ustawione OneToOne(Cascade.saveALL) ;)
            System.out.println("Saving instructor..." + tempInstructor);
            session.save(tempInstructor);


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
