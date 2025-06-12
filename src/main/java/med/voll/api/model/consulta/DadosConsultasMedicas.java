package med.voll.api.model.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosConsultasMedicas(




        Long idMedico,
        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyy HH:mm")
        LocalDateTime data
        ) {
}
