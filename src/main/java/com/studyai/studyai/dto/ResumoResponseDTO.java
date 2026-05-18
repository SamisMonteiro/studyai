package com.studyai.studyai.dto;

import java.util.List;

public class ResumoResponseDTO {
    private String titulo;
    private String resumo;
    private List<String> perguntas;

    public ResumoResponseDTO() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<String> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<String> perguntas) {
        this.perguntas = perguntas;
    }
}
