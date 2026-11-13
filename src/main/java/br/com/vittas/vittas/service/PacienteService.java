package br.com.vittas.vittas.service;

import br.com.vittas.vittas.model.Paciente;
import br.com.vittas.vittas.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente criar(Paciente paciente) { return repository.save(paciente); }
    public List<Paciente> listarTodos() { return repository.findAll(); }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado: " + id));
    }

    public Paciente atualizar(Long id, Paciente dados) {
        Paciente p = buscarPorId(id);
        p.setNome(dados.getNome());
        p.setCpf(dados.getCpf());
        p.setEmail(dados.getEmail());
        p.setTelefone(dados.getTelefone());
        p.setCartaoSus(dados.getCartaoSus());
        p.setDataNascimento(dados.getDataNascimento());
        return repository.save(p);
    }

    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }
}