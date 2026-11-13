package br.com.vittas.vittas.model;

public interface IAutenticavel {
    boolean autenticar(String login, String senha);
    void alterarSenha(String novaSenha);
}