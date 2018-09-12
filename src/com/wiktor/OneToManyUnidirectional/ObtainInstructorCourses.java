package com.wiktor.OneToManyUnidirectional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtainInstructorCourses {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("second-hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToManyUnidirectional.class)
                .addAnnotatedClass(CourseOneToManyUnidirectional.class)
                .addAnnotatedClass(ReviewOneToManyUnidirectional.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            CourseOneToManyUnidirectional course = new CourseOneToManyUnidirectional("Piano, guitar and other instruments.");
            InstructorOneToManyUnidirectional ins = session.get(InstructorOneToManyUnidirectional.class, 2);

            course.setInstructor(ins);

            session.save(course);

            ReviewOneToManyUnidirectional review = new ReviewOneToManyUnidirectional("Good for all music fanatics!");
            course.add(review);
            session.save(review);

            CourseOneToManyUnidirectional course2 = session.get(CourseOneToManyUnidirectional.class, 1);
            review = new ReviewOneToManyUnidirectional("Coding is my love <3 With that course I can do everything! Amazing!!!!");
            course2.add(review);
            session.save(review);


            review = new ReviewOneToManyUnidirectional("God damn it! This guy is a pro! I would be like you master!");
            course.add(review);
            session.save(review);


            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }


}
