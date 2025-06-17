package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.model.consulta.ConsultaRepository;
import med.voll.api.model.consulta.DadosConsultasMedicas;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentodeConsulta {

    private ConsultaRepository repository;

    @Override
    public void validar(DadosConsultasMedicas dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.exist(dados.idMedico());

        if(medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Medico já possui outra consulta agendada nesse mesmo horario");
        }

    }
}
