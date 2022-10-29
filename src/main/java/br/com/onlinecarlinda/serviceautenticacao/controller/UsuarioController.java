package br.com.onlinecarlinda.serviceautenticacao.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.onlinecarlinda.serviceautenticacao.dto.TokenDto;
import br.com.onlinecarlinda.serviceautenticacao.dto.UsuarioDto;
import br.com.onlinecarlinda.serviceautenticacao.model.Usuario;
import br.com.onlinecarlinda.serviceautenticacao.model.UsuarioDetails;
import br.com.onlinecarlinda.serviceautenticacao.service.TokenService;

@RestController
@RequestMapping("/autenticacao")
public class UsuarioController {
	
	@Autowired
	UserDetailsManager userDetailsManager;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping("/register")
    public ResponseEntity<TokenDto> register(@RequestBody UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario(usuarioDto.getUsuario(), usuarioDto.getSenha());
		
		UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
        userDetailsManager.createUser(usuarioDetails);

        Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(usuarioDetails, usuarioDto.getSenha(), Collections.emptyList());

        return  ResponseEntity.status(HttpStatus.OK).body(tokenService.createToken(authentication));
    }

    /*@PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = daoAuthenticationProvider.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(loginDTO.getUsername(), loginDTO.getPassword()));

        return ResponseEntity.status(HttpStatus.OK).body(tokenGenerator.createToken(authentication));
    }*/

   /* @PostMapping("/token")
    public ResponseEntity<TokenDTO>  token(@RequestBody TokenDTO tokenDTO) {
        Authentication authentication = refreshTokenAuthProvider.authenticate(new BearerTokenAuthenticationToken(tokenDTO.getRefreshToken()));
        Jwt jwt = (Jwt) authentication.getCredentials();
        // check if present in db and not revoked, etc

        return ResponseEntity.status(HttpStatus.OK).body(tokenGenerator.createToken(authentication));
    }*/

}
