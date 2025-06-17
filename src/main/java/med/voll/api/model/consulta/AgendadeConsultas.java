package med.voll.api.model.consulta;


import med.voll.api.domain.ValidacaoException;
import med.voll.api.model.medico.Medico;
import med.voll.api.model.medico.MedicoRepository;
import med.voll.api.model.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AgendadeConsultas {

    //tem que chamar o autowired para que o spring ative o repository em nosso service
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

//lembrando adicionar as validações
    public void agendar(DadosConsultasMedicas dados){

        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw  new ValidacaoException("id do PAciente informado não existe");

        }
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw  new ValidacaoException("id do médico informado não existe")
        }

        
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null,medico, paciente, dados.data());
        consultaRepository.save(consulta);

    }

    private Medico escolherMedico(DadosConsultasMedicas dados){

        if (dados.idMedico() != null){
            return  medicoRepository.getReferenceById(dados.idMedico());
        }

        // se não houver o médico vai procurar um disponível

        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória quando o médico não é escolhido");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());



    }

}
