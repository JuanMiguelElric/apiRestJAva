package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.model.paciente.DadosCadastroPaciente;
import med.voll.api.model.paciente.Paciente;
import med.voll.api.model.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));

    }

}
