package com.vemser.rest.dto;

public class UsuariosRequest {

    private String nome;
    private String email;
    private String password;
    private String administrador;

    public UsuariosRequest() {}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "UsuariosRequest{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", administrador='" + administrador + '\'' +
                '}';
    }
}
