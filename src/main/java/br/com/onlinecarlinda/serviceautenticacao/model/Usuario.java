package br.com.onlinecarlinda.serviceautenticacao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.onlinecarlinda.serviceautenticacao.dto.UsuarioDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "usuario", schema = "dominio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String usuario;
	
	@Column
	private String senha;
	
	public Usuario(UsuarioDto usuarioDto) {
		this.usuario = usuarioDto.getUsuario();
		this.senha = usuarioDto.getSenha();
	}

	public Usuario(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

}
