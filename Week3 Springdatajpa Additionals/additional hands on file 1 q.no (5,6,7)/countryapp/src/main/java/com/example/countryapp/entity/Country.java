package com.example.countryapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
    @Id
    private String coCode;
    private String coName;

    public Country() {}

    public Country(String coCode, String coName) {
        this.coCode = coCode;
        this.coName = coName;
    }

    public String getCoCode() {

        return coCode;
    }

    public void setCoCode(String coCode) {

        this.coCode = coCode;
    }

    public String getCoName() {

        return coName;
    }

    public void setCoName(String coName) {

        this.coName = coName;
    }
}
