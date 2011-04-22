package com.lucenetest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.search.annotations.*;

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
@Indexed(index = "Education")
public class Education {

    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EDUCATION_ID")
    private Long id;

    @Field(store = Store.YES, name="e_degreeCode")
    @Column(name="DEGREE_CODE")
    private String degreeCode;

    @Field(store = Store.YES)
    @Column(name="INSTITUTION")
    private String institution;

    @Field(store = Store.YES, name="e_degreeYear")
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

    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
