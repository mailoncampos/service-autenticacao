package br.com.onlinecarlinda.serviceautenticacao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {
	
	private String usuario;
	
	private String senha;

}
