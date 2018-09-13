package com.wiktor.OneToManyUnidirectional;


import com.wiktor.OneToManyUnidirectional.CourseOneToManyUnidirectional;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class ReviewOneToManyUnidirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    private CourseOneToManyUnidirectional course;


    @Override
    public String toString() {
        return "ReviewManyToMany{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }


    public ReviewOneToManyUnidirectional() {
    }

    public ReviewOneToManyUnidirectional(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CourseOneToManyUnidirectional getCourse() {
        return course;
    }

    public void setCourse(CourseOneToManyUnidirectional course) {
        this.course = course;
    }
}
