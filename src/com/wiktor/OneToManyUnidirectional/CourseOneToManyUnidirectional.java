package com.wiktor.OneToManyUnidirectional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class CourseOneToManyUnidirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private InstructorOneToManyUnidirectional instructor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = {CascadeType.ALL})
    private List<ReviewOneToManyUnidirectional> comments_list;

    public void add(ReviewOneToManyUnidirectional review) {
        if (comments_list == null) {
            comments_list = new ArrayList<>();
        }
        comments_list.add(review);
        review.setCourse(this);
    }

    public CourseOneToManyUnidirectional() {
    }

    public CourseOneToManyUnidirectional(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CourseOneToManyUnidirectional{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                ", comments_list=" + comments_list +
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

    public InstructorOneToManyUnidirectional getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorOneToManyUnidirectional instructor) {
        this.instructor = instructor;
    }

    public List<ReviewOneToManyUnidirectional> getComments_list() {
        return comments_list;
    }

    public void setComments_list(List<ReviewOneToManyUnidirectional> comments_list) {
        this.comments_list = comments_list;
    }
}
