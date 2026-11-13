package br.com.vittas.vittas.model;

import br.com.vittas.vittas.model.OcorrenciaAgendamento;
import br.com.vittas.vittas.model.UnidadeSaude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 30)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidade_id", nullable = false)
    @JsonIgnore
    private UnidadeSaude unidade;

    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OcorrenciaAgendamento> ocorrencias = new ArrayList<>();

    public Agendamento() {}

    public Agendamento(LocalDateTime dataHora, String status, Paciente paciente, Profissional profissional) {
        this.dataHora = dataHora;
        this.status = status;
        this.paciente = paciente;
        this.profissional = profissional;
    }

    public void adicionarOcorrencia(OcorrenciaAgendamento ocorrencia) {
        ocorrencias.add(ocorrencia);
        ocorrencia.setAgendamento(this);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public UnidadeSaude getUnidade() { return unidade; }
    public void setUnidade(UnidadeSaude unidade) { this.unidade = unidade; }

    public List<OcorrenciaAgendamento> getOcorrencias() { return ocorrencias; }
    public void setOcorrencias(List<OcorrenciaAgendamento> ocorrencias) { this.ocorrencias = ocorrencias; }
}
