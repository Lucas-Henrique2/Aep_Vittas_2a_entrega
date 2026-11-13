package br.com.vittas.vittas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gestor")
@DiscriminatorValue("Gestor")
public class Gestor extends Pessoa implements IAutenticavel {

    @Id
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String login;

    @Column(nullable = false, length = 255)
    private String senha;

    public Gestor() {}

    public Gestor(String nome, String cpf, String email, String telefone, String login, String senha) {
        super(nome, cpf, email, telefone);
        this.login = login;
        this.senha = senha;
    }

    @Override
    public String getTipo() { return "Gestor"; }

    @Override
    public String exibirResumo() {
        return "Gestor: " + getNome() + " | Login: " + login;
    }

    private String getNome() {
        return null;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public void alterarSenha(String novaSenha) { this.senha = novaSenha; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
