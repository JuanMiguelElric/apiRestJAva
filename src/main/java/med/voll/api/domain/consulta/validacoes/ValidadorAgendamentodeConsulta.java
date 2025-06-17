package med.voll.api.domain.consulta.validacoes;

import med.voll.api.model.consulta.DadosConsultasMedicas;

public interface ValidadorAgendamentodeConsulta {
    void validar(DadosConsultasMedicas dados);
}
