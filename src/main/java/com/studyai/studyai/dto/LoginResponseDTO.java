package com.studyai.studyai.dto;

public class LoginResponseDTO {

    private String mensagem;

    private String token;

    public LoginResponseDTO(){
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
