package com.kidunion.children.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kidunion.legalresponsible.domain.LegalResponsible;

import javax.persistence.*;
import java.util.Date;

@Table(name = "children")
@Entity
public class Children {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateofBirth;
    @Column(nullable = false)
    private String school;
    @Column(nullable = false)
    private String tshirts;
    @Column(nullable = false)
    private String jeans;
    @Column(nullable = false)
    private String shoes;
    @Column(nullable = false)
    private String degree;
    @OneToOne()
    private LegalResponsible legalResponsible;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public String getSchool() {
        return school;
    }

    public String getTshirts() {
        return tshirts;
    }

    public String getJeans() {
        return jeans;
    }

    public String getShoes() {
        return shoes;
    }

    public String getDegree() {
        return degree;
    }

    public LegalResponsible getLegalResponsible() {
        return legalResponsible;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setTshirts(String tshirts) {
        this.tshirts = tshirts;
    }

    public void setJeans(String jeans) {
        this.jeans = jeans;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setLegalResponsible(LegalResponsible legalResponsible) {
        this.legalResponsible = legalResponsible;
    }
}
