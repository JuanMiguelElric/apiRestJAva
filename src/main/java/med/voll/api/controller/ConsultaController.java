package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.consulta.AgendadeConsultas;
import med.voll.api.model.consulta.DadosConsultasMedicas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private AgendadeConsultas agenda.

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid DadosConsultasMedicas dados){
        agenda.agendar(dados);
    }
}
