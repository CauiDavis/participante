package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Teste{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private StringBuffer banner;
    public  Teste(){
    }
    public Teste(String nome,StringBuffer banner){
        this.nome = nome;
        this.banner = banner;
    }
    public Teste(Long id,String nome,StringBuffer banner){
        this.nome = nome;
        this.banner = banner;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setBanner(StringBuffer banner){
        this.banner = banner;
    }
    public Long getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public StringBuffer getBanner(){
        return banner;
    }
}