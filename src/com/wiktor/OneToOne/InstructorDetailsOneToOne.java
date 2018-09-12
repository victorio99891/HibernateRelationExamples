package com.wiktor.OneToOne;

import javax.persistence.*;
import javax.persistence.OneToOne;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetailsOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youTubeChannel;

    @Column(name = "hobby")
    private String hobby;


    // BIDIRECTIONAL, mappedBy variable name from InstructorOneToOne class which handle InstructorDetailsOneToOne
    // if you want to delete only the InstructionDetails without InstructorOneToOne you should add
    // cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} -> that's because there isn't type CascadeType.REMOVE
    @OneToOne(mappedBy = "details", cascade = {CascadeType.DETACH,CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    private InstructorOneToOne instructor;

    public InstructorOneToOne getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorOneToOne instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetailsOneToOne{" +
                "id=" + id +
                ", youTubeChannel='" + youTubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public InstructorDetailsOneToOne() {
    }

    public InstructorDetailsOneToOne(String youTubeChannel, String hobby) {
        this.youTubeChannel = youTubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYouTubeChannel() {
        return youTubeChannel;
    }

    public void setYouTubeChannel(String youTubeChannel) {
        this.youTubeChannel = youTubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
