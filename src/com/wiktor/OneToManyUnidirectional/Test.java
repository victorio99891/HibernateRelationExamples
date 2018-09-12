package com.wiktor.OneToManyUnidirectional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("second-hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToManyUnidirectional.class)
                .addAnnotatedClass(CourseOneToManyUnidirectional.class)
                .addAnnotatedClass(ReviewOneToManyUnidirectional.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            CourseOneToManyUnidirectional cor = session.get(CourseOneToManyUnidirectional.class, 3);

            ReviewOneToManyUnidirectional rev = new ReviewOneToManyUnidirectional("Helllo!");

            cor.add(rev);
            session.save(rev);


            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }


}
