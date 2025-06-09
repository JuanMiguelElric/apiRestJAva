package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.infra.security.DadosTokenJwt;
import med.voll.api.infra.security.TokenService;
import med.voll.api.model.usuario.DadosdeAuthenticacaoUSer;
import med.voll.api.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosdeAuthenticacaoUSer dados){
       var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);

        //tem que criar uma classe para gerar o token

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());


        return ResponseEntity.ok(new DadosTokenJwt(tokenJWT));
    }


}
