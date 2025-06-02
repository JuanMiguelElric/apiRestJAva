package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.model.medico.DadosCadastroMedico;

import med.voll.api.model.medico.Medico;
import med.voll.api.model.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

}
