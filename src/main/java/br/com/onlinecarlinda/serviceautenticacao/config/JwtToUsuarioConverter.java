package br.com.onlinecarlinda.serviceautenticacao.config;

import java.util.Collections;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import br.com.onlinecarlinda.serviceautenticacao.model.Usuario;

@Component
public class JwtToUsuarioConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken>{
	
	@Override
    public UsernamePasswordAuthenticationToken convert(Jwt jwt) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(jwt.getSubject());
        return new UsernamePasswordAuthenticationToken(usuario, jwt, Collections.emptyList());
    }

}
