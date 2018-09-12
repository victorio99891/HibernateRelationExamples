package com.wiktor.Model;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class CourseEager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private InstructorEager instructor;


    public CourseEager() {
    }

    public CourseEager(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CourseOneToMany{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InstructorEager getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEager instructor) {
        this.instructor = instructor;
    }
}
