package com.wiktor.Lazy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtainInstructorCourses {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorLazy.class)
                .addAnnotatedClass(CourseLazy.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            InstructorLazy instructor = session.get(InstructorLazy.class, 1);

            //System.out.println(instructor.getCourseList());

            System.out.println("luv2code: Instructor: " + instructor);

            System.out.println("==============================================================================");
            System.out.println("Courses of user: " + instructor.getFirstName() + " " + instructor.getLastName());
            System.out.println("==============================================================================");
            for (CourseLazy course : instructor.getCourseList()) {
                System.out.println(course.toString());
            }
            if (instructor.getCourseList().size() == 0) {
                System.out.println("This instructor don't have any courses!");
            }
            System.out.println("==============================================================================");
            System.out.println("Done!");

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }


}
