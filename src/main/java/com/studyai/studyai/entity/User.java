    package com.studyai.studyai.entity;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.Size;

    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Nome é obrigatorio")
        private String nome;

        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatorio")
        private String email;

        @NotBlank(message = " CPF é obrigatorio")
        private String cpf;

        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        private String senha;

        public User(){

        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }



    }
