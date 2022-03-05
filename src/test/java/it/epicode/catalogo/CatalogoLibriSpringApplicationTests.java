package it.epicode.catalogo;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.epicode.catalogo.repository.LibriRepository;

@SpringBootTest
class CatalogoLibriSpringApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	LibriRepository lrepo;
	
	@Test
	void libriRepoNotNull() {
		assertNotNull(lrepo);
	}
	
	@Test
	void libriRepoFunziona() {
		assertThatNoException();
	}

}
