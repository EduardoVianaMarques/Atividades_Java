package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_projeto")
public class ProjetoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    private LocalDate datainicio;
    private LocalDate datafim;

    public ProjetoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }

    public LocalDate getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDate datafim) {
        this.datafim = datafim;
    }
}
