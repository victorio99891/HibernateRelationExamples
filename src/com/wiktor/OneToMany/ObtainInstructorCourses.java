package com.wiktor.OneToMany;


import com.wiktor.Model.CourseOneToMany;
import com.wiktor.Model.InstructorOneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtainInstructorCourses {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToMany.class)
                .addAnnotatedClass(CourseOneToMany.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            InstructorOneToMany instructor = session.get(InstructorOneToMany.class, 3);

            //System.out.println(instructor.getCourseList());

            System.out.println("==============================================================================");
            System.out.println("Courses of user: " + instructor.getFirstName() + " " + instructor.getLastName());
            System.out.println("==============================================================================");
            for (CourseOneToMany course : instructor.getCourseList()) {
                System.out.println(course);
            }
            if (instructor.getCourseList().size() == 0) {
                System.out.println("This instructor don't have any courses!");
            }
            System.out.println("==============================================================================");


            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }


}