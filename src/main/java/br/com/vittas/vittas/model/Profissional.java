package br.com.vittas.vittas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "profissional")
@DiscriminatorValue("Profissional")
public class Profissional extends Pessoa {

    @Column(unique = true, length = 20)
    private String crm;

    @Column(length = 100)
    private String especialidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidade_id")
    @JsonIgnore
    private UnidadeSaude unidade;

    public Profissional() {}

    public Profissional(String nome, String cpf, String email, String telefone, String crm, String especialidade) {
        super(nome, cpf, email, telefone);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    @Override
    public String getTipo() { return "Profissional"; }

    @Override
    public String exibirResumo() {
        return "Profissional: " + getNome() + " | Especialidade: " + especialidade + " | CRM: " + crm;
    }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public UnidadeSaude getUnidade() { return unidade; }
    public void setUnidade(UnidadeSaude unidade) { this.unidade = unidade; }
}
