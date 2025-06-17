package med.voll.api.model.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.model.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosConsultasMedicas(




        Long idMedico,
        @NotNull
        Long idPaciente,

        @NotNull
        @Future

        LocalDateTime data,


        Especialidade especialidade
        ) {
}
