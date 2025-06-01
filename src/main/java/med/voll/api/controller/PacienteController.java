package med.voll.api.controller;


import med.voll.api.model.paciente.DadosCadastroPaciente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @GetMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados){
        System.out.println(dados);

    }

}
