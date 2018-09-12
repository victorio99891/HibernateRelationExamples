package com.wiktor.Lazy;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class CourseLazy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private InstructorLazy instructor;


    public CourseLazy() {
    }

    public CourseLazy(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CourseLazy{" +
                "id=" + id +
                ", title='" + title + '\'' +
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

    public InstructorLazy getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorLazy instructor) {
        this.instructor = instructor;
    }
}
