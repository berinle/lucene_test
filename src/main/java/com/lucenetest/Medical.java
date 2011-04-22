package com.lucenetest;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: 4/22/11
 * Time: 8:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="MEDICAL")
@Indexed(index = "Medical")
public class Medical {
   @Id
   @DocumentId
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="MEDICAL_ID")
    private Long id;

    @Field(store = Store.NO, name = "m_institution")
    @Column(name="INST_NAME")
    private String institution;

    @Field(store = Store.NO, name = "m_degreeCode")
    @Column(name="DEGREE_CODE")
    private String degreeCode;

    @Field(store = Store.NO, name = "m_degreeYear")
    @Column(name="DEGREE_YR")
    private String degreeYear;

    @ManyToOne
    @JoinColumn(name="STUDENT_ID", insertable = false, updatable = false)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDegreeCode() {
        return degreeCode;
    }

    public void setDegreeCode(String degreeCode) {
        this.degreeCode = degreeCode;
    }

    public String getDegreeYear() {
        return degreeYear;
    }

    public void setDegreeYear(String degreeYear) {
        this.degreeYear = degreeYear;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

