package br.com.onlinecarlinda.serviceautenticacao.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import br.com.onlinecarlinda.serviceautenticacao.model.Usuario;
import br.com.onlinecarlinda.serviceautenticacao.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsManager{
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	 @Autowired
	 PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackOn = Exception.class) 
	public void createUser(UserDetails user) {
		
		Usuario usuario = new Usuario(user.getUsername(), passwordEncoder.encode(user.getPassword()));
		
		usuario = usuarioRepository.save(usuario);
				
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	


}
