package it.epicode.catalogo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.epicode.catalogo.model.security.User;
import it.epicode.catalogo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

}
