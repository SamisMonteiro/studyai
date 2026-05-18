package com.studyai.studyai.dto;

import jakarta.validation.constraints.NotBlank;

public class ResumoRequestDTO {

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Conteúdo é obrigatório")
    private String conteudo;

    public ResumoRequestDTO() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

}
