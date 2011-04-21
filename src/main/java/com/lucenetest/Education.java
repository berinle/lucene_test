package com.lucenetest;

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: 4/21/11
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="EDUCATION")
public class Education {

    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EDUCATION_ID")
    private Long id;

    @Field
    @Column(name="DEGREE_CODE")
    private String degreeCode;

    @Field
    @Column(name="INSTITUTION")
    private String institution;

    @Field
    @Column(name="DEGREE_YR")
    private int degreeYear;

    @ContainedIn
    @ManyToOne @JoinColumn(name="STUDENT_ID", insertable = false, updatable = false)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegreeCode() {
        return degreeCode;
    }

    public void setDegreeCode(String degreeCode) {
        this.degreeCode = degreeCode;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getDegreeYear() {
        return degreeYear;
    }

    public void setDegreeYear(int degreeYear) {
        this.degreeYear = degreeYear;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
