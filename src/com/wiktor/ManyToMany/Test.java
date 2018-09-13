package com.wiktor.ManyToMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("second-hibernate.cfg.xml")
                .addAnnotatedClass(InstructorManyToMany.class)
                .addAnnotatedClass(CourseManyToMany.class)
                .addAnnotatedClass(ReviewManyToMany.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Student student = new Student("Laura", "Krzyzanowska", "lkrzyz@wp.pl");
            System.out.println(student.toString());

            CourseManyToMany course = new CourseManyToMany("Perfect Maid!");
            System.out.println(course.toString());

            session.save(student);
            session.save(course);

            course.addStudent(student);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }


}
