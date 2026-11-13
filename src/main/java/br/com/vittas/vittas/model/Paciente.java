package br.com.vittas.vittas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "paciente")
@DiscriminatorValue("Paciente")
public class Paciente extends Pessoa {

    @Column(name = "cartao_sus", unique = true, length = 20)
    private String cartaoSus;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Paciente() {}

    public Paciente(String nome, String cpf, String email, String telefone, String cartaoSus, LocalDate dataNascimento) {
        super(nome, cpf, email, telefone);
        this.cartaoSus = cartaoSus;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getTipo() { return "Paciente"; }

    @Override
    public String exibirResumo() {
        return "Paciente: " + getNome() + " | CPF: " + getCpf() + " | Cartão SUS: " + (cartaoSus != null ? cartaoSus : "não informado");
    }

    public String getCartaoSus() { return cartaoSus; }
    public void setCartaoSus(String cartaoSus) { this.cartaoSus = cartaoSus; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}
