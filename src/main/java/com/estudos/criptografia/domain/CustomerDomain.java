package com.estudos.criptografia.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class CustomerDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String document;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public CustomerDomain setDocument(String document) {
        this.document = document;
        return this;
    }


}
