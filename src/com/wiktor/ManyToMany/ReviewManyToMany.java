package com.wiktor.ManyToMany;


import javax.persistence.*;

@Entity
@Table(name = "review")
public class ReviewManyToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    private CourseManyToMany course;


    @Override
    public String toString() {
        return "ReviewManyToMany{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }


    public ReviewManyToMany() {
    }

    public ReviewManyToMany(String comment) {
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

    public CourseManyToMany getCourse() {
        return course;
    }

    public void setCourse(CourseManyToMany course) {
        this.course = course;
    }
}
