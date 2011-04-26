package com.lucenetest;

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

/**
 * @author berinle
 */
@Entity
@Table(name="SCORE")
@Indexed(index="Score")
public class Score {
    @Id
    @DocumentId(name="scoreId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SCORE_ID")
    private Long id;

    @Field
    @Column(name="score")
    private int score;

    @ContainedIn
    @ManyToOne @JoinColumn(name="PROGRAM_ID", insertable = false, updatable = false, nullable = false)
    private Program program;

    @ContainedIn
    @ManyToOne @JoinColumn(name="STUDENT_ID", insertable = false, updatable = false, nullable = false)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
