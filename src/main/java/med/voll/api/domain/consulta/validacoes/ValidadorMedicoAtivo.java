package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.model.consulta.DadosConsultasMedicas;
import med.voll.api.model.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    private MedicoRepository repository;

    public void validar(DadosConsultasMedicas dados){
        // escolha do medico opcional
        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if(!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com médico");
        }
    }
}
