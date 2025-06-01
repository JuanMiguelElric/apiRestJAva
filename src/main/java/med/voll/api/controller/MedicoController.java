package med.voll.api.controller;


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


    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){

        repository.save(new Medico(dados));
    }

}
