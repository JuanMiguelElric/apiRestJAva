package med.voll.api.model.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.endereco.Endereco;
import med.voll.api.model.medico.DadosAtualizacaoMedico;
import med.voll.api.model.medico.DadosCadastroMedico;

@Table(name="pacientes")
@Entity(name="Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    @Embedded

    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco();
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

}
