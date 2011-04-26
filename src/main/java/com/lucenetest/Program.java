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
@Table(name="PROGRAM")
@Indexed(index = "Program")
public class Program {
    @DocumentId(name="progId")
    @Id
    @Column(name="PROG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Field
    @Column(name="NAME")
    private String name;

    @Field
    @Column(name="SECRET_CODE")
    private String secretCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
}
