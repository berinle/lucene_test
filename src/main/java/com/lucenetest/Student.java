package com.lucenetest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: 4/21/11
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="STUDENT")
@Indexed(index = "Student")
public class Student {
    @Id @DocumentId
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="STUDENT_ID")
    private Long id;

    @Field(store = Store.YES)
    @Column(name="FNAME")
    private String firstName;

    @Field(store = Store.YES)
    @Column(name="LNAME")
    private String lastName;

    @IndexedEmbedded
    @OneToMany(mappedBy = "student")
    private Set<Education> educations;

    @IndexedEmbedded
    @OneToMany(mappedBy = "student")
    private Set<Publication> publications;

    @IndexedEmbedded
    @OneToMany(mappedBy = "student")
    private Set<Medical> medicals;

    @IndexedEmbedded
    @OneToMany(mappedBy = "student")
    private Set<ChoosenProgram> programs;


    @IndexedEmbedded
    @OneToMany(mappedBy = "student")
    private Set<Score> scores;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }

    public Set<ChoosenProgram> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<ChoosenProgram> programs) {
        this.programs = programs;
    }

    public Set<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Set<Publication> publications) {
        this.publications = publications;
    }

    public Set<Medical> getMedicals() {
        return medicals;
    }

    public void setMedicals(Set<Medical> medicals) {
        this.medicals = medicals;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
}
