package com.wiktor.OneToOne;

import com.wiktor.Model.Instructor;
import com.wiktor.Model.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OneToOne {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Begin transaction!");

            Instructor tempInstructor = new Instructor("Andrey", "McCain", "McCain@dot.stand.edu.com");
            InstructorDetails tempDetails = new InstructorDetails("El professore", "teaching people");

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
