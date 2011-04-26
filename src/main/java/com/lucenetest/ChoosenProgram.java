package com.lucenetest;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;

/**
 * @author berinle
 */
@Entity
@Table(name="PROGRAM_ASSIGNMENT")
public class ChoosenProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Field(store = Store.YES)
    @Column(name="STUDENT_ID", insertable = false, updatable = false)
    private Long studentId;

    @Field(store = Store.YES)
    @Column(name="PROGRAM_ID", insertable = false, updatable = false)
    private Long programId;

    @ManyToOne @JoinColumn(name = "STUDENT_ID", insertable = false, updatable = false, nullable = false)
    private Student student;
    @ManyToOne @JoinColumn(name = "PROGRAM_ID", insertable = false, updatable = false, nullable = false)
    private Program program;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
