package med.voll.api.controller;


import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import med.voll.api.model.medico.DadosCadastroMedico;

import med.voll.api.model.medico.DadosListagemMedico;
import med.voll.api.model.medico.Medico;
import med.voll.api.model.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    //@valid ativa o Bin Validation
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        repository.save(new Medico(dados));
    }
    @GetMapping
    public List<DadosListagemMedico> listar(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();

    }

}
