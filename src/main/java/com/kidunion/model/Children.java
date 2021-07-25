package com.kidunion.model;

import java.util.Date;

public class Children {
    private Long id;
    private String name;
    private String lastName;
    private Date dateofBirth;
    private String school;
    private String tshirts;
    private String jeans;
    private String shoes;
    private String degree;
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
