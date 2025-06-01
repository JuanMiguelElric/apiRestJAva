package med.voll.api.model.paciente;

import med.voll.api.model.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
}
