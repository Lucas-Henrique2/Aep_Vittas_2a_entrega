package br.com.vittas.vittas.service;

import com.vittas.model.Paciente;
import com.vittas.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente criar(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado: " + id));
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente atualizar(Long id, Paciente dados) {
        Paciente existente = buscarPorId(id);
        existente.setNome(dados.getNome());
        existente.setCpf(dados.getCpf());
        existente.setEmail(dados.getEmail());
        existente.setTelefone(dados.getTelefone());
        existente.setCartaoSus(dados.getCartaoSus());
        existente.setDataNascimento(dados.getDataNascimento());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}