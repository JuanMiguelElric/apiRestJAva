package med.voll.api.controller;


import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.medico.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    /*
    Obs: Cuidado na hora de importar. Selecione Pageable org.springframework.data.domain e não Pageable java.awt.print. A segunda não é aplicável ao Spring Framework.*/
   //PageableDefault ele vai carregar na url 10 registros do db, adicionando o metodo sort ele vai ordenar de acordo com aquilo que for adicionado entre cochetes do short

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10) Pageable paginacao){

        // estou listando com dto apenas oque vai ser preciso para apresentar na listagem de medicos
        return repository.findAll(paginacao).map(DadosListagemMedico::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid  DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }

}
