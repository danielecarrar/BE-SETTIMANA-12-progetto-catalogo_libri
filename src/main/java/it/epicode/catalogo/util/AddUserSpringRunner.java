package it.epicode.catalogo.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.epicode.catalogo.model.security.Role;
import it.epicode.catalogo.model.security.Roles;
import it.epicode.catalogo.model.security.User;
import it.epicode.catalogo.repository.RoleRepository;
import it.epicode.catalogo.repository.UserRepository;


@Component
public class AddUserSpringRunner implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		
		Role roleU = new Role();
		roleU.setRoleName(Roles.ROLE_USER);
		
		Role role = new Role();
		role.setRoleName(Roles.ROLE_ADMIN);
		User user = new User();
		Set<Role> roles = new HashSet<>(); 
		roles.add(role);
		user.setUserName("admin");
		user.setPassword(bCrypt.encode("admin"));
		user.setEmail("admin@domain.com");
		user.setRoles(roles);
		user.setActive(true);
		
		roleRepository.save(role);
		userRepository.save(user);
		roleRepository.save(roleU);

	}

}
