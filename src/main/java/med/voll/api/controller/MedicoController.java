package med.voll.api.controller;


import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.medico.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    //@valid ativa o Bin Validation
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uribuilder){
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uribuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri() ;
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }
    /*
    Obs: Cuidado na hora de importar. Selecione Pageable org.springframework.data.domain e não Pageable java.awt.print. A segunda não é aplicável ao Spring Framework.*/
   //PageableDefault ele vai carregar na url 10 registros do db, adicionando o metodo sort ele vai ordenar de acordo com aquilo que for adicionado entre cochetes do short

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemMedico::new)
        // estou listando com dto apenas oque vai ser preciso para apresentar na listagem de medicos
        return ResponseEntity.ok(page) ;

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid  DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));

    }

    //essa exclusão elimina do bando de dados
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));

    }

    //detalhando dados da api




}
