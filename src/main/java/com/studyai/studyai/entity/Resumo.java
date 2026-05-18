package com.studyai.studyai.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Resumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String conteudoOriginal;
    @Column(columnDefinition = "TEXT")
    private String resumoGerado;

    private LocalDateTime criadoEm;
    public Resumo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudoOriginal() {
        return conteudoOriginal;
    }

    public void setConteudoOriginal(String conteudoOriginal) {
        this.conteudoOriginal = conteudoOriginal;
    }

    public String getResumoGerado() {
        return resumoGerado;
    }

    public void setResumoGerado(String resumoGerado) {
        this.resumoGerado = resumoGerado;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
