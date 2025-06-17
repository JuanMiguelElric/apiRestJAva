package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.model.consulta.DadosConsultasMedicas;

import java.time.DayOfWeek;

public class ValidadorhorarioFuncionamentoClinica {

    public void validar(DadosConsultasMedicas dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var antesDaAberturadaClinica = dataConsulta.getHour() < 7;
        var deposDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if( domingo || antesDaAberturadaClinica || deposDoEncerramentoDaClinica){
            throw  new ValidacaoException("Consulta fora do horário de atendimento da clinica");
        }

    }
}
