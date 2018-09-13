package com.wiktor.ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseManyToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private InstructorManyToMany instructor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = {CascadeType.ALL})
    private List<ReviewManyToMany> comments_list;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList;


    public void addStudent(Student student) {
        if (studentList == null) {
            studentList = new ArrayList<>();
        }
        studentList.add(student);
    }


    public void add(ReviewManyToMany review) {
        if (comments_list == null) {
            comments_list = new ArrayList<>();
        }
        comments_list.add(review);
        review.setCourse(this);
    }

    public CourseManyToMany() {
    }

    public CourseManyToMany(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CourseManyToMany{" +
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

    public InstructorManyToMany getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorManyToMany instructor) {
        this.instructor = instructor;
    }

    public List<ReviewManyToMany> getComments_list() {
        return comments_list;
    }

    public void setComments_list(List<ReviewManyToMany> comments_list) {
        this.comments_list = comments_list;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
