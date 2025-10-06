package org.example.agenda_api.controller;

import org.example.agenda_api.model.Contato;
import org.example.agenda_api.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping
    public List<Contato> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Contato> buscar(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Contato criar(@RequestBody Contato contato) {
        return repository.save(contato);
    }

    @PutMapping("/{id}")
    public Contato atualizar(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
        return repository.findById(id)
                .map(contato -> {
                    contato.setNome(contatoAtualizado.getNome());
                    contato.setTelefone(contatoAtualizado.getTelefone());
                    contato.setEmail(contatoAtualizado.getEmail());
                    return repository.save(contato);
                })
                .orElseGet(() -> {
                    contatoAtualizado.setId(id);
                    return repository.save(contatoAtualizado);
                });
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        repository.deleteById(id);
    }

    private final ContatoRepository contatoRepository;

    public ContatoController(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @GetMapping("/contatos")
    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }

    @PutMapping("/contatos/{id}")
    public ResponseEntity<Contato> atualizarContato(
            @PathVariable Long id,
            @RequestBody Contato contatoAtualizado) {

        return contatoRepository.findById(id)
                .map(contato -> {
                    contato.setNome(contatoAtualizado.getNome());
                    contato.setTelefone(contatoAtualizado.getTelefone());
                    contato.setEmail(contatoAtualizado.getEmail());
                    contatoRepository.save(contato);
                    return ResponseEntity.ok(contato);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/contatos/{id}")
    public ResponseEntity<?> deletarContato(@PathVariable Long id) {
        return contatoRepository.findById(id)
                .map(contato -> {
                        contatoRepository.delete(contato);
                        return ResponseEntity.noContent().build(); // 204
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
    }
}
