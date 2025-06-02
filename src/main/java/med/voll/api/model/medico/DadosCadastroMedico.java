package med.voll.api.model.medico;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotNull
        String nome,

        //NotBlank é so para campos string
        @NotBlank
        @Email
        String email,

        @NotBlank
        //para verificar o crm
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,
        @NotNull @Valid  DadosEndereco endereco) {
}
