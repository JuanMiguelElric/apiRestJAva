package med.voll.api.domain.consulta.validacoes;

import med.voll.api.model.consulta.ConsultaRepository;
import med.voll.api.model.consulta.DadosConsultasMedicas;

public class ValidarPacienteOutraConsulta implements ValidadorAgendamentodeConsulta{
    private ConsultaRepository repository;

    public void validar(DadosConsultasMedicas dados){
        var primeiroHorario = dados.data().withHour(7);
        var utlimoHorario = dados.data().withHour(10);

        //tem que criar um exist de paciente em repository

    }
}
