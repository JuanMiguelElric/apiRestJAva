package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.voll.api.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String gerarToken(Usuario usuario){
        try {
            var algorithm = Algorithm.HMAC256();
            return JWT.create()
                    .withIssuer("Api Voll.med")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){

            throw new RuntimeException("erro ao gerar token jwt", exception);
            // Invalid Signing configuration / Couldn't convert Claims.
        }

        private Instant dataExpiracao(){
            return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
        }
    }

}
