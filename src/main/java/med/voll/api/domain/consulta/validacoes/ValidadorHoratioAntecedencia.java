package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.model.consulta.DadosConsultasMedicas;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHoratioAntecedencia implements ValidadorAgendamentodeConsulta {

    public void validar(DadosConsultasMedicas dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedência minima de 30 minutos");
        }
    }
}
