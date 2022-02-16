package com.estudos.criptografia.domain;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String document;

    @Column
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
