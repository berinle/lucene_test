package com.lucenetest;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: berinle
 * Date: 4/22/11
 * Time: 8:27 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="PUBLICATION")
@Indexed(index = "Publication")
public class Publication {
    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PUB_ID")
    private Long id;

    @Field(store = Store.YES)
    @Column(name="AUTHOR")
    private String author;

    @Field(store = Store.YES)
    @Column(name="NAME")
    private String name;

    @Field(store = Store.YES)
    @Column(name="PUB_DATE")
    private Date publicationDate;

    @Field(store = Store.YES)
    @Column(name="NO_PAGES")
    private int pages;

    @Field(store = Store.YES)
    @Column(name="PUB_TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name="STUDENT_ID", insertable = false, updatable = false)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Student getStudent() {
        return student;
    }
}
